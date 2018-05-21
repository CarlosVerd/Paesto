package services;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class bd2 {

	public static void mostrar(){
		
		
		try {
			
			Class.forName("com.mysql.jdbc.Driver");
			
			Connection con = DriverManager.getConnection("jdbc:mysql://10.90.36.7:3306/almacen","admin","1111");
			
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
	    
	/*
	public int Guardar(String nombres, String apellidos, String email, String celular, 
	                   String direccion, String sexo){

	int resultado = 0;

	Connection con = null;

	String SSQL = "INSERT INTO contacto (nombres, apellidos, email, celular, direccion, sexo) "
	            + "VALUES (?, ?, ?, ?, ?, ?)";


	    try {
	    
	        con = metodospool.dataSource.getConnection();
	        
	        PreparedStatement psql = con.prepareStatement(SSQL);
	        psql.setString(1, nombres);
	        psql.setString(2, apellidos);
	        psql.setString(3, email);
	        psql.setString(4, celular);
	        psql.setString(5, direccion);
	        psql.setString(6, sexo);
	        
	        resultado = psql.executeUpdate();
	        
	        psql.close();
	                    
	    } catch (SQLException e) {
	    
	        JOptionPane.showMessageDialog(null, "Error al intentar almacenar la información:\n"
	                                     + e, "Error en la operación", JOptionPane.ERROR_MESSAGE);
	        
	    }finally{
	    
	        try {
	            
	            if(con!=null){
	            
	                con.close();
	                
	            }
	            
	        } catch (SQLException ex) {
	        
	            JOptionPane.showMessageDialog(null, "Error al intentar cerrar la conexión:\n"
	                                     + ex, "Error en la operación", JOptionPane.ERROR_MESSAGE);
	            
	        }
	    
	    }

	    return resultado;
	    
	}*/
}
