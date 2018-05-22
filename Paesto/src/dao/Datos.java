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
	 * @return
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
	 * Este método recibe los parametros de nombre, descripcion, rutaimagen,
	 * categoria,precio y los introduce en la base de datos en sus respectivas
	 * columnas en la base de datos, no devuelve nada ya solo se dedica ha
	 * introducir filas en la base
	 */

	public void altaProducto(String nombre, String descripcion, String rutaImagen, String categoria, Float precio) {
		String insertTableSQL = "INSERT INTO ventaron.productos"
				+ "(nombre, descripcion, rutaimagen, categoria,precio) VALUES" + "(?,?,?,?,?)";

		try {
			guardar = (PreparedStatement) conection.prepareStatement(insertTableSQL);

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

	public Producto buscarNombre(String nombre) {

		conexionBaseDatos();
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

	public void bajaProducto(String nombre) {
		System.out.println();
	}

	/**
	 * 
	 * @param
	 * 
	 * @return
	 */
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
}