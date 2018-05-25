<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page import="java.util.*"%>
<!DOCTYPE html>

<html>
<head>
<meta name="keywords" content="" />
<meta name="description" content="" />
<meta http-equiv="content-type" content="text/html; charset=utf-8" />
<title>Ronea Working</title>
<link href="css/styleindex.css" rel="stylesheet" type="text/css"
	media="screen" />
<link rel="shortcut icon" href="images/favicon.png" type="image/x-icon">

</head>
<body>
	<div id="wrapper">
		<div id="wrapper-bgbtm">
			<div id="header">
				<div id="logo">
					<h1>
						<a href="index.html"> Ronea Working </a>
					</h1>
					<p>Design by LucaTic</p>
				</div>
			</div>
			<!-- end #header -->
			<div id="menu">
				<ul>
					<li><a href="index.html">Inicio</a></li>
					<li class="#"><a href="ServletProductos">Productos</a></li>
					<li class="current_page_item"><a href="#">Categorías</a></li>
					<li><a href="login.html">Login</a></li>
					<li><a href="register.html">Registrarse</a></li>
					<li><a href="#">Carrito</a></li>

				</ul>
			</div>
			<!-- end #menu -->
			<div id="page">
				<div id="page-bgtop">
					<div id="page-bgbtm">
						<div id="content">

							<c:forEach var="producto" items="${categoria}">
								<div class="post">

									<h2 class="title">${producto.nombre}</h2>

									<div class="entry">
										<p>
											<img src="${producto.rutaImagen}" width="143" height="143"
												alt="" class="alignleft border" />
										<p>${producto.descripcion}</p>
										<form method="post" action="ServletBuscador">
											<input type="submit" value='Ficha detallada' /> <input
												type="hidden" name="homeBuscador" id="homeBuscador"
												value="${producto.nombre}" />
										</form>
									</div>
								</div>
							</c:forEach>
						</div>
						<!-- end #content -->
						<div id="sidebar">
							<div id="search">
								<h2>
									<Strong>Buscador</Strong>
								</h2>
								<form method="get" action="ServletBuscador">
									<fieldset>
										<input type="text" name="homeBuscador" id="homeBuscador"
											size="20" placeholder="introduce marca a buscar..." /> <input
											type="submit" id="search-submit" value="GO" />
									</fieldset>
								</form>
							</div>
							<ul>
								<li>
									<h2>
										<Strong>Categorías</Strong>
									</h2>
									<ul>
										<li><a href="ServletCategoria?cat=blanco">Ron Blanco</a></li>
										<li><a href="ServletCategoria?cat=ejo">Ron Añejo</a></li>
									</ul>
								</li>
								<li>
									<h2>
										<Strong>Descripción</Strong>
									</h2>
									<p>El ron es una de las bebidas espirituosas de mayor
										diversidad de estilos en el mundo y en Ronea Working queremos
										ofrecerte la mayor y mejor oferta en rones a los precios más
										competitivos del mercado online. Prueba nuestros exclusivos
										rones, ya sea blanco o añejo y deléitate con su calidad y los
										matices de sus sabores.</p>
								</li>
								<li>
									<h2>
										<Strong>Top ventas</Strong>
									</h2>
									<ul>
										<li><a href="#">Aliquam libero</a></li>
										<li><a href="#">Consectetuer adipiscing elit</a></li>
										<li><a href="#">Metus aliquam pellentesque</a></li>
									</ul>
								</li>
								<li>
									<h2>
										<Strong>Recomendados</Strong>
									</h2>
									<ul>
										<li><a href="#">Aliquam libero</a></li>
										<li><a href="#">Consectetuer adipiscing elit</a></li>
										<li><a href="#">Metus aliquam pellentesque</a></li>
									</ul>
								</li>
							</ul>
						</div>
						<!-- end #sidebar -->
						<div style="clear: both;">&nbsp;</div>
					</div>
				</div>
			</div>
			<!-- end #page -->
			<div id="footer">
				<p>&copy; LucaTic Factory S.A. 2018. Reservados todos los
					derechos</p>
			</div>
			<!-- end #footer -->
		</div>
	</div>
</body>
</html>