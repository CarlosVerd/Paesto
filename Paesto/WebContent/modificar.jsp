
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<link href="estilos.css" rel="stylesheet" type="text/css" />
<title>Modificar Ronea Working</title>
</head>
<body>
	<div id="contenedor">
		<h2>Modificar Ronea Working</h2>
		<div id="body">
			<h3>MODIFICACIÓN DE LOS DATOS DE RON</h3>
			<form action="ServeltGestion?operacion=actualizar" method="post">
				<table border="1">
					<tr>
						<th>Nombre</th>
						<td><strong>${producto.nombre}</strong></td>
					</tr>
					<tr>
						<th>Descripción</th>
						<td><input type="text" name="descripcion"
							value="${producto.descripcion}" size="30" /></td>
					</tr>
					<tr>
						<th>Imagen</th>
						<td><input type="text" name="rutaImagen"
							value="${producto.rutaImagen}" size="30" /></td>
					</tr>
					<tr>
						<th>Categoría</th>
						<td><input type="text" name="categoria"
							value="${producto.categoria}" size="30" /></td>
					</tr>
					<tr>
						<th>Precio</th>
						<td><input type="text" name="precio"
							value="${producto.precio}" size="30" /></td>
					</tr>
				</table>
 				<br> <input type="hidden" name="nombre" value="${producto.nombre}" /> 
					<input type="submit" value="Actualizar Datos" />
			</form>
			<p>
				<a href="ServeltGestion?operacion=listado"> Volver al listado</a>
			</p>
		</div>
	</div>
</body>
</html>