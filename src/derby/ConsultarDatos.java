package derby;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class ConsultarDatos {

	public static void main(String[] args) {
		String driver = "org.apache.derby.jdbc.EmbeddedDriver";
		// ruta donde se encuentre la base de datos
        String url = "jdbc:derby:C:/.../UF2_BasesDatos/derby/dbDerby";
        
        Connection con = null;
        Statement stm = null;
        ResultSet rslt = null;
        
        try {
			Class.forName(driver);
			con = DriverManager.getConnection(url);
			stm = con.createStatement();
			
			String sql = "SELECT descripcion FROM prueba";
			rslt = stm.executeQuery(sql);
			
			while (rslt.next()) {
				System.out.println(rslt.getString("descripcion"));
				
			}
			
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if (rslt != null) {
					rslt.close();
				}
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
