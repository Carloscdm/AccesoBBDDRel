package sqlite;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class EjemploSQLite {

	public static void main(String[] args) {
		String driver = "org.sqlite.JDBC";
		String url = "jdbc:sqlite:C:/...UF2_BasesDatos/dbSQLite/dbSQLite.db";
		
		Connection con = null;
		Statement st = null;
		ResultSet rslt = null;
		try {
			Class.forName(driver);
			
			con = DriverManager.getConnection(url);
			
			st = con.createStatement();
			rslt = st.executeQuery("SELECT * FROM PRUEBA");
			
			while (rslt.next()) {
				System.out.println(rslt.getString(1) + " - " + rslt.getString(2));
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
				
				if (st != null) {
					st.close();				
				}
				
				if (con != null) {
					con.close();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
		
	}

}
