<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
"http://www.w3.org/TR/html4/loose.dtd">

<title>Mission</title>
<h1>Ajouter une nouvelle fiche mission</h1>
<form:form method="post" action="createHero" modelAttribute="hero">
    <form:hidden path="id_Civil"  />
    <table >
        <tr>
            <td>nom_Super : </td>
            <td><form:input path="nom_Super"  /></td>
        </tr>
        <tr>
            <td>pouvoir_Super :</td>
            <td><form:input path="pouvoir_Super" /></td>
        </tr>
        <tr>
            <td>point_Faible :</td>
            <td><form:input path="point_Faible" /></td>
        </tr>
        <tr>
            <td>commentaire_Super :</td>
            <td><form:input path="commentaire_Super" /></td>
        </tr>
        <tr>
            <td></td>
            <td><input type="submit" value="Valider" /></td>
        </tr>
    </table>
</form:form>

<a href="/listHeros">Voir les heros</a>


