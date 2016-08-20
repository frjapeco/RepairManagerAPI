package org.repairmanager.controllers

import grails.rest.RestfulController
import grails.plugin.springsecurity.annotation.Secured

import org.repairmanager.exceptions.ModelNotFoundException

import org.repairmanager.domains.Model

class ModelController extends RestfulController {
    static responseFormats = ['json']
    ModelController() {
        super(Model)
    }

    @Override
    protected void notFound() {
        throw new ModelNotFoundException()
    }

    @Override
    protected Model queryForResource(Serializable id) {
        def model = Model.findById(id as int)

        if (!model)
            notFound()

        return model
    }

    @Secured('permitAll')
    @Override
    def index() {
        super.index()
    }

    @Secured('permitAll')
    @Override
    def show() {
        super.show()
    }
}
