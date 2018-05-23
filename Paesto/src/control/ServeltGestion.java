package control;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import services.Iservices;
import services.Service;

/**
 * Servlet implementation class ServeltGestion
 */
@WebServlet("/ServeltGestion")
public class ServeltGestion extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private Iservices ser=new Service();
	

	public ServeltGestion() {}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		continuar(request, response);

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doGet(request, response);

	}

	protected void continuar(HttpServletRequest request, HttpServletResponse response) {

		
	}

}
