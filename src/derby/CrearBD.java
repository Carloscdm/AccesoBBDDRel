package derby;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class CrearBD {

	public static void main(String[] args) {
        String driver = "org.apache.derby.jdbc.EmbeddedDriver";
        String url = "jdbc:derby:C:/.../UF2_BasesDatos/derby/";
        String dbName = "dbDerby";
        String dbParam = "create=true";

        Connection con = null;
        Statement stm = null;
        
        try {
			Class.forName(driver);
			con = DriverManager.getConnection(url + dbName + ";" + dbParam);
			stm = con.createStatement();
			
			String sql = "CREATE TABLE prueba ( id INTEGER PRIMARY KEY, " +
		             "descripcion VARCHAR(50) NOT NULL )";
			
			stm.execute(sql);
			
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if (stm != null) {
					stm.close();
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
