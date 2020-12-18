<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
"http://www.w3.org/TR/html4/loose.dtd">
<Title>Modification de l'organisation</Title>

<h1>Modifier la fiche de l'organisation</h1>
<form:form method="post" action="${pageContext.request.contextPath}/editsaveorganisation" modelAttribute="organisation">
    <form:hidden path="id"  />
    <form:hidden path="id_civil"  />
    <table >
        <tr>
            <td>Nom :</td>
            <td><form:input path="nom_Organisation"  /></td>
        </tr>
        <tr>
            <td>Adresse :</td>
            <td><form:input path="adresse_Organisation" /></td>
        </tr>
        <tr>
            <td>Commentaires :</td>
            <td><form:input path="commentaires_Organisation" /></td>
        </tr>
        <tr>
            <td>Date d'ajout :</td>
            <td><form:input path="date_Ajout_Organisation" /></td>
        </tr>
        <tr>
            <td>Derniere modification :</td>
            <td><form:input path="date_Derniere_Modification_Organisation" /></td>
        </tr>

        <tr>
            <td><input type="submit" value="Valider les modifications" /></td>
        </tr>
    </table>
</form:form>

