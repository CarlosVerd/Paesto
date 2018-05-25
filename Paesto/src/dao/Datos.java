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
	 * 
	 * Este método recibe los parametros de nombre, descripcion, rutaimagen,
	 * categoria,precio y los introduce en la base de datos en sus respectivas
	 * columnas en la base de datos, no devuelve nada ya solo se dedica ha
	 * introducir filas en la base *
	 * 
	 * 
	 * 
	 * @param Producto p
	 *            
	 */

	@Override
	public void altaProducto(Producto p) {
		String insertTableSQL = "INSERT INTO ventaron.productos"
				+ "(nombre, descripcion, rutaimagen, categoria,precio) VALUES" + "(?,?,?,?,?)";

		try {
			guardar = conection.prepareStatement(insertTableSQL);

			guardar.setString(1, p.getNombre());
			guardar.setString(2, p.getDescripcion());
			guardar.setString(3, p.getRutaImagen());
			guardar.setString(4, p.getCategoria());
			guardar.setFloat(5, p.getPrecio());
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
	 * <p>
	 * Metodo el cual recibe un nombre y realiza una consulta buscando en la
	 * base de datos y si encuentra un nombre que correspondiente con el dado,
	 * guarda todos los atributos encontrados en un objeto de tipo Producto
	 * </p>
	 * 
	 * @param Ingresa
	 *            un String
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

		String sql = "DELETE FROM productos WHERE nombre=" + "'" + nombre + "'";
		conexionBaseDatos();
		try {

			PreparedStatement sentencia = conection.prepareStatement(sql);

			sentencia.executeUpdate();

		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
	}

	/**
	 * <p>
	 * Metodo el cual realiza una consulta a la base de datos
	 * </p>
	 * 
	 * @return retorna un ArrayList de productos
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
	
	/**
	 * Este metodo recoge todos los productos de la base de datos mediante un ArrayList, y a traves del parametro que le damos crea un nuevo ArrayList
	 * para almacenar los productos de una determinada categoria, devuelve el nuevo ArrayList de categoría
	 */

	@Override
	public ArrayList<Producto> mostrarCategorias(String tipo) {

		ArrayList<Producto> productos = mostrarProductos();
		ArrayList<Producto> categoria = new ArrayList<>();

		for (int i = 0; i < productos.size(); i++) {
			if (productos.get(i).getCategoria().contains(tipo)) {
				categoria.add(productos.get(i));
			}
		}

		return categoria;
	}
	
	/**
	 * Este metodo actualiza un producto de la base de datos a traves de su nombre, se le pasa un producto y de ahí saca su nombre,
	 * no se puede modificar el nombre
	 */

	@Override
	public void modificarProducto(Producto p) {
		

		try {
			String sql = "UPDATE `productos` SET descripcion ='" + p.getDescripcion()
					+ "',rutaimagen ='" + p.getRutaImagen() + "',categoria ='" + p.getCategoria() + "',precio ='"
					+ p.getPrecio() + "' WHERE nombre ='"+ p.getNombre() + "'";

			guardar = conection.prepareStatement(sql);
			guardar.executeUpdate();
			
			conection.close();

		}  catch (SQLException e) {
			System.out.println("Excepcion SQL: " + e.getMessage());
			System.out.println("Estado SQL: " + e.getSQLState());
			System.out.println("Codigo de error: " + e.getErrorCode());
			e.printStackTrace();
		}
	}

}