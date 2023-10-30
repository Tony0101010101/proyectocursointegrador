<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link rel="stylesheet" href="css/style.css">
<title>Iniciar Sesión | Olimpiadas AQP</title>
</head>
<body>
<div class="login_box">
	<h2>Olimpiadas AQP</h2>
	<form action="ServletLogin" method="POST">
		<p>Correo electrónico:</p>
		<input type="email" name="email"> <br>

		<p>Contraseña:</p>
		<input type="password" name="contrasena">
		
		<input type="submit" value="Iniciar Sesión">
	</form>
	<p>¿No tienes una cuenta? <a href="registro.jsp">Regístrate</a></p> <!-- Enlace al formulario de registro -->
</div>
</body>
</html>
