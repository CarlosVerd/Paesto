package control;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Producto;
import services.Iservices;
import services.Service;

/**
 * Servlet implementation class ServeltGestion
 */
@WebServlet("/ServeltGestion")
public class ServeltGestion extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private Iservices ser = new Service();

	public ServeltGestion() {
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		continuar(request, response);

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doGet(request, response);

	}
	
	/**
	 * Este método maneja toda la gestión de los productos, depediendo de que página lo llame realizará unas funciones u otras controladas por sentencias if 
	 * @param request 
	 * @param response
	 */

	protected void continuar(HttpServletRequest request, HttpServletResponse response) {

		String operacion = request.getParameter("operacion");

		ArrayList<Producto> col = null;
		col = ser.mostrarProductos();

		if (operacion.equals("listado")) {

			request.setAttribute("colron", col);
			RequestDispatcher view = request.getRequestDispatcher("listadogestion.jsp");
			try {
				view.forward(request, response);
			} catch (ServletException | IOException e) {
				System.out.println(e.getMessage());
				e.printStackTrace();
			}
		}

		else if (operacion.equals("alta")) {
			try {
			Producto p = new Producto();
			p.setNombre(request.getParameter("nombre"));
			p.setDescripcion(request.getParameter("descripcion"));
			p.setRutaImagen(request.getParameter("rutaImagen"));
			p.setCategoria(request.getParameter("categoria"));
			p.setPrecio(Float.parseFloat(request.getParameter("precio")));
			
			ser.altaProducto(p);

			
				response.sendRedirect("ServeltGestion?operacion=listado");
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			catch (NumberFormatException e) {
				
				System.out.println("Has metido "+e.getMessage()+", mete un número real,al dar de alta un producto");
				try {
					response.sendRedirect("ServeltGestion?operacion=listado");
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
			}

		}

		else if (operacion.equals("detalle")) {
			try {
				Producto producto;
				String nombre = request.getParameter("nombre");
				producto = ser.buscarNombre(nombre);

				request.setAttribute("producto", producto);
				RequestDispatcher view = request.getRequestDispatcher("fichaprod.jsp");
				view.forward(request, response);

			} catch (ServletException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}

		else if (operacion.equals("eliminar")) {

			String nombre = request.getParameter("nombre");
			ser.bajaProducto(nombre);

			try {
				response.sendRedirect("ServeltGestion?operacion=listado");
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

		else if (operacion.equals("modificar")) {
			try {
				Producto producto;
				String nombre = request.getParameter("nombre");
				producto = ser.buscarNombre(nombre);

				request.setAttribute("producto", producto);
				

				RequestDispatcher view = request.getRequestDispatcher("modificar.jsp");
				view.forward(request, response);
			

			} catch (ServletException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

		else if (operacion.equals("actualizar")) {
			try {
			Producto p = new Producto();

			p.setNombre(request.getParameter("nombre"));
			p.setDescripcion(request.getParameter("descripcion"));
			p.setRutaImagen(request.getParameter("rutaImagen"));
			p.setCategoria(request.getParameter("categoria"));
			p.setPrecio(Float.parseFloat(request.getParameter("precio")));

			
			ser.modificarProducto(p);
			
				response.sendRedirect("ServeltGestion?operacion=listado");
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			catch (NumberFormatException e) {
				//e.printStackTrace();
				System.out.println("Has metido "+e.getMessage()+", mete un número real, al modificar un producto");
				try {
					response.sendRedirect("ServeltGestion?operacion=listado");
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		}
	}
}
