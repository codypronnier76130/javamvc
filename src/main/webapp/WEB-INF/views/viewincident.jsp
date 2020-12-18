<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
"http://www.w3.org/TR/html4/loose.dtd">

<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<title>Liste des Incidents</title>
<h1>Liste des incidents</h1>
<table border="2" width="70%" cellpadding="2">

    <tr>
        <th>Id</th>
        <th>Declarant</th>
        <th>Lieu</th>
        <th>Date</th>
        <th>Description</th>
        <th>Modifier</th>
        <th>Supprimer</th>
    </tr>
    <c:forEach var="Incident" items="${list}">
        <tr>
            <td>${Incident.id}</td>
            <td>${Incident.declarant_Incident}</td>
            <td>${Incident.lieu_Incident}</td>
            <td>${Incident.date_Incident}</td>
            <td>${Incident.description_Incident}</td>
            <td><a href="editincident/${Incident.id}">Modifier</a></td>
            <td><a href="deleteincident/${Incident.id}">Supprimer</a></td>
        </tr>
    </c:forEach>
</table>
<br/>
<a href="incident">Ajouter un nouvel incident</a>

</html>