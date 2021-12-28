<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Connexion</title>
<link rel="stylesheet" type="text/css" href="css/style.css">
</head>
<body>
<fieldset>
  <legend>Connexion</legend>
    <form method="post" action="login">
  <table>
  
    <tbody>
      <tr>
        <td>email ou Nom d'utilisateur </td>
        <td><input type="text" name="login" value="${log.login}"></td>
        <td><span>${form.erreurs['login'] }</span></td>
      </tr>
      <tr>
        <td>mot de passe</td>
        <td><input type="password" name="password"></td>
        <td><span>${form.erreurs['password'] }</span></td>

      </tr>
       <tr>
        <td><input type="reset" value="RESET"></td>
        <td><input type="submit" value="Submit"></td>
        <td><span></span></td>

      </tr>
      <tr>
        <td>remember me<input type="checkbox" name="memoire"></td>
        <td><a href="register">Inscrire?  </a></td>
        <td><span></span></td>

      </tr>
    </tbody>
  </table>
  </form>
  </fieldset>


</body>
</html>