
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
        <link href="estilos.css" rel="stylesheet" type="text/css" /> 
        <title>Gestión productos</title>
    </head>
    <body>
        <div id="contenedor">
            <h2>GESTION DE PRODUCTOS</h2>
            <div id="body">        
                <h3>LISTADO DE PRODUCTOS</h3>
                <table border="1">
                    <thead>
                        <tr>
                            <th>Nombre</th>
                            <th>Descripción</th>
                            <th>Ruta Imagen</th>
                            <th>Categoría</th>
                            <th>Precio</th>
                        </tr>
                    </thead>
                    <tbody>
                        <c:forEach var="producto" items="${colron}">
                            <tr>
                                <td>${producto.nombre}</td>
                                <td>Prueba<!--  ${producto.descripcion}--></td>
                                <td>${producto.rutaImagen}</td>
                                <td>${producto.categoria}</td>
                                <td>${producto.precio}</td>
                                <td><a href="ServeltGestion?operacion=detalle&nombre=${producto.nombre}">Detalles</a></td>
                                <td><a href="ServeltGestion?operacion=modificacion&nombre=${producto.nombre}">Modificar</a></td>
                                <td><a href="ServeltGestion?operacion=eliminar&nombre=${producto.nombre}">Eliminar</a></td>
                            </tr>
                        </c:forEach>
                    </tbody>
                </table>
                <p><a href="altagestion.jsp">Crear nuevo producto</a></p>

                <br/>
                <br/>
                <div id="listado"></div>
            </div>
        </div>
    </body>
</html>