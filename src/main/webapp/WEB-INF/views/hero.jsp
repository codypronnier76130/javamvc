<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
"http://www.w3.org/TR/html4/loose.dtd">

<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<title>Liste des Heros</title>
<h1>Liste des Heros</h1>
<table border="2" width="70%" cellpadding="2">

    <tr><th>Id</th><th>Titre</th><th>Type</th><th>Date de debut</th><th>Date de fin</th><th>Niveau</th><th>Itineraire</th><th>Details</th><th>Modifier</th><th>Supprimer</th></tr>
    <c:forEach var="Heros" items="${list}">
        <tr>
            <td>${Heros.}</td>
            <td>${Heros.titre_Mission}</td>
            <td>${Heros.type_Mission}</td>
            <td>${Heros.date_Debut_Mission}</td>
            <td>${Heros.date_Fin_Mission}</td>
            <td>${Heros.niveau_Mission}</td>
            <td>${Heros.itineraire_Mission}</td>
            <td>${Heros.detail_Mission}</td>
            <td><a href="editmission/${Mission.id}">Modifier</a></td>
            <td><a href="deletemission/${Mission.id}">Supprimer</a></td>
        </tr>
    </c:forEach>
</table>
<br/>
<a href="mission">Ajouter une nouvelle mission</a>

</html>