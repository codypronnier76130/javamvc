<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
   "http://www.w3.org/TR/html4/loose.dtd">
   

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Organisations</title>
    </head>
    <body>
        <h1>Hello <c:out value="${organisation.nom} ${organisation.commentaires} "></c:out></h1>
        <p>Page des organisations</p>
    </body>
</html>