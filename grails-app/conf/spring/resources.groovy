import grails.rest.render.json.JsonRenderer
import org.repairmanager.filters.CorsFilter
import org.repairmanager.domains.User
import org.repairmanager.domains.Incidence
import org.repairmanager.domains.Status
import org.repairmanager.domains.Model

// Place your Spring DSL code here
beans = {
    incidenceJSONRenderer(JsonRenderer,Incidence) {
        excludes = ['class']
    }

    statusJSONRenderer(JsonRenderer,Status) {
        excludes = ['class','incidences']
    }

    modelJSONRenderer(JsonRenderer,Model) {
        excludes = ['class','incidences']
    }

    userJSONRenderer(JsonRenderer,User) {
        excludes = ['class','incidences']
    }

    corsFilter(CorsFilter)
}
