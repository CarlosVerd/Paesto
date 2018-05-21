package model;

public class Producto {
	
	private String nombre,descripcion,rutaImagen,categoria = null;
	private Float precio;
	
	
	
	public Producto() {}
	
	
	
	public Producto(String nombre, String descripcion, String rutaImagen, String categoria, Float precio) {
		super();
		this.nombre = nombre;
		this.descripcion = descripcion;
		this.rutaImagen = rutaImagen;
		this.categoria = categoria;
		this.precio = precio;
	}



	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getDescripcion() {
		return descripcion;
	}
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	public String getRutaImagen() {
		return rutaImagen;
	}
	public void setRutaImagen(String rutaImagen) {
		this.rutaImagen = rutaImagen;
	}
	public String getCategoria() {
		return categoria;
	}
	public void setCategoria(String categoria) {
		this.categoria = categoria;
	}
	public Float getPrecio() {
		return precio;
	}
	public void setPrecio(Float precio) {
		this.precio = precio;
	}



	@Override
	public String toString() {
		return "nombre=" + nombre + ", descripcion=" + descripcion + ", rutaImagen=" + rutaImagen
				+ ", categoria=" + categoria + ", precio=" + precio;
	}
	
	
	

}
