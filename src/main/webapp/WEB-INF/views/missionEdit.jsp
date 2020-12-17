<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
   "http://www.w3.org/TR/html4/loose.dtd">
   <Title>Modification de la Mission</Title>
   
           <h1>Modifier la fiche de mission</h1>  
       <form:form method="post" action="${pageContext.request.contextPath}/editsave" modelAttribute="mission">
        <form:hidden path="id"  />
        <form:hidden path="id_incident"  />
        <table >
         <tr>    
          <td>Titre :</td>   
          <td><form:input path="titre_Mission"  /></td>  
         </tr>    
         <tr>    
          <td>Type :</td>    
          <td><form:input path="type_Mission" /></td>  
         </tr>   
         <tr>    
          <td>Date de début :</td>    
          <td><form:input path="date_Debut_Mission" /></td>  
         </tr>
         <tr>    
          <td>Date de fin :</td>    
          <td><form:input path="date_Fin_Mission" /></td>  
         </tr>
         <tr>    
          <td>Niveau :</td>    
          <td><form:input path="niveau_Mission" /></td>  
         </tr>
         <tr>    
          <td>Itinéraire :</td>    
          <td><form:input path="itineraire_Mission" /></td>  
         </tr>
         <tr>    
          <td>Details :</td>    
          <td><form:input path="detail_Mission" /></td>  
         </tr>      
           
         <tr>    
          <td><input type="submit" value="Valider les modifications" /></td>    
         </tr>    
        </table>    
       </form:form>
       

</html>