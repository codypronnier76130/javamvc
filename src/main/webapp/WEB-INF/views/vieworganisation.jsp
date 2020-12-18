<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
"http://www.w3.org/TR/html4/loose.dtd">

<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<title>Liste des Organisations</title>
<h1>Liste des organisations</h1>
<table border="2" width="70%" cellpadding="2">

    <tr><th>Id</th><th>Nom</th><th>Adresse</th><th>Commentaires</th><th>Date d'ajout</th><th>Derniere modification</th><th>Modifier</th><th>Supprimer</th></tr>
    <c:forEach var="Organisation" items="${list}">
        <tr>
            <td>${Organisation.id}</td>
            <td>${Organisation.nom_Organisation}</td>
            <td>${Organisation.adresse_Organisation}</td>
            <td>${Organisation.commentaires_Organisation}</td>
            <td>${Organisation.date_Derniere_Modification_Organisation}</td>
            <td>${Organisation.date_Ajout_Organisation}</td>
            <td><a href="editorganisation/${Organisation.id}">Modifier</a></td>
            <td><a href="deleteorganisation/${Organisation.id}">Supprimer</a></td>
        </tr>
    </c:forEach>
</table>
<br/>
<a href="organisation">Ajouter une nouvelle organisation</a>
