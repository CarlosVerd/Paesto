
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
        <link href="css/estilos.css" rel="stylesheet" type="text/css" /> 
        <title>Gestión productos</title>
    </head>
    <body>
        <div id="contenedor">
            <h2>GESTION DE PRODUCTOS</h2>
             <div id="body">        
                <h3>ALTA DE UN RON</h3>
                <form action="ServeltGestion?operacion=alta" method="POST">
                    <table border="1">
                        <thead>
                            <tr>
                                <td>Nombre</td>
                                <td><input type="text" name="nombre" value="" size="30" /></td>
                            </tr>
                        </thead>
                        <tbody>
                            <tr>
                                <td>Descripción</td>
                                <td><input type="text" name="descripcion" value="" size="30" /></td>
                            </tr>
                            <tr>
                                <td>Ruta imagen</td>
                                <td><input type="text" name="rutaImagen" value="" size="30" /></td>
                            </tr>
                            <tr>
                                <td>Categoría</td>
                                <td><input type="text" name="categoria" value="" size="30" /></td>
                            </tr>
                            <tr>
                                <td>Precio</td>
                                <td><input type="text" name="precio" value="" size="30" /></td>
                            </tr>
                        </tbody>
                    </table>
                    <br>
                    <input type="submit" value="Enviar" />
                </form>
            </div>
        </div>
    </body>
</html>
            