package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import com.mysql.jdbc.PreparedStatement;

public class Datos implements Idatos {
	
	
	private static  Connection conection=null; 
	private PreparedStatement guardar=null;
	 
	 
 
	/**
	 * Conexion a uan base de datos de MySql
	 */

	public void conexionBaseDatos(){
	
	try {	

	String driverClassName ="com.mysql.jdbc.Driver";
	String driverUrl="jdbc:mysql://10.90.36.7:3306/ventaron";
	
	String user="admin";
	String password="1111";
	
	Class.forName(driverClassName);
		
	conection=DriverManager.getConnection(driverUrl, user, password);
	
	} catch (ClassNotFoundException e) {
		System.out.println("No se encuentra el driver");
		e.printStackTrace();
	} catch (SQLException e) {
		System.out.println("Excepcion SQL: "+ e.getMessage());
		System.out.println("Estado SQL: " + e.getSQLState());
		System.out.println("Codigo de error: " +e.getErrorCode());
		e.printStackTrace();
	}
	
	
	
}
	
	public void altaProducto(String nombre, String descripcion, String rutaImagen, String categoria, Float precio) {
		String insertTableSQL = "INSERT INTO ventaron.productos"
				+ "(nombre, descripcion, rutaimagen, categoria,precio) VALUES"
				+ "(?,?,?,?,?)";
		
		try {
			guardar = (PreparedStatement) conection.prepareStatement(insertTableSQL);

			
			guardar.setString(1, "juan");
			guardar.setString(2, "carlos");
			guardar.setString(3, "balcno");
			guardar.setString(4, "balcno");
			guardar.setFloat(5, 100f);	
		// execute insert SQL stetement
			System.out.println("--probando "+guardar);
			guardar .executeUpdate();
			
			conection.close();
		
		} catch (SQLException e) {
			System.out.println("Excepcion SQL: "+ e.getMessage());
			System.out.println("Estado SQL: " + e.getSQLState());
			System.out.println("Codigo de error: " +e.getErrorCode());
			e.printStackTrace();
		}
		
	}

	@Override
	public void buscarNombre(String nombre) {
		// TODO Auto-generated method stub
		
	}



	@Override
	public void bajaProducto(String nombre) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mostrarProductos() {
		// TODO Auto-generated method stub
		
	}



}
