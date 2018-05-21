package services;

import dao.Datos;
import dao.Idatos;
import model.Producto;

public class Service implements Iservices{

	private Idatos dat=new Datos();

	@Override
	public Producto buscarNombre(String nombre) {
		Producto pro;
		pro=dat.buscarNombre(nombre);
		return pro;
	}

	@Override
	public void altaProducto(String nombre, String descripcion, String rutaImagen, String categoria, Float precio) {
		dat.altaProducto(nombre, descripcion, rutaImagen, categoria, precio);
		
	}

	@Override
	public void bajaProducto(String nombre) {
		dat.bajaProducto(nombre);
		
	}

	@Override
	public void mostrarProductos() {
		dat.mostrarProductos();	
	}
	


}
