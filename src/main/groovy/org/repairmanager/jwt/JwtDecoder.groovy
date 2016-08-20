package org.repairmanager.jwt

import grails.converters.JSON

class JwtDecoder {
    String header = ""
    String payload = ""

    def JwtDecoder(token) {
        def i = 0;

        token -= "Bearer "
        while (i < token.length() && token[i] != '.')
            header += token[i++]
        i++
        while (i < token.length() && token[i] != '.')
            payload += token[i++]
        header = new String(header.decodeBase64())
        payload = new String(payload.decodeBase64())
    }

    def getHeader() {
        return JSON.parse(header)
    }

    def getPayload() {
        return JSON.parse(payload)
    }
}