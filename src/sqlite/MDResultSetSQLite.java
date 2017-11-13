package sqlite;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;

public class MDResultSetSQLite {

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
			
			ResultSetMetaData rsltMd = rslt.getMetaData();
			
			int numReg = rsltMd.getColumnCount();
			System.out.println("Se han recuperado " + numReg + " registros");
			
			for (int i = 1; i <= numReg; i++) {
				System.out.println("Columna: " + i);
				System.out.println("Nombre Columna: " + rsltMd.getColumnName(i));
				System.out.println("Tipo de Columna: " + rsltMd.getColumnTypeName(i));
				System.out.println("Precisión: " + rsltMd.getPrecision(i));
				
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
