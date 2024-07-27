package cl.desafioLatam.ConnectionBBDD;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionBBDD {

	private static Connection connection = null;
	
	
	public static Connection getConnection() {
		String driver = "org.postgresql.Driver";
		String url ="jdbc:postgresql://localhost:5432/start_up";
		String user ="postgres";
		String password ="root";

		try {
			
			Class.forName(driver);
			connection = DriverManager.getConnection(url, user, password);
			
			if (connection != null) {
				return connection;
			
			
			}
			
		} catch (ClassNotFoundException e) {
			
			System.out.println("Error. No se ha establecido conexion con el controlador: " + e.getMessage());
		} catch (SQLException e) {
			
			System.out.println("Error. No se ha podido establecer conexion con la base de datos: " + e.getMessage());
		}
		
		
		
		return null;
	}
	
	
	public static void closeConnection () {
		try {
			connection.close();
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
	}
	
	
	
	
	
	
	
	
	
}
