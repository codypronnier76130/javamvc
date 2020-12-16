<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>    
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>    
  
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
   "http://www.w3.org/TR/html4/loose.dtd">
  
<h1>Liste des missions</h1>  
<table border="2" width="70%" cellpadding="2">  
<tr><th>Id</th><th>Titre</th><th>Type</th><th>Date de début</th><th>Date de fin</th><th>Niveau</th><th>Itineraire</th><th>Details</th><th>Modifier</th><th>Supprimer</th></tr>  
   <c:forEach var="mission" items="${list}">   
   <tr>  
   <td>${mission.id}</td>  
   <td>${mission.titre}</td>  
   <td>${mission.type}</td>  
   <td>${mission.date_debut}</td>  
   <td>${mission.date_fin}</td>
   <td>${mission.niveau}</td>
   <td>${mission.itineraire}</td>
   <td>${mission.detail}</td>        
   <td><a href="editmission/${mission.id}">Modifier</a></td>  
   <td><a href="deletemission/${mission.id}">Supprimer</a></td>  
   </tr>  
   </c:forEach>  
   </table>  
   <br/>  
   <a href="mission">Ajouter une nouvelle mission</a>  
   
 </html>