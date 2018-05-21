package control;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import services.Iservices;
import services.Service;


@WebServlet("/ServletGestion")
public class ServletGestion extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
		private Iservices ser=new Service();


    public ServletGestion() {
      
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		continuar(request, response);
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}
	
	protected void continuar(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		//ser.buscarNombre();
		//ser.altaProducto();
		//ser.bajaProducto();
		//ser.mostrarProductos();
		
	}


}
