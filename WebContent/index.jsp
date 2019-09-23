<%@ page language="java" import="tew.beans.Counter"%> 

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; utf-8">
<title>Hola Mundo!!</title>
</head>
<body>
	<%
		if (request.getParameter("NombreUsuario") != null) {
	%>
	<h1>
		Hola
		<%=request.getParameter("NombreUsuario")%>!
	</h1>
	<br>
	<%
		}
	%>
	<h1>Bienvenido a mi primera página web!</h1>

	<br>

	<jsp:useBean id="contador" class="tew.beans.Counter"
		scope="application" />
	<center>
		<jsp:getProperty property="incrementedValue" name="contador" />
		visitas
	</center>
</body>
</html>
>
