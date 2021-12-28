<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="fam" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>nouveau post</title>
</head>
<body>
 
<fieldset>
<legend>Nouvel Publication</legend>
   <table>
     <thead>
       <fam:if test="${post != null}">
			<form action="updat" method="post">
			</fam:if>
			<fam:if test="${post==null}">
			<form action=new_post method="post">
			</fam:if>
			 <caption><h2>
						<fam:if test="${post!=null}">
            		Edit Publication
            		</fam:if>
				<fam:if test="${post == null}">
            			Nouveau Publication
            		</fam:if>
			</h2>
				</caption>
<table style="text-align: center;">
 		<thead>Vous pouvez vous inscrire sur ce Formulaire</thead>
 		<br>
 		<br>
 		<tbody>
 	
     </thead>
     <tbody>
     	<tr>
 		<fam:if test="${post != null}">
					<input type="hidden" name="id" value="${post.id}" />
				</fam:if>
 		</tr>
       <tr>
         <td>Une date de publication:</td>
         <td><input type="date" name="date" value="<fam:out value="${post.date}"/>"></td>
         <td><span>${form.erreurs['date'] }</span></td>
       </tr>
        <tr>
         <td>Un auteur:</td>
         <td><input type="text" name="auteur" value="<fam:out value="${post.auteur}"/>"></td>
         <td><span>${form.erreurs['auteur'] }</span></td>
       </tr>
        <tr>
         <td>Titre:</td>
         <td><input type="text" name="titre" value="<fam:out value="${post.titre}"/>"></td>
         <td><span>${form.erreurs['titre'] }</span></td>
       </tr>
       
       <tr>
         <td>Un contenu:</td>
         <td>
           <textarea name="contenu" >
             ${post.contenu}
           </textarea>
         </td>
         <td><span>${form.erreurs['contenu'] }</span></td>
       </tr>
       <tr>
         <td><input type="reset" value="Annuler"></td>
         <td><input type="submit" value="bou yess"></td>
         <td><span></span></td>
       </tr>
     </tbody>
   </table>
   </fieldset>
 </form>


</body>
</html>