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
    <th>Username</th><th>Password</th>
  </tr>
  <tr>
    <td>Guest</td><td>123456</td>
  </tr>
  <tr>
    <td>Sansa.Stark</td><td>123456</td>
  </tr>
  <tr>
    <td>Jon.Snow</td><td>123456</td>
  </tr>
</table>
<ul>
  <li>
    Get all statuses existing in database:<br>
    <code>GET http:[URL_SERVER]/api/statuses</code>
  </li>
  <li>
    Get info about certain status:<br>
    <code>GET http:[URL_SERVER]/api/statuses/$id</code>
  </li>
  <li>
    Get all models existing in database:<br>
    <code>GET http:[URL_SERVER]/api/models</code>
  </li>
  <li>
    Get info about certain model:<br>
    <code>GET http:[URL_SERVER]/api/models/$id</code>
  </li> 
  <li>
    Get all incidences existing in database:<br>
    <code>GET http:[URL_SERVER]/api/incidences</code>
  </li>
  <li>
    Get info about certain incidence:<br>
    <code>GET http:[URL_SERVER]/api/incidences/$id</code>
  </li>
  <li>
    Create a new incidence:<br>
    <code>POST http:[URL_SERVER]/api/incidences</code><br>
    JSON Example:<br>
    <pre>

    </pre>
</ul>

