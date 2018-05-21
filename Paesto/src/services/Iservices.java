package services;

public interface Iservices {
	
	public void buscarNombre(String nombre);
	public void altaProducto(String nombre, String descripcion, String rutaImagen, String categoria, Float precio);
	public void bajaProducto(String nombre);
	public void mostrarProductos();

}
