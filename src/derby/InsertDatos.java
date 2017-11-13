package derby;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class InsertDatos {

	public static void main(String[] args) {
		String driver = "org.apache.derby.jdbc.EmbeddedDriver";
        String url = "jdbc:derby:C:/.../UF2_BasesDatos/derby/dbDerby";
        
        Connection con = null;
        Statement stm = null;
        
        try {
        	Class.forName(driver);
			con = DriverManager.getConnection(url);
			stm = con.createStatement();
			
			String sql = "INSERT INTO prueba VALUES (3,'DESCRIPCION TRES')";
			stm.executeUpdate(sql);
        	
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
