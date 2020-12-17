<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
   "http://www.w3.org/TR/html4/loose.dtd">
   

<h1>Ajouter une nouvelle fiche mission</h1>  
       <form:form method="post" action="save">    
        <table >    
        
         <tr>    
          <td>Titre </td>   
          <td><form:input path="titre_mission"  /></td>  
         </tr>    
         <tr>    
          <td>Type :</td>    
          <td><form:input path="type_mission" /></td>  
         </tr>   
         <tr>    
          <td>Date de début :</td>    
          <td><form:input path="date_debut_mission" /></td>  
         </tr>
         <tr>    
          <td>Date de fin :</td>    
          <td><form:input path="date_fin_mission" /></td>  
         </tr>
         <tr>    
          <td>Niveau :</td>    
          <td><form:input path="niveau_mission" /></td>  
         </tr>
         <tr>    
          <td>Itineraires :</td>    
          <td><form:input path="itineraire_mission" /></td>  
         </tr>
         <tr>    
          <td>Details :</td>    
          <td><form:input path="detail_mission" /></td>  
         </tr>
         <tr>
         <td></td>
         <td><input type="submit" value="Valider" /></td>
         </tr> 
        </table>    
       </form:form>   


<!-- <html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Mission</title>
    </head>
    <body>
    <h1>Hello <c:out value="${mission.titre_Mission}"></c:out></h1>
        <p>This is the homepage!</p>
    </body>
</html>  -->