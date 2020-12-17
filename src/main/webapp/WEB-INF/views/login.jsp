<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
   "http://www.w3.org/TR/html4/loose.dtd">
   

<html>
<head>
<meta charset="utf-8">
<title>Page de Connexion</title>
</head>
<body>
    <div style="text-align: center">
        <h1>Se connecter</h1>
        <form action="login" method="post">
            <label for="mail">Email:</label>
            <input name="mail" size="30" />
            
            <label for="mdp">Mot de passe:</label>
            <input type="password" name="mdp" size="30" />
            ${erreurMessage}
                      
            <button type="submit">Se connecter</button>
        </form>
    </div>  

</html>