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
 * Servlet implementation class ServletCategoria
 */
@WebServlet("/ServletCategoria")
public class ServletCategoria extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private Iservices ser = new Service();
	
	public ServletCategoria() {
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		continuar(request, response);

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doGet(request, response);

	}

	protected void continuar(HttpServletRequest request, HttpServletResponse response) {
		ArrayList<Producto> categoria = null;
		
		String pasarCategoria=request.getParameter("cat");
		categoria = ser.listaProductos(pasarCategoria);
		System.out.println(categoria);
		request.setAttribute("categoria", categoria);
		RequestDispatcher view = request.getRequestDispatcher("categorias.jsp");
		try {
			view.forward(request, response);
		} catch (ServletException | IOException e) {
			System.out.println(e.getMessage());
			e.printStackTrace();
		}
		
	}

}
