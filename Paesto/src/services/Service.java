package services;

import dao.Datos;
import dao.Idatos;

public class Service implements Iservices{

	private Idatos dat=new Datos();
	
	@Override
	public void buscarNombre() {
		dat.buscarNombre();
	}

	@Override
	public void altaProducto() {
		dat.altaProducto();
	}

	@Override
	public void bajaProducto() {
		dat.bajaProducto();
		
	}

	@Override
	public void mostrarProductos() {
		dat.mostrarProductos();
		
	}

}
