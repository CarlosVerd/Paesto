package dao;

import java.util.ArrayList;

import model.Producto;

public class prueba {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Datos b = new Datos();
		
		Producto a = b.buscarNombre("pepon");
		
		System.out.println(a.getRutaImagen());
	}

}
