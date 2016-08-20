package org.repairmanager.controllers

import org.repairmanager.exceptions.ValidationFailedException
import org.repairmanager.exceptions.ErrorResponse

class ErrorController {
    static responseFormats = ['json']

    def resourceNotFound() {
        String msg = message(code: 'resource.not.found')
        response.status = 404
        respond new ErrorResponse(1000,response.status,msg)
    }

    def methodNotAllowed() {
        String msg = message(code: 'method.not.allowed')
        response.status = 405
        respond new ErrorResponse(1001,response.status,msg)
    }

    def internalServerError() {
        String msg = message(code: 'internal.server.error')
        response.status = 500
        respond new ErrorResponse(1002,response.status,msg)
    }

    def badNumberFormat() {
        String msg = message(code: 'bad.number.format')
        response.status = 500
        respond new ErrorResponse(1003,response.status,msg)
    }

    def unauthorized() {
        String msg = message(code: 'unauthorized')
        response.status = 401
        respond new ErrorResponse(1004,response.status,msg)
    }

    def forbidden() {
        String msg = message(code: 'forbidden')
        response.status = 403
        respond new ErrorResponse(1005,response.status,msg)
    }

    def validationFailed() {
        def exception = request.exception.cause.cause as ValidationFailedException
        def errorList = new ArrayList<ErrorResponse>()

        response.status = 422
        exception.errors.each { errorMsg->
            errorList.push(new ErrorResponse(1006,response.status,errorMsg))
        }
        respond errorList
    }

    def resolutionRequired() {
        String msg = message(code: 'resolution.required')
        response.status = 422
        respond new ErrorResponse(1007,response.status,msg)
    }

    def statusNotFound() {
        String msg = message(code: 'status.not.found')
        response.status = 404
        respond new ErrorResponse(1008,response.status,msg)
    }

    def modelNotFound() {
        String msg = message(code: 'model.not.found')
        response.status = 404
        respond new ErrorResponse(1009,response.status,msg)
    }

    def userNotFound() {
        String msg = message(code: 'user.not.found')
        response.status = 404
        respond new ErrorResponse(1010,response.status,msg)
    }

    def technicianRequired() {
        String msg = message(code: 'technician.required')
        response.status = 400
        respond new ErrorResponse(1011,response.status,msg)
    }

    def incidenceNotFound() {
        String msg = message(code: 'incidence.not.found')
        response.status = 404
        respond new ErrorResponse(1012,response.status,msg)
    }

}
