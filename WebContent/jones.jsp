<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Banco Jones</title>
</head>
<body>
	<form class="formulario" action="loginServlet" method="POST">
		Usuario:<br><input type="text" name="dni"><br>
		Contraseña:<br><input type="password" name="pass"><br>
		<input type="submit" value="submit">
	</form>
</body>
</html>