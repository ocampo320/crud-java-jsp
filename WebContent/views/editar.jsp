<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
     
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
    
    
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Editar Producto</title>
</head>
<body>
<h1>Editar Producto</h1>

<c:set var="usuario" value="${usuario}"></c:set>
<form action="Usuario"  method="post">
<input type="hidden" name="opcion" value="actualizar">
<input type="hidden" name="id" value="${usuario.id}">


<table border="1">


<td>
Nombre:
</td>
<td>
<input type="text" name="nombre" size="50" value="${usuario.nombre}"> 
</td>
</tr>

<td>
Apellido:
</td>

<td>
<input type="text" name="apellido" size="50" value="${usuario.apellido}"> 
</td>
</tr>

<td>
Direccion:
</td>

<td>
<input type="text" name="direccion" size="50" value="${usuario.direccion}"> 
</td>
</tr>

</table>
<input type="submit" value="Guardar"> 
</form>
</body>
</html>