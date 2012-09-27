<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<html>
<head></head>
<body>
	<h1>Struts2 Hola Mundo</h1>
	<s:form action="Welcome">
		<s:textfield name="username" label="Nombre" />
		<s:submit name="enviar" label="Enviar" />
	</s:form>
</body>
</html>