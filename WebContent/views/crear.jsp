<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Crear Producto</title>
</head>
<body>
<h1>Crear Producto</h1>
<form action="Usuario"  method="post">
<input type="hidden" name="opcion" value="guardar">

<table border="1">
<tr>
<td>
Nombre:
</td>
<td>
<input type="text" name="nombre" size="50"> 
</td>
</tr>

<td>
Apellido:
</td>

<td>
<input type="text" name="apellido" size="50"> 
</td>
</tr>

<td>
Direccion:
</td>

<td>
<input type="text" name="direccion" size="50"> 
</td>
</tr>



</table>
<input type="submit" value="Guardar"> 
</form>

</body>
</html>