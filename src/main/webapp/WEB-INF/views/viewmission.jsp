<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
   "http://www.w3.org/TR/html4/loose.dtd">

<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<title>Liste des Missions</title>
<h1>Liste des missions</h1>  
<table border="2" width="70%" cellpadding="2">

<tr><th>Id</th><th>Titre</th><th>Type</th><th>Date de debut</th><th>Date de fin</th><th>Niveau</th><th>Itineraire</th><th>Details</th><th>Modifier</th><th>Supprimer</th></tr>
   <c:forEach var="Mission" items="${list}">
   <tr>  
   <td>${Mission.id}</td>  
   <td>${Mission.titre_Mission}</td>  
   <td>${Mission.type_Mission}</td>  
   <td>${Mission.date_Debut_Mission}</td>  
   <td>${Mission.date_Fin_Mission}</td>
   <td>${Mission.niveau_Mission}</td>
   <td>${Mission.itineraire_Mission}</td>
   <td>${Mission.detail_Mission}</td>        
   <td><a href="editmission/${Mission.id}">Modifier</a></td>  
   <td><a href="deletemission/${Mission.id}">Supprimer</a></td>  
   </tr>  
   </c:forEach>
   </table>  
   <br/>  
   <a href="mission">Ajouter une nouvelle mission</a>  
   
 </html>