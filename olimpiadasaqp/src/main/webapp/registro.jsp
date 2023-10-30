<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="ISO-8859-1">
    <link rel="stylesheet" href="css/style.css">
    <title>Registro | Olimpiadas AQP</title>
</head>
<body>
    <div class="login_box">
        <h2>Registro</h2>
        <form action="ServletSignup" method="POST">
            <p>Nombre:</p>
            <input type="text" name="nombre"> <br>

            <p>Correo electrónico:</p>
            <input type="email" name="email"> <br>

            <p>Contraseña:</p>
            <input type="password" name="contrasena">

            <input type="submit" value="Registrarse">
        </form>
        <p>¿Ya tienes una cuenta? <a href="index.jsp">Iniciar Sesión</a></p> 
    </div>
</body>
</html>

