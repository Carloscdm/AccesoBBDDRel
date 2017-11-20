package tareaUF2_SQLite.accesoBBDD;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

public class AccesoBBDD {
	
	private String driver;
	private String url;
	
	public AccesoBBDD() {
		leerPropiedades();
	}

	private void leerPropiedades() {
		Properties propiedades = new Properties(); 
		InputStream entrada = null; 
		try { 
			entrada = new FileInputStream("configuracion.properties"); 
			// cargamos el archivo de propiedades 
			propiedades.load(entrada); 
			// obtenemos las propiedades y las imprimimos 
			String nameDB = propiedades.getProperty("nombreBD"); 
			driver = propiedades.getProperty("driver");
			url = propiedades.getProperty("url") + nameDB;
		} catch (IOException ex) { 
			ex.printStackTrace(); 
		}
	}
	
	public Connection getConexion() 
			throws ClassNotFoundException, SQLException {
		
		Connection con = null;
		
		Class.forName(driver);
		
		con = DriverManager.getConnection(url);
							
		return con;
	}
	
	public void crearTabla(String sql) {
		Connection con = null;
		Statement stmt = null;
		try {
			con = getConexion();
			
			stmt = con.createStatement();
			
			stmt.execute(sql);
			
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if (stmt != null) {
					stmt.close();
				}
				if (con != null) {
					con.close();
				}
			} catch (SQLException ex) {
				ex.printStackTrace();
			}
		}
		
	}
	

}
