package control;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Producto;
import services.Iservices;
import services.Service;


@WebServlet("/ServletBuscador")
public class ServletBuscador extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
		private Iservices ser=new Service();


    public ServletBuscador() {
      
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		continuar(request, response);
		
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
		
	}
	
	protected void continuar(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Producto producto = null;
		
		String buscadorHome=request.getParameter("homeBuscador");
		producto=ser.buscarNombre(buscadorHome);
		request.setAttribute("producto", producto);
		RequestDispatcher view = request.getRequestDispatcher("fichaprod.jsp");
		view.forward(request, response);
		System.out.println(producto.toString());
		
	}
	
	


}
