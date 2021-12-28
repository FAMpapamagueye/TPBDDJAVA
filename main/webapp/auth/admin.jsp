<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="fam"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css"
	integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm"
	crossorigin="anonymous">
	<script src="https://code.jquery.com/jquery-3.2.1.slim.min.js"
		integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN"
		crossorigin="anonymous"></script>
	<script
		src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js"
		integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q"
		crossorigin="anonymous"></script>
	<script
		src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js"
		integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl"
		crossorigin="anonymous"></script>
	<link rel="stylesheet"
		href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css"
		integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm"
		crossorigin="anonymous">
</head>
<body>
<fam:if test="${!empty sessionScope.session  }"></fam:if>
<span>vous etes connecte  au nom de :${sessionScope.session }</span>&nbsp;<a href='<fam:url value="deconnexion"></fam:url>'>Deconnexion</a>


<table class="table table-hover " style="border: 1px solid">

				<thead>
					<th>id</th>
					<th>NOM</th>
					<th>profil</th>
					<th> Login</th>
					<th> email</th>
					<th>Action</th>
				</thead>
				<tbody>
					<fam:forEach items="${util}" var="per" varStatus="tes" >
						<tr>
					
							<td><fam:out value="${per.getId() }" /></td>
							<td><fam:out value="${per.getNom() }" /></td>
							<td><fam:out value="${per.getProfil() }" /></td>
							<td><fam:out value="${per.getLogin() }" /></td>
							<td><fam:out value="${per.getEmail() }" /></td>
							<td><a href="<fam:url value="update">"><fam:param name="id" value="${per.getId()}" /></fam:url>">
							editer</a>
							&nbsp;
							<a href="<fam:url value="delete">"><fam:param name="id" value="${per.getId()}" /></fam:url>">
							Supprimer</a>
							</td>
						</tr>
					</fam:forEach>
				</tbody>
			</table>
</body>
</html>