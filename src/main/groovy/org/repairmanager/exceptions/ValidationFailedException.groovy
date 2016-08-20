package org.repairmanager.exceptions

import org.springframework.validation.Errors

class ValidationFailedException extends Exception {
    def errors = new ArrayList<String>()

    ValidationFailedException(Errors errors) {
        def msg = new String()

        // Building error messages and adding to 'errors' property.
        errors.allErrors.each { error->
            msg = error.defaultMessage
            error.arguments.eachWithIndex { arg, i ->
                msg = msg.replace("{${i.toString()}}",arg.toString())
            }
            this.errors.push(msg)
        }
    }
}
