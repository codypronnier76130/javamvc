<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
"http://www.w3.org/TR/html4/loose.dtd">
<Title>Modification de l'incident</Title>

<h1>Modifier la fiche de l'incident</h1>
<form:form method="post" action="${pageContext.request.contextPath}/editsaveincident" modelAttribute="incident">
    <form:hidden path="id"  />
    <form:hidden path="id_mission"  />
    <table >
        <tr>
            <td>Declarant :</td>
            <td><form:input path="declarant_Incident"  /></td>
        </tr>
        <tr>
            <td>Lieu :</td>
            <td><form:input path="lieu_Incident" /></td>
        </tr>
        <tr>
            <td>Date :</td>
    <fmt:formatDate value="${incident.date_Incident}" pattern="yyyy/MM/dd" var="myDate" />
    <td> <form:input path="date_Incident" value="${myDate}" /></td>
        </tr>
        <tr>
            <td>Description :</td>
            <td><form:input path="description_Incident" /></td>
        </tr>
        <tr>
            <td><input type="submit" value="Valider les modifications" /></td>
        </tr>
    </table>
</form:form>
