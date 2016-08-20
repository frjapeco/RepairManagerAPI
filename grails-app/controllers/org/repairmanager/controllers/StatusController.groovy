package org.repairmanager.controllers

import grails.rest.RestfulController
import grails.plugin.springsecurity.annotation.Secured
import org.repairmanager.domains.Status
import org.repairmanager.exceptions.StatusNotFoundException

class StatusController extends RestfulController {
    static responseFormats = ['json']

    StatusController() {
        super(Status)
    }

    @Override
    protected void notFound() {
        throw new StatusNotFoundException()
    }

    @Override
    protected Status queryForResource(Serializable id) {
        def status = Status.findById(id as int)

        if (!status)
            notFound()
        return status
    }

    @Secured(['permitAll'])
    @Override
    def index() {
        super.index()
    }

    @Secured(['permitAll'])
    @Override
    def show() {
        super.show()
    }
}
