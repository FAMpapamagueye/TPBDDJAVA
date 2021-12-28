<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="fam"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<span>Id:${utilisateur.id }</span><br>
<span>Nom:${utilisateur.nom }</span><br>
<span>Login:${utilisateur.login }</span><br>
<span>Profil:${utilisateur.profil }</span><br>
<span>Email:${utilisateur.email }</span><br>
<a href="<fam:url value="confirmer">"><fam:param name="id" value="${utilisateur.id}" /></fam:url>">
							Confirmer</a>
</body>
</html>