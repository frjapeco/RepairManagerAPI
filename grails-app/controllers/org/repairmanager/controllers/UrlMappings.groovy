package org.repairmanager.controllers

import org.repairmanager.exceptions.*

class UrlMappings {

    static mappings = {
        // API mapping:
        group ("/api") {
            "/incidences"                           (resources: 'incidence')
            "/incidences/count"                     (controller: 'incidence', action: 'count')
            "/incidences/$id/assignee"              (controller: 'incidence', action: [POST: 'assignToMe', DELETE: 'free'])
            "/statuses"                             (resources: 'status', includes: ['index','show'])
            "/models"                               (resources: 'model', includes: ['index','show'])
            "/users"                                (resources: 'user', includes: ['index','show'])
        }

        // Error mapping:
        "401" (controller: 'error', action: 'unauthorized')
        "403" (controller: 'error', action: 'forbidden')
        "404" (controller: 'error', action: 'resourceNotFound')
        "405" (controller: 'error', action: 'methodNotAllowed')
        "500" (controller: 'error', action: 'internalServerError')
        "500" (controller: 'error', action: 'badNumberFormat', exception: NumberFormatException)
        "500" (controller: 'error', action: 'validationFailed', exception: ValidationFailedException)
        "500" (controller: 'error', action: 'statusNotFound', exception: StatusNotFoundException)
        "500" (controller: 'error', action: 'modelNotFound', exception: ModelNotFoundException)
        "500" (controller: 'error', action: 'userNotFound', exception: UserNotFoundException)
        "500" (controller: 'error', action: 'technicianRequired', exception: TechnicianRequiredException)
        "500" (controller: 'error', action: 'incidenceNotFound', exception: IncidenceNotFoundException)
        "500" (controller: 'error', action: 'resolutionRequired', exception: ResolutionRequiredException)
        "500" (controller: 'error', action: 'forbidden', exception: DeniedAccessException)
    }
}
