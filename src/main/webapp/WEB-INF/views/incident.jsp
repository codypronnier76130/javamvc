<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
   "http://www.w3.org/TR/html4/loose.dtd">
   

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Incident</title>
    </head>
    <body>
        <!-- <h1>Hello <c:out value="${incident.declarantIncident} ${incident.lieuIncident} "></c:out></h1> -->
        <h1>Signalement d'un incident :</h1>
        <form:form method="post" action="save">    
        <table >    
        <tr>  
         <td><form:hidden  path="id" /></td>  
         </tr>   
         <tr>    
          <td>Déclarant :</td>   
          <td><form:input path="declarant_incident"  /></td>  
         </tr>    
         <tr>    
          <td>Lieu :</td>    
          <td><form:input path="lieu_incident" /></td>  
         </tr>   
         <tr>    
          <td>Date :</td>    
          <td><form:input path="date_incident" /></td>  
         </tr>
         <tr>    
          <td>Description :</td>    
          <td><form:input path="description_incident" /></td>  
         </tr>
        </table>    
       </form:form>
    </body>
</html>
