# RepairManagerAPI
<h2>Overview</h2>
<p>
  <strong>RepairManagerAPI</strong> is a RESTful API which provides a set of endpoints for create, update and manage
  cellphone repairs. It works together with <strong>RepairManagerClient</strong> app.
</p>
<h2>Interface</h2>
<p>First of all you need to get an apropiate token before to make any request.<p>
<p>Next are avalibable users:</p>
<table>
  <tr>
    <th>Username</th><th>Password</th><th>Role</th>
  </tr>
  <tr>
    <td>Guest</td><td>123456</td><td>Guest</td>
  </tr>
  <tr>
    <td>Sansa.Stark</td><td>123456</td><td>Technician</td>
  </tr>
  <tr>
    <td>Jon.Snow</td><td>123456</td><td>Technician</td>
  </tr>
</table>
<ul>
  <li>
    Login and get token:<br>
    <code>GET http:[URL_SERVER]/api/login</code>
    <pre>
{
  "username" : "Jon.Snow",
  "password" : "123456"
}
    </pre>
  </li>
  <li>
    Get all statuses existing in database (all users)<br>
    <code>GET http:[URL_SERVER]/api/statuses</code>
  </li>
  <li>
    Get info about certain status (all users)<br>
    <code>GET http:[URL_SERVER]/api/statuses/$id</code>
  </li>
  <li>
    Get all models existing in database (all users)<br>
    <code>GET http:[URL_SERVER]/api/models</code>
  </li>
  <li>
    Get info about certain model (all users)<br>
    <code>GET http:[URL_SERVER]/api/models/$id</code>
  </li> 
  <li>
    List all incidences existing in database (technician)<br>
    <code>GET http:[URL_SERVER]/api/incidences</code>
  </li>
  <li>
    List all incidences existing in database (technician)<br>
    <code>GET http:[URL_SERVER]/api/incidences?status=PENDING&technician=Jon.Snow&searchPattern=iphone</code>
  </li>
  <li>
    Get info about certain incidence (all users)<br>
    <code>GET http:[URL_SERVER]/api/incidences/$id</code>
  </li>
  <li>
    Create a new incidence:<br>
    <code>POST http:[URL_SERVER]/api/incidences</code><br>
    JSON Example:<br>
    <pre>
{
    "sn" : "123456789",
    "model" : { "id" : 1 },
    "status" : { "id" : 1 },
    "description" : "The cellphone is broken",
    "clientName" : "Mr. Noname",
    "clientMail" : "mrnoname@mail.net",
    "clientAddress" : "1th Ave.",
    "clientPostcode" : "123abc",
    "clientPhone" : "+1 555 123 456",
    "clientCity" : "Albuquerque"
}
    </pre>
  </li>
</ul>

