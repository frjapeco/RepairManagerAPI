package org.repairmanager.exceptions

class ErrorResponse {
    int code
    int status
    String message

    ErrorResponse(int code, int status, String message) {
        this.code = code
        this.status = status
        this.message = message
    }
}

