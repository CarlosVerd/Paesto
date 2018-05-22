package dao;

import java.util.ArrayList;

import model.Producto;

public class prueba {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Datos b = new Datos();
		
		Producto a = b.buscarNombre("barcelo");
		
		System.out.println(a.getNombre()+a.getDescripcion()+a.getRutaImagen());
		
		ArrayList<Producto> z = b.mostrarProductos();
		
		System.out.println(z.size());
	}

}
