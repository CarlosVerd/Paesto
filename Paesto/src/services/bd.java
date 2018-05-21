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
				
				Connection con = DriverManager.getConnection("jdbc:mysql://localhost/almacen","root","1111");
				
				PreparedStatement consulta = con.prepareStatement("SELECT * FROM productos");
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
}
