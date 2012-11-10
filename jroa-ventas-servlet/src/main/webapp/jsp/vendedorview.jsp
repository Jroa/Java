<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE HTML>
<html lang="es">
<head>
	<meta charset="utf-8">
	<title>Aplicacion de Ventas</title>
	<link href="bootstrap/css/bootstrap.min.css" rel="stylesheet"/>
	<link href="bootstrap/css/bootstrap-responsive.min.css" rel="stylesheet" />
	
    <link rel="stylesheet" href="js/ui/1.9.1/themes/base/jquery-ui.css" />
    <script src="js/jquery-1.8.2.js"></script>
    <script src="js/ui/1.9.1/jquery-ui.js"></script>
    <script>
    $(function() {
        $( "#txtFecNac" ).datepicker({dateFormat:'dd/mm/yy'});
    });
    </script>    	
</head>
<body>
	<div class="row">
	<div class="span4">&nbsp;</div>
	<div class="span8">
		<form id="f" name="f" method="post" action="${vendedorAction}" class="form-horizontal">
			<fieldset>
				<legend>Vendedor</legend>
				<c:if test="${vendedor.id != null}">
					<div class="control-group">
						<label class="control-label" for="txtId">Id</label>
						<div class="controls">
							<input type="text" name="txtId" id="txtId" class="input-xlarge" value="${vendedor.id}" readonly="readonly"/><br/>
						</div>
					</div>				
				</c:if>
				
				<div class="control-group">
					<label class="control-label" for="txtNombre">Nombre</label>
					<div class="controls">
						<input type="text" name="txtNombre" id="txtNombre" class="input-xlarge" value="${vendedor.nombre}"/><br/>
					</div>
				</div>
				
				<div class="control-group">
					<label class="control-label" for="txtApellido">Apellido</label>
					<div class="controls">
						<input type="text" name="txtApellido" id="txtApellido" class="input-xlarge" value="${vendedor.apellido}"/><br/>
					</div>
				</div>
				
				<div class="control-group">
					<label class="control-label" for="txtTelefono">Telefono</label>
					<div class="controls">
						<input type="text" name="txtTelefono" id="txtTelefono" class="input-xlarge" value="${vendedor.telefono}"/><br/>
					</div>
				</div>
				
				<div class="control-group">
					<label class="control-label" for="txtDireccion">Direccion</label>
					<div class="controls">
						<input type="text" name="txtDireccion" id="txtDireccion" class="input-xlarge" value="${vendedor.direccion}"/><br/>
					</div>
				</div>

				<div class="control-group">
					<label class="control-label" for="txtFecNac">F.Nacimien</label>
					<div class="controls">
						<input type="text" name="txtFecNac" id="txtFecNac" class="input-xlarge" 
						value="<fmt:formatDate pattern="dd/MM/yyyy" value='${vendedor.fecnac}'/>" /><br/>
					</div>
				</div>
				
				<div class="control-group">
					<label class="control-label" for="rbtnSexo">Sexo</label>
					<div class="controls">
						<label class="radio">
							<input type="radio" name="rbtnSexo" value="1" id="rbtnSexo"
								<c:if test="${vendedor.sexo}">
									checked="checked"
								</c:if>							
							>Masculino
						</label>
						<label class="radio">
							<input type="radio" name="rbtnSexo" value="0" id="rbtnSexo"
								<c:if test="${!vendedor.sexo}">
									checked="checked"
								</c:if>
							>Femenino
						</label>
					</div>
				</div>
				
				<div class="control-group">
					<label class="control-label" for="cboLocal">Local</label>
					<div class="controls">
						<select name="cboLocal" id="cboLocal">
						<c:forEach var="local" items="${locales}">
							<option value="${local.id}"
							<c:if test="${local.id == vendedor.local.id}">
								selected="selected"
							</c:if>
							>${local.nombre}</option>
						</c:forEach>
						</select><br/>
					</div>
				</div>
				
				<div class="form-actions">
					<input type="submit" name="btnGuardar" id="btnGuardar" value="Guardar" class="btn btn-primary"/>
					<input type="button" name="btnCancelar" id="btnCancelar" value="Cancelar" class="btn"/>
				</div>
			</fieldset>
		</form>
	</div>		
	</div>
</body>
</html>
