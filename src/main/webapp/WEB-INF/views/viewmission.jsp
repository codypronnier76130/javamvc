<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>    
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>    
  
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
   "http://www.w3.org/TR/html4/loose.dtd">
  
<h1>Liste des missions</h1>  
<table border="2" width="70%" cellpadding="2">  
<tr><th>Id</th><th>Titre</th><th>Type</th><th>Date de début</th><th>Date de fin</th><th>Niveau</th><th>Itineraire</th><th>Details</th><th>Edit</th><th>Delete</th></tr>  
   <c:forEach var="mission" items="${list}">   
   <tr>  
   <td>${mission.id_mission}</td>  
   <td>${mission.titre_mission}</td>  
   <td>${mission.type_mission}</td>  
   <td>${mission.date_debut_mission}</td>  
   <td>${mission.date_fin_mission}</td>
   <td>${mission.niveau_mission}</td>
   <td>${mission.itineraire_mission}</td>
   <td>${mission.detail_mission}</td>        
   <td><a href="editmission/${mission.id_mission}">Modifier</a></td>  
   <td><a href="deletemission/${mission.id_mission}">Supprimer</a></td>  
   </tr>  
   </c:forEach>  
   </table>  
   <br/>  
   <a href="mission">Ajouter une nouvelle mission</a>  
   
 </html>