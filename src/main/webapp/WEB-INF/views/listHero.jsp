<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
"http://www.w3.org/TR/html4/loose.dtd">

<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<title>Liste des Heros</title>
<h1>Liste des Heros</h1>
<table border="2" width="70%" cellpadding="2">

    <tr><th>Id</th><th>Nom</th><th>Prenom</th><th>Adresse</th><th>Date de Naissance</th><th>Email</th><th>Telephone</th><th>Actif</th><th>Commentaire</th><th>Super Nom </th><th>Pouvoir</th><th>Point faible</th><th>Commentaire Super</th><th>Modifier</th></tr>
    <c:forEach var="Heros" items="${list}">
        <tr>
            <td>${Heros.id}</td>
            <td>${Heros.nom}</td>
            <td>${Heros.prenom}</td>
            <td>${Heros.addresse}</td>
            <td>${Heros.dateNaiss}</td>
            <td>${Heros.email}</td>
            <td>${Heros.telephoneNumber}</td>
            <td>${Heros.actifs}</td>
            <td>${Heros.commentaires}</td>
            <td>${Heros.nom_Super}</td>
            <td>${Heros.pouvoir_Super}</td>
            <td>${Heros.point_Faible}</td>
            <td>${Heros.commentaire_Super}</td>

            <td><a href="updateHeroForm/${Heros.id_Super}">Modifier</a></td>



        </tr>
    </c:forEach>
</table>
<br/>

</html>