<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="fam" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>INSCRIPTION</title>
<link rel="stylesheet" type="text/css" href="css/style.css">
</head>
<body >
 <fieldset style="color: infos;">
 	<legend>Inscription</legend>
 		<fam:if test="${utilisateur != null}">
			<form action="update" method="post">
			</fam:if>
			<fam:if test="${utilisateur==null}">
			<form action="register" method="post">
			</fam:if>
			 <caption><h2>
						<fam:if test="${utilisateur!=null}">
            		Edit User
            		</fam:if>
				<fam:if test="${utilisateur == null}">
            			Add New User
            		</fam:if>
			</h2>
				</caption>
<table style="text-align: center;">
 		<thead>Vous pouvez vous inscrire sur ce Formulaire</thead>
 		<br>
 		<br>
 		<tbody>
 		<tr>
 		<fam:if test="${utilisateur != null}">
					<input type="hidden" name="id" value="${utilisateur.id}" />
				</fam:if>
 		</tr>
 			<tr>
 				<td>NOM COMPLET</td>
 				<td><input type="text" name="nom" value="${utilisateur.nom }"></td>
 				<td><span class="obligatoire">${inscription.erreurs['nom']}</span></td>
 				
 			</tr>
 			<tr>
 				<td>Email</td>
 				<td><input type="email" name="email" value="${utilisateur.email }"></td>
				<td><span class="obligatoire">${inscription.erreurs['email']}</span></td> 				
 			</tr>
 			<tr>
 				<td>Login ou Nom d'utilisateur</td>
 				<td><input type="text" name="login" value="${utilisateur.login }"></td>
 				<td><span class="obligatoire">${inscription.erreurs['login']}</span></td>
 				
 			</tr>
 			<tr>
 				<td>Profil</td>
 				<td>
 					<select name="profil"  value="value="${utilisateur.profil }">
 						<option>Selectionnez votre Profil</option>
 						<option value="admin">ADMIN</option>
 						<option value="client">CLIENTS</option>
 						
 					</select>
              
 				</td>
 				<td> <span class="obligatoire">${inscription.erreurs['profil']}</span></td>
 			</tr>
 			<tr>
 				<td>Mot de Passe</td>
 				<td><input type="password" name="password" ></td>
 				<td><span class="obligatoire">${inscription.erreurs['password']}</span></td>
 				
 			</tr>
 			<tr>
 				<td>Confirmation  Mot de Passe</td>
 				<td><input type="password" name="Cpassword"></td>
 				<td><span class="obligatoire">${inscription.erreurs['password']}</span></td>
 				
 			</tr>
 			<tr>
 				<td><input type="reset" value="Annuler" ></td>
 				<td><input type="submit"value="S'inscrire" ></td>
 				
 			</tr>

 		</tbody>
 	</table>
 </fieldset>
 </form>
</body>

</html>