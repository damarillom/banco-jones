<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Nuevo usuario</title>
</head>
<body>
	<form class="formulario" action="newClassServlet" method="POST">
		DNI:<br><input type="text" name="dni"><br>
		NOMBRE:<br><input type="text" name="nombre"><br>
		APELLIDOS:<br><input type="text" name="apellidos"><br>
		FECHA DE NACIMIENTO:<br><input type="text" name="fecha_nacimiento"><br>
		SEXO:<br><input type="text" name="sexo"><br>
		DIRECCION<br><input type="text" name="direccion"><br>
		TELEFONO:<br><input type="text" name="telefono"><br>
		CONTRASEÑA:<br><input type="password" name="pass"><br>
		<input type="submit" value="submit">
	</form>
</body>
</html>