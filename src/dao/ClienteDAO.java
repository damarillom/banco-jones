/**
 * 
 */
package dao;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Properties;

import bd.ConnectionManager;
import beans.Cliente;
/**
 * @author iaw26509397
 *
 */
public class ClienteDAO {
	static Connection con = null;
	
	public static Cliente loginValid(String user, String pass){
		Cliente c = new Cliente();
		con = ConnectionManager.getConnection();
		PreparedStatement stmt = null;
		ResultSet rs = null;
		try {
			Properties prop = new Properties();
			InputStream input = ClienteDAO.class.getClassLoader().getResourceAsStream("sql.properties");
			
			if ( input == null) {
				System.out.println("no se encontro el fichero");
			}
			
			prop.load(input);
			
			stmt = con.prepareStatement(prop.getProperty("cliente.login"));
			stmt.setString(1, pass);
			stmt.setString(2, user);
			
			//System.out.println("SELECT * FROM cliente WHERE contraseña=md5('" + pass + "')" + " AND dni='" + user + "'");
			//stmt = con.prepareStatement("SELECT * FROM cliente WHERE contraseña=md5('" + pass + "')" + " AND dni='" + user + "'");
			
			rs = (ResultSet) stmt.executeQuery();
		if (rs.next()) {
			c.setNombre(rs.getString("nombre"));
			c.setDni(rs.getString("dni"));
			c.setValid(true);
		} else {
			c.setValid(false);
		}
		}catch (SQLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}finally {
			if (rs != null) {
				try {
					rs.close();
				} catch(Exception e){
					e.printStackTrace();
				}
			}
			if (stmt != null) {
				try {
					stmt.close();
				} catch(Exception e){
					e.printStackTrace();
				}
			}
			if (con != null) {
				try {
					con.close();
				} catch(Exception e){
					e.printStackTrace();
				}
			}
		}
		return c;
	}
	
	public static Cliente newUser(String user, String nombre, String apellidos, String fecha_nacimiento, String sexo, String direccion, String telefono, String pass) {
		Cliente c = new Cliente();
		con = ConnectionManager.getConnection();
		PreparedStatement stmt = null;
		ResultSet rs = null;
		try {
			Properties prop = new Properties();
			InputStream input = ClienteDAO.class.getClassLoader().getResourceAsStream("sql.properties");
			
			if ( input == null) {
				System.out.println("no se encontro el fichero");
			}
			
			prop.load(input);
			
			stmt = con.prepareStatement(prop.getProperty("cliente.new"));
			stmt.setString(1, user);
			stmt.setString(2, nombre);
			stmt.setString(3, apellidos);
			stmt.setString(4, fecha_nacimiento);
			stmt.setString(5, sexo);
			stmt.setString(6, direccion);
			stmt.setString(7, telefono);
			stmt.setString(8, pass);
			
			rs = (ResultSet) stmt.executeQuery();
		if (rs.next()) {
			c.setNombre(rs.getString("nombre"));
			c.setDni(rs.getString("dni"));
			c.setValid(true);
		} else {
			c.setValid(false);
		}
		}catch (SQLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}finally {
			if (rs != null) {
				try {
					rs.close();
				} catch(Exception e){
					e.printStackTrace();
				}
			}
			if (stmt != null) {
				try {
					stmt.close();
				} catch(Exception e){
					e.printStackTrace();
				}
			}
			if (con != null) {
				try {
					con.close();
				} catch(Exception e){
					e.printStackTrace();
				}
			}
		}
		return c;
	}
}
