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
<link href="styleindex.css" rel="stylesheet" type="text/css"
	media="screen" />
</head>
<body>
	<div id="wrapper">
		<div id="wrapper-bgbtm">
			<div id="header">
				<div id="logo">
					<h1>
						<a href="#"> Ronea Working </a>
					</h1>
					<p>Design by LucaTic</p>
				</div>
			</div>
			<!-- end #header -->
			<div id="menu">
				<ul>
					<li><a href="index.html">Inicio</a></li>
					<li class="current_page_item"><a href="#">Productos</a></li>
					<li><a href="#">Contacto</a></li>
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
										<Strong>Descripcion</Strong>
									</h2>
									<p>Mauris vitae nisl nec metus placerat perdiet est.
										Phasellus dapibus semper consectetuer hendrerit.</p>
								</li>
								<li>
									<h2>
										<Strong>Categorias</Strong>
									</h2>
									<ul>
										<li><a href="#">Ron Blanco</a></li>
										<li><a href="#">Ron Añejo</a></li>
									</ul>
								</li>
								<li>
									<h2>
										<Strong>Top ventas</Strong>
									</h2>
									<ul>
										<li><a href="#">Aliquam libero</a></li>
										<li><a href="#">Consectetuer adipiscing elit</a></li>
										<li><a href="#">Metus aliquam pellentesque</a></li>
										<li><a href="#">Suspendisse iaculis mauris</a></li>
										<li><a href="#">Urnanet non molestie semper</a></li>
										<li><a href="#">Proin gravida orci porttitor</a></li>
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
										<li><a href="#">Suspendisse iaculis mauris</a></li>
										<li><a href="#">Urnanet non molestie semper</a></li>
										<li><a href="#">Proin gravida orci porttitor</a></li>
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