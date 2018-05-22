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
 * Servlet implementation class ServletIincio
 */
@WebServlet("/ServletIincio")
public class ServletInicio extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private Iservices ser = new Service();

	public ServletInicio() {}
	

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		continuar(request, response);

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doGet(request, response);

	}

	protected void continuar(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		ArrayList<Producto> col = null;
		col = ser.mostrarProductos();
		System.out.println(col);
		request.setAttribute("colron", col);
		RequestDispatcher view = request.getRequestDispatcher("productos.jsp");
		view.forward(request, response);
		
		System.out.println(col);

	}

}
