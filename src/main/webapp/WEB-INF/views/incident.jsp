<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
"http://www.w3.org/TR/html4/loose.dtd">

<title>Incident</title>
<h1>Signalement d'un Incident</h1>
<form:form method="post" action="saveincident" modelAttribute="incident">
    <form:hidden path="id_mission"  />
    <table >

        <tr>
            <td>Declarant : </td>
            <td><form:input path="declarant_Incident"  /></td>
        </tr>
        <tr>
            <td>Lieu :</td>
            <td><form:input path="lieu_Incident" /></td>
        </tr>
        <tr>
            <td>Date :</td>
            <td><form:input path="date_Incident" /></td>
        </tr>
        <tr>
            <td>Description :</td>
            <td><form:input path="description_Incident" /></td>
        </tr>
        <tr>
            <td></td>
            <td><input type="submit" value="Valider" /></td>
        </tr>
    </table>
</form:form>

<a href="viewincident">Voir les incidents</a>
