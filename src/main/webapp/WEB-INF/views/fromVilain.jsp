<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
"http://www.w3.org/TR/html4/loose.dtd">

<title>Formulaire Vilain</title>
<h1>Ajouter un Vilain</h1>
<form:form method="post" action="createVilain" modelAttribute="vilain">
    <form:hidden path="id_Civil"  />
    <table >

        <tr>
            <td>nom Super : </td>
            <td><form:input path="nom_Super"  /></td>
        </tr>
        <tr>
            <td>pouvoir Super :</td>
            <td><form:input path="pouvoir_Super" /></td>
        </tr>
        <tr>
            <td>point Faible :</td>
            <td><form:input path="point_Faible" /></td>
        </tr>
        <tr>
            <td>commentaire Super :</td>
            <td><form:input path="commentaire" /></td>
        </tr>
        <tr>
            <td>malveillance :</td>
            <td><form:input path="malveillance" /></td>
        </tr>
        <tr>
            <td></td>
            <td><input type="submit" value="Valider" /></td>
        </tr>
    </table>
</form:form>

<a href="/listVilains">Voir les vilains</a>


