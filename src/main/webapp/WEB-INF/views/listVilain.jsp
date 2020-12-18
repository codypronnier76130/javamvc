<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
"http://www.w3.org/TR/html4/loose.dtd">

<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<title>Liste des Vilains</title>
<h1>Liste des Vilains</h1>
<table border="2" width="70%" cellpadding="2">

    <tr><th>Id</th><th>Nom</th><th>Prenom</th><th>Adresse</th><th>Date de Naissance</th><th>Email</th><th>Telephone</th><th>Actif</th><th>Commentaire</th><th>Super Nom </th><th>Pouvoir</th><th>Point faible</th><th>Commentaire Super</th><th>Modifier</th></tr>
    <c:forEach var="Vilain" items="${list}">
        <tr>
            <td>${Vilain.id}</td>
            <td>${Vilain.nom}</td>
            <td>${Vilain.prenom}</td>
            <td>${Vilain.addresse}</td>
            <td>${Vilain.dateNaiss}</td>
            <td>${Vilain.email}</td>
            <td>${Vilain.telephoneNumber}</td>
            <td>${Vilain.actifs}</td>
            <td>${Vilain.commentaires}</td>
            <td>${Vilain.nom_Super}</td>
            <td>${Vilain.pouvoir_Super}</td>
            <td>${Vilain.point_Faible}</td>
            <td>${Vilain.commentaire}</td>

            <td><a href="updateHeroForm/${Vilain.id_Super}">Modifier</a></td>



        </tr>
    </c:forEach>
</table>
<br/>
    <a href="formVilain">Ajouter un Vilain</a>

</html>