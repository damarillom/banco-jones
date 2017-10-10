<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<style>
	.formulario {
		position:absolute;
		left:100px;
		top:30px;
	}
</style>
<body>
	<form class="formulario" action="Checker">
		Nombre:<br><input type="text" name="nombre"><br>
		Apellidos:<br><input type="text" name="apellido"><br>
		Fecha:<br><input type="text" name="fecha"><br>
		Nif:<br><input type="text" name="nif"><br>
		<input type="text" name="letra"><br>
		DNI:<br><input type="text" name="dni"><br>
		<input type="submit">
	</form>
	Your name is ${ name } ${ surname }, you was born in ${ date },  with the nif ${ nif } and dni ${ dni }
</body>
</html>