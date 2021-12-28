<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="fam" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>INDEX</title>
</head>
<body>
<fam:choose>
<fam:when test="${log.getProfil() ==\"admin\" }">
<fam:redirect url="admin"></fam:redirect>
</fam:when>
<fam:otherwise>
<fam:redirect url="accueil"></fam:redirect>
</fam:otherwise>
</fam:choose>

</body>
</html>