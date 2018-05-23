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
	private ArrayList<Producto> productos;

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
		
		else if(){
			
		}
		
		

	}

}
