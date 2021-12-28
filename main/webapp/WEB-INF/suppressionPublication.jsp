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
<span>Id:${post.id }</span><br>
<span>Contenu:${post.contenu }</span><br>
<span>Auteur:${post.auteur }</span><br>
<span>Titre:${post.titre }</span><br>

<a href="<fam:url value="confirmersupp">"><fam:param name="id" value="${post.id}" /></fam:url>">
							Confirmer</a>

</body>
</html>