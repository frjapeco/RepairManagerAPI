package org.repairmanager.controllers

import grails.rest.RestfulController
import grails.plugin.springsecurity.annotation.Secured
import net.minidev.json.JSONObject
import org.repairmanager.domains.Status
import org.repairmanager.domains.User
import org.repairmanager.domains.Incidence
import org.repairmanager.domains.Model
import org.repairmanager.exceptions.DeniedAccessException
import org.repairmanager.exceptions.ResolutionRequiredException
import org.repairmanager.exceptions.ValidationFailedException
import org.repairmanager.exceptions.IncidenceNotFoundException
import org.repairmanager.exceptions.StatusNotFoundException
import org.repairmanager.exceptions.ModelNotFoundException
import org.repairmanager.exceptions.TechnicianRequiredException
import org.repairmanager.jwt.JwtDecoder

class IncidenceController extends RestfulController {
    static responseFormats = ['json']
    static allowedMethods = [count: ['GET'], assignToMe: ['PUT'], free: ['PUT']]

    IncidenceController() {
        super(Incidence)
    }

    protected static boolean validate(Incidence incidence) {
        if (!incidence.validate())
            throw new ValidationFailedException(incidence.errors)
        if (!Model.get(incidence.model.id))
            throw new ModelNotFoundException()
        if (!Status.get(incidence.status.id))
            throw new StatusNotFoundException()
        if (incidence.status.name == "SOLVED" && (!incidence.resolution || incidence.resolution.isEmpty()))
            throw new ResolutionRequiredException()
        return true
    }

    @Override
    protected void notFound() {
        throw new IncidenceNotFoundException()
    }

    @Override
    protected Incidence queryForResource(Serializable id) {
        def incidence = Incidence.findById(id as int)

        if (!incidence)
            notFound()
        return incidence
    }

    @Secured('ROLE_TECHNICIAN')
    def count() {
        render Incidence.createCriteria().list() {
            and {
                if (params.technician)
                    eq("technician",User.findByUsername(params.technician as String))
                if (params.status)
                    eq("status",Status.findByName(params.status as String))
                if (params.searchPattern)
                    or {
                        like("sn",(params.searchPattern + "%") as String)

                        def models = Model.findAllByNameLike("%" + (String)params.searchPattern + "%")
                        def statuses = Status.findAllByNameLike("%" + (String)params.searchPattern + "%")
                        def users = User.findAllByUsernameLike("%" + (String)params.searchPattern + "%")

                        if (models.size() > 0)
                            'in'("model",models)
                        if (statuses.size() > 0)
                            'in'("status",statuses)
                        if (users.size() > 0)
                            'in'("technician",users)
                    }
            }
        }.size()
    }

    @Secured('ROLE_TECHNICIAN')
    @Override
    def index() {
        respond Incidence.createCriteria().list(offset: params.offset, max: params.max, sort: 'id') {
            and {
                if (params.technician)
                    eq("technician",User.findByUsername(params.technician as String))
                if (params.status)
                    eq("status",Status.findByName(params.status as String))
                if (params.searchPattern)
                    or {
                        like("sn",(params.searchPattern + "%") as String)

                        def models = Model.findAllByNameLike("%" + (String)params.searchPattern + "%")
                        def statuses = Status.findAllByNameLike("%" + (String)params.searchPattern + "%")
                        def users = User.findAllByUsernameLike("%" + (String)params.searchPattern + "%")

                        if (models.size() > 0)
                            'in'("model",models)
                        if (statuses.size() > 0)
                            'in'("status",statuses)
                        if (users.size() > 0)
                            'in'("technician",users)
                    }
            }
        }
    }

    @Secured('permitAll')
    @Override
    def show() {
        super.show()
    }

    @Secured('permitAll')
    @Override
    def save() {
        def incidence = createResource() as Incidence

        incidence.status = Status.findByName("PENDING")
        incidence.technician = null
        validate(incidence)
        incidence.save()
        sendMail {
            async true
            to incidence.clientMail
            subject message(code: "new.incidence.was.created")
            html g.render(template:"/mail/newIncidence", model: [incidence: incidence])
        }
        response.status = 201
    }

    @Secured('ROLE_TECHNICIAN')
    @Override
    def update() {
        def incidence = queryForResource(params.id as Serializable)

        if (!incidence.technician)
            throw new TechnicianRequiredException()

        def token = new JwtDecoder(request.getHeader("Authorization"))
        def user = User.findByUsername(token.getPayload()["sub"] as String)

        if (user != incidence.technician)
            throw new DeniedAccessException()
        bindData(incidence, request.JSON, [exclude: ['technician']])
        validate(incidence)
        incidence.save()
        if (incidence.status.name == "SOLVED") {
            sendMail {
                async true
                to incidence.clientMail
                subject message(code: "incidence.was.solved")
                html g.render(template: "/mail/solvedIncidence", model: [incidence: incidence])
            }
        }
        response.status = 200
    }

    @Secured('ROLE_TECHNICIAN')
    def assignToMe() {
        def incidence = queryForResource(params.id as Serializable)

        if (incidence.technician)
            throw new DeniedAccessException()

        def token = new JwtDecoder(request.getHeader("Authorization"))
        def user = User.findByUsername(token.getPayload()["sub"] as String)

        incidence.technician = user
        validate(incidence)
        incidence.save()
        response.status = 200
    }

    @Secured('ROLE_TECHNICIAN')
    def free() {
        def incidence = queryForResource(params.id as Serializable)
        def token = new JwtDecoder(request.getHeader("Authorization"))
        def user = User.findByUsername(token.getPayload()["sub"] as String)

        if (user != incidence.technician)
            throw new DeniedAccessException()
        incidence.technician = null
        validate(incidence)
        response.status = 200
    }
}
