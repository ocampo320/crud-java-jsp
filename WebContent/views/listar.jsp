<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
    
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
    
    
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Listar Producto</title>
</head>
<body>
<h1>Listar Producto</h1>

<table border="1">
<tr>
<td>
id
</td>
<td>
Nombre
</td>
<td>
Apellido
</td>

<td>
Direccion
</td>

<td>
Accion
</td>
</tr>




<c:forEach var="usuario" items="${lista}">
<tr>
<td><a href="Usuario?opcion=consula&id=<c:out value="${usuario.id}"> </c:out>"><c:out value="${usuario.id}"> </c:out></a>

</td>
<td>
<c:out value="${usuario.nombre}"></c:out>
</td>
<td>
<c:out value="${usuario.apellido}"></c:out>
</td>
<td>
<c:out value="${usuario.direccion}"></c:out>
</td>

<td><a href="Usuario?opcion=eliminar&id=<c:out value="${usuario.id}"> </c:out>">Eliminar </a>
</td>

</c:forEach>
</table>

</body>
</html>