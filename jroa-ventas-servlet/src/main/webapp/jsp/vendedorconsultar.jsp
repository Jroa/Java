<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html lang="es">
<head>
	<meta charset="UTF-8">
	<title>Consulta de Vendedores</title>
	<link href="bootstrap/css/bootstrap.min.css" rel="stylesheet">
	<link href="bootstrap/css/bootstrap-responsive.min.css" rel="stylesheet">	
</head>
<body>
	<div class="row">
		<div class="span1">&nbsp; </div>
		<div class="span7">
			<h3>Consulta de Vendedores</h3>
			<form id = "f" name="form" method="post" action="vendedorconsultarpornombre.htm" class="well form-search">
				<label>Nombre: </label> 
				<input type="text" name="txtNombre" id="txtNombre" size="50" class="input-medium search-query" value="${nombre}"/>
				<input type="submit" name="btnConsultar" id="btnConsultar" value="Consultar" class="btn"/>
				<input type="button" onclick="" name="btnNuevo" id="btnNuevo" value="Nuevo" class="btn btn-primary">
			</form>
			
			
			<table class="table table-hover">
				<thead>
					<tr>
						<th>Id</th>
						<th>Nombre</th>													
						<th>Telefono</th>
						<th>Local</th>
						<th>Accion</th>
					</tr>								
				</thead>
				<tbody>
					<c:forEach var="vendedor" items="${vendedores}">
						<tr>
							<td>${vendedor.id}</td>
							<td>${vendedor.nombre}, ${vendedor.apellido}</td>
							<td>${vendedor.telefono}</td>
							<td>${vendedor.local.nombre}</td>
							<td>
							<a class="btn btn-small" href="#"><i class="icon-pencil"></i></a>
							<a class="btn btn-small" href="#"><i class="icon-trash"></i></a>
							</td>
						</tr>								
					</c:forEach>
				</tbody>
			</table>
		</div>
		<div class="span4">&nbsp; </div>		
	</div>		
</body>
</html>