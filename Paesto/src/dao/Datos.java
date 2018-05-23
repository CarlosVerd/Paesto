package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import model.Producto;

public class Datos implements Idatos {

	private static Connection conection = null;
	private PreparedStatement guardar = null;

	/**
	 * Conexion a una base de datos de MySql
	 * 
	 */

	public void conexionBaseDatos() {

		try {

			String driverClassName = "com.mysql.jdbc.Driver";
			String driverUrl = "jdbc:mysql://10.90.36.7:3306/ventaron";

			String user = "admin";
			String password = "1111";

			Class.forName(driverClassName);

			conection = DriverManager.getConnection(driverUrl, user, password);

		} catch (ClassNotFoundException e) {
			System.out.println("No se encuentra el driver");
			e.printStackTrace();
		} catch (SQLException e) {
			System.out.println("Excepcion SQL: " + e.getMessage());
			System.out.println("Estado SQL: " + e.getSQLState());
			System.out.println("Codigo de error: " + e.getErrorCode());
			e.printStackTrace();
		}

	}

	/**
	 * <p>
	 * Este método recibe los parametros de nombre, descripcion, rutaimagen,
	 * categoria,precio y los introduce en la base de datos en sus respectivas
	 * columnas en la base de datos, no devuelve nada ya solo se dedica ha
	 * introducir filas en la base
	 * </p>
	 */

	@Override
	public void altaProducto(String nombre, String descripcion, String rutaImagen, String categoria, Float precio) {
		String insertTableSQL = "INSERT INTO ventaron.productos"
				+ "(nombre, descripcion, rutaimagen, categoria,precio) VALUES" + "(?,?,?,?,?)";

		try {
			guardar = conection.prepareStatement(insertTableSQL);

			guardar.setString(1, "juan");
			guardar.setString(2, "carlos");
			guardar.setString(3, "balcno");
			guardar.setString(4, "balcno");
			guardar.setFloat(5, 100f);
			System.out.println("--probando " + guardar);
			guardar.executeUpdate();

			conection.close();

		} catch (SQLException e) {
			System.out.println("Excepcion SQL: " + e.getMessage());
			System.out.println("Estado SQL: " + e.getSQLState());
			System.out.println("Codigo de error: " + e.getErrorCode());
			e.printStackTrace();
		}

	}

	/**
	 * @author orlando
	 * 
	 *         <p>
	 *         Metodo el cual recibe un nombre y realiza una consulta buscando
	 *         en la base de datos y si encuentra un nombre que correspondiente
	 *         con el dado, guarda todos los atributos encontrados en un objeto
	 *         de tipo Producto
	 *         </p>
	 * 
	 * @param Ingresa un String
	 * 
	 * @return retorna uno objeto de productos
	 */
	
	@Override
	public Producto buscarNombre(String nombre) {

		String sql = "SELECT * FROM productos WHERE nombre=" + "'" + nombre + "'";

		Producto a = new Producto();
		conexionBaseDatos();
		try (

				PreparedStatement sentencia = conection.prepareStatement(sql);
				ResultSet resultado = sentencia.executeQuery();)

		{
			while (resultado.next()) {
				a.setNombre(resultado.getString("nombre"));
				a.setDescripcion(resultado.getString("descripcion"));
				a.setCategoria(resultado.getString("categoria"));
				a.setPrecio(resultado.getFloat("precio"));
				a.setRutaImagen(resultado.getString("rutaimagen"));
			}

		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}

		return a;

	}

	@Override
	public void bajaProducto(String nombre) {
		System.out.println();
	}

	/**
	 * @author orlando
	 * 
	 *         <p>
	 *         Metodo el cual realiza una consulta a la base de datos
	 *         </p>
	 * 
	 * @return retorna un ArrayList de productos
	 * 
	 */
	
	@Override
	public ArrayList<Producto> mostrarProductos() {

		String sql = "SELECT * FROM productos";

		ArrayList<Producto> a = new ArrayList<>();

		conexionBaseDatos();
		try (PreparedStatement sentencia = conection.prepareStatement(sql);
				ResultSet resultado = sentencia.executeQuery();)

		{

			while (resultado.next()) {
				a.add(new Producto(resultado.getString("nombre"), resultado.getString("descripcion"),
						resultado.getString("rutaimagen"), resultado.getString("categoria"),
						resultado.getFloat("precio")));
			}

		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}

		return a;
	}
	
	public ArrayList<Producto> mostrarCategorias(String tipo){

		ArrayList<Producto> productos=mostrarProductos();
		ArrayList<Producto> categoria=new ArrayList<>();
		
		for(int i=0;i<productos.size();i++){
			if(productos.get(i).getCategoria().contains(tipo)){
				categoria.add(productos.get(i));	
			}
		}
			
		return categoria;
	}
}