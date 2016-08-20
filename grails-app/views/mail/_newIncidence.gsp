<h1><g:message code="incidence"/> ${incidence.id}</h1>
<table>
    <tr>
        <td><g:message code="sn"/></td>
        <td>${incidence.sn}</td>
    </tr>
    <tr>
        <td><g:message code="model"/></td>
        <td>${incidence.model.name}</td>
    </tr>
    <tr>
        <td><g:message code="client.name"/></td>
        <td>${incidence.clientName}</td>
    </tr>
    <tr>
        <td><g:message code="client.address"/></td>
        <td>${incidence.clientAddress}</td>
    </tr>
    <tr>
        <td><g:message code="client.postcode"/></td>
        <td>${incidence.clientPostcode}</td>
    </tr>
    <tr>
        <td><g:message code="client.city"/></td>
        <td>${incidence.clientCity}</td>
    </tr>
    <tr>
        <td><g:message code="client.phone"/></td>
        <td>${incidence.clientPhone}</td>
    </tr>
    <tr>
        <td><g:message code="client.mail"/></td>
        <td>${incidence.clientMail}</td>
    </tr>
    <tr>
        <td><g:message code="status"/></td>
        <td><g:message code="${incidence.status.name}"/></td>
    </tr>
    <tr>
        <td><g:message code="description"/></td>
        <td>${incidence.description}</td>
    </tr>
</table>