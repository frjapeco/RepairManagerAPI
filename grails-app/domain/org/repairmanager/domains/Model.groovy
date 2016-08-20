package org.repairmanager.domains

class Model {
    String name

    static hasMany = [incidences: Incidence]

    static constraints = {
        name size: 1..128, unique: true
    }
}
