/**
 * 
 */
package bd;

import java.sql.Connection;
import java.sql.DriverManager;

/**
 * @author iaw26509397
 *
 */
public class ConnectionManager {
	
	public static Connection getConnection() {
		Connection connection = null;
		try {
			Class.forName("org.postgresql.Driver");
			connection = DriverManager.getConnection("jdbc:postgresql://127.0.0.1:5432/test1", "daniel", "jupiter");
		} catch (Exception e) {
			System.out.println("fallo la conexion");
			e.printStackTrace();
		}
		return connection;
	}

}
