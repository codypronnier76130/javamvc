<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
"http://www.w3.org/TR/html4/loose.dtd">


<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Civils</title>
</head>
<body>
<title>Profil du compte</title>
<h1>Formulaire de modification de compte</h1>
<form:form method="post" action="validmodif" modelAttribute="civil">

    <table >

        <tr>
            <td>Nom </td>
            <td><form:input path="Nom"  /></td>
        </tr>
        <tr>
            <td>Prenom :</td>
            <td><form:input path="Prenom" /></td>
        </tr>
        <tr>
            <td>Date de naissance :</td>
            <td><form:input path="DateNaiss" /></td>
        </tr>
        <tr>
            <td>Adresse :</td>
            <td><form:input path="Adresse" /></td>
        </tr>
        <tr>
            <td>Email :</td>
            <td><form:input  path="Email" /></td>
        </tr>
        <tr>
            <td>Telephone :</td>
            <td><form:input path="TelephoneNumber" /></td>
        </tr>
        <tr>
            <td>Mot de passe:</td>
            <td><form:password  path="Mdp" /></td>
        </tr>
        <tr>
            <td>Commentaires:</td>
            <td><form:input path="Commentaires" /></td>
        </tr>
        <tr>
            <td></td>
            <td><input type="submit" value="Valider" /></td>
        </tr>

    </table>
</form:form>

</body>
</html>
