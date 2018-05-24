package services;

import java.util.ArrayList;

import model.Producto;

public interface Iservices {
	
	public Producto buscarNombre(String nombre);
	public void altaProducto(String nombre, String descripcion, String rutaImagen, String categoria, Float precio);
	public void bajaProducto(String nombre);
	public void modificarProducto(Producto p);
	public ArrayList<Producto> mostrarProductos();
	public ArrayList<Producto> mostrarCategorias(String tipo);

}
