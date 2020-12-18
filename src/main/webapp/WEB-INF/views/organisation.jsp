<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
"http://www.w3.org/TR/html4/loose.dtd">

<title>Modification de l'Organisation</title>
<h1>Ajouter une nouvelle organisation</h1>
<form:form method="post" action="saveorganisation" modelAttribute="organisation">
    <form:hidden path="id_civil"  />
    <table >

        <tr>
            <td>Nom </td>
            <td><form:input path="nom_Organisation"  /></td>
        </tr>
        <tr>
            <td>Adresse :</td>
            <td><form:input path="adresse_Organisation" /></td>
        </tr>
        <tr>
            <td>Commentaire :</td>
            <td><form:input path="commentaires_Organisation" /></td>
        </tr>
        <tr>
            <td>Date d'ajout:</td>
            <td><form:input path="date_Ajout_Organisation" /></td>
        </tr>
        <tr>
            <td>Derniere modification :</td>
            <td><form:input path="date_Derniere_Modification_Organisation" /></td>
        </tr>
        <tr>
            <td></td>
            <td><input type="submit" value="Valider" /></td>
        </tr>
    </table>
</form:form>

<a href="vieworganisation">Voir les organisations</a>

