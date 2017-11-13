package sqlite;

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

public class MetaDatosSQLite {

	public static void main(String[] args) {
		String driver = "org.sqlite.JDBC";
		String url = "jdbc:sqlite:C:/...UF2_BasesDatos/dbSQLite/dbSQLite.db";
		
		Connection con = null;
		ResultSet rslt1 = null;
		ResultSet rslt2 = null;
		ResultSet rslt3 = null;
		
		try {
			Class.forName(driver);
			con = DriverManager.getConnection(url);
			
			DatabaseMetaData dbmd = con.getMetaData();
			
			String nombre = dbmd.getDatabaseProductName(); 
			String driverN = dbmd.getDriverName();
			String urlDB = dbmd.getURL();

			System.out.println("---- Metadatos");
			System.out.println("Nombre: " + nombre 
					+ "\nDriver: " + driverN
					+ "\nURL: " + urlDB);
			
			rslt1 = dbmd.getTables(null, "dbSQLite", null, null);
		
			String nomCat = ""; 
			String nomSchem = ""; 
			String nomTabla = ""; 
			String tipo = "";
			
			System.out.println("");
			System.out.println("---- Información de Tablas");
			while (rslt1.next()) {
				nomCat = rslt1.getString(1);
				nomSchem = rslt1.getString(2);
				nomTabla = rslt1.getString(3);
				tipo = rslt1.getString(4);
				
				System.out.println("Nombre Catálogo: " + nomCat
						+ "\nNombre Schema: " + nomSchem
						+ "\nNombre Tabla: " + nomTabla
						+ "\nTipo Tabla: " + tipo);
			}
			
			rslt2 = dbmd.getColumns(null, "dbSQLite", null, null);
			
			String nomCol = "";
			String tipoCol = "";
			String nula = "";
			
			System.out.println("");
			System.out.println("---- Información de Columnas");
			while (rslt2.next()) {
				nomTabla = rslt2.getString("TABLE_NAME");
				nomCol = rslt2.getString("COLUMN_NAME");
				tipoCol = rslt2.getString("TYPE_NAME");
				nula = rslt2.getString("IS_NULLABLE");
				
				System.out.println("Nombre Columna: " + nomCol
						+ "\nNombre Tabla: " + nomTabla
						+ "\nTipo Dato: " + tipoCol
						+ "\nPuede ser null: " + nula);
			}
			
			rslt3 = dbmd.getPrimaryKeys(null, "dbSQLite", "PRUEBA");
			
			System.out.println("");
			System.out.println("---- Información de Claves Primarias: ");
			while (rslt3.next()) {
				nomCol = rslt3.getString("COLUMN_NAME");
			}
			System.out.println("Clave primaria de PRUEBA: " + nomCol);
			
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if (rslt1 != null) {
					rslt1.close();
				}
				if (rslt2 != null) {
					rslt2.close();
				}
				if (rslt3 != null) {
					rslt3.close();
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
