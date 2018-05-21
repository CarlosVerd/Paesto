package services;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


public class bd {

	public static void main(String[] args){
		
		
			try {
				
				Class.forName("com.mysql.jdbc.Driver");
				
				Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/almacen","root","1111");
				
				PreparedStatement consulta = con.prepareStatement("SELECT * FROM producto");
				ResultSet resultado = consulta.executeQuery();
				
				while(resultado.next()){
				System.out.println(resultado.getInt(1)+" "+
								   resultado.getString(2)+" "+
								   resultado.getString(3)+" "+
								   resultado.getFloat(4)+" "+
								   resultado.getString(5));
				}
				
				con.close();
				
			} catch (ClassNotFoundException e) {
				System.out.println(e.getMessage()+"1");
				
				
			} catch (SQLException n){
				System.out.println(n.getMessage()+"2");
				
			}
	}
	package datos;

	import java.sql.Connection;
	import java.sql.DriverManager;
	import java.sql.ResultSet;
	import java.sql.SQLException;
	import java.sql.Statement;
	import java.util.ArrayList;

	import com.mysql.jdbc.PreparedStatement;

	public class Datos {
		
		 
		private static  Connection conection=null; 
		private PreparedStatement guardar=null;
		 
		 
	 
		/**
		 * Conexion a uan base de datos de MySql
		 */

		public void conexionBaseDatos(){
		
		try {	

		String driverClassName ="com.mysql.jdbc.Driver";
		String driverUrl="jdbc:mysql://localhost/ventaron";
		
		String user="root";
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
			String insertTableSQL = "INSERT INTO DBUSER"
					+ "(USER_ID, USERNAME, CREATED_BY, CREATED_DATE) VALUES"
					+ "(?,?,?,?)";
			
			try {
				guardar = (PreparedStatement) conection.prepareStatement(insertTableSQL);

				guardar.setString(1, "pepe");
				guardar.setString(2, "juan");
				guardar.setString(3, "carlos");
				guardar.setString(3, "balcno");
				guardar.setFloat(5, 100f);	
			// execute insert SQL stetement
				guardar .executeUpdate();
				
			
			
			} catch (SQLException e) {
				System.out.println("Excepcion SQL: "+ e.getMessage());
				System.out.println("Estado SQL: " + e.getSQLState());
				System.out.println("Codigo de error: " +e.getErrorCode());
				e.printStackTrace();
			}
			
		}
		
		
		public void mostrar() throws SQLException{
			
			while(consultaMostrarProductos.next()){
				System.out.println(consultaMostrarProductos.getInt(1));
				System.out.println(consultaMostrarProductos.getString(2));
				System.out.println(consultaMostrarProductos.getString(3));
				System.out.println(consultaMostrarProductos.getString(4));
				System.out.println(consultaMostrarProductos.getFloat(5));
			}
		}
}
