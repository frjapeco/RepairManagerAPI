package org.repairmanager.domains

class Incidence {
    String sn
    String description
    String resolution
    String clientName
    String clientAddress
    String clientPostcode
    String clientCity
    String clientPhone
    String clientMail

    static hasOne = [
            model: Model,
            technician: User,
            status: Status
    ]

    static constraints = {
        sn size: 9..9
        description blank: false
        resolution nullable: true
        clientName blank: false
        clientAddress blank: false
        clientPostcode size: 1..16
        clientCity blank: false
        clientPhone size: 1..32
        clientMail email: true, blank: false
        technician nullable: true
    }
}