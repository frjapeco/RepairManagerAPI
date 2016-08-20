import org.repairmanager.domains.Incidence
import org.repairmanager.domains.Status
import org.repairmanager.domains.Model
import org.repairmanager.domains.Role
import org.repairmanager.domains.User
import org.repairmanager.domains.UserRole

class BootStrap {

    def init = { servletContext ->
        /*// Statuses:
        new Status(name: "PENDING").save()
        new Status(name: "IN_PROCESS").save()
        new Status(name: "SOLVED").save()

        // Cellphone models:
        new Model(name: "Apple iPhone").save()
        new Model(name: "Blackberry").save()
        new Model(name: "Samsung Galaxy").save()
        new Model(name: "Nokia Lumia").save()

        // User Roles:
        def guest = new Role(authority: "ROLE_GUEST").save()
        def technician = new Role(authority: "ROLE_TECHNICIAN").save()

        // Users:
        def user = new User(username: "Sansa.Stark", password: "123456", enabled: true).save()
        UserRole.create(user,technician,true)

        user = new User(username: "Jon.Snow", password: "123456", enabled: true).save()
        UserRole.create(user,technician,true)

        user = new User(username: "guest", password: "123456", enabled: true).save()
        UserRole.create(user,guest,true)

        def sn = ['000000000','111111111','222222222','123456789','987654321']
        def clientName = ['Juan López','María Valverde','Arturo Soria','Jacinto Benavente','Inmanol Arias']
        def clientAddress = ['Avda. Libertad','C/Independencia','Carretera San Mauro','Pza. Arroyomolinos','Travesía de Vigo']
        def clientPostcode = ['111111','222222','333333','123456','987654']
        def clientCity = ['Madrid','Barcelona','Valencia','Sevilla','Zaragoza']
        def clientPhone = ['111222333','333222111','111333222','333111222']
        def clientMail = 'noname@mail.net'

        def rnd = new Random()

        for (def i = 1; i <= 1000; i++) {
            new Incidence(
                    sn: sn[rnd.nextInt(sn.size())],
                    model: Model.get(rnd.nextInt(Model.list().size())+1),
                    status: Status.findByName("PENDING"),
                    description: 'Phone does not work!',
                    clientName: clientName[rnd.nextInt(clientName.size())],
                    clientAddress: clientAddress[rnd.nextInt(clientAddress.size())],
                    clientPostcode: clientPostcode[rnd.nextInt(clientPostcode.size())],
                    clientCity: clientCity[rnd.nextInt(clientCity.size())],
                    clientPhone: clientPhone[rnd.nextInt(clientPhone.size())],
                    clientMail: clientMail
            ).save()
            println('Incidence created: ' + i)
        }*/
    }

    def destroy = {
    }
}
