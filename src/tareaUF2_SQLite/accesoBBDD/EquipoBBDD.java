package tareaUF2_SQLite.accesoBBDD;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import tareaUF2_SQLite.model.Equipo;


/*
 * Esta clase se encarga de gestionar la tabla EQUIPO
 */
public class EquipoBBDD {
	private AccesoBBDD acceso;
		
	public EquipoBBDD() {
		acceso = new AccesoBBDD();
	}

	public void crearTablaEquipo() {
		String sql = "CREATE TABLE EQUIPO ( ID_EQUIPO INTEGER PRIMARY KEY AUTOINCREMENT, " 
						+ "NOMBRE VARCHAR(50) NOT NULL, "
						+ "CIUDAD VARCHAR(25), "
						+ "ANIO_FUND INT)";
			
		acceso.crearTabla(sql);
		
	}
	
	public int insertarEquipo(Equipo eq) {
		Connection con = null;
		PreparedStatement pstmt = null;
		int numReg = 0;
		
		try {
			con = acceso.getConexion();
			
			String sql = "INSERT INTO EQUIPO (NOMBRE, CIUDAD, ANIO_FUND) VALUES "
					+ "(?, ?, ?)";
			pstmt = con.prepareStatement(sql);
			
			pstmt.setString(1, eq.getNombre());
			pstmt.setString(2, eq.getCiudad());
			pstmt.setInt(3, eq.getAnioFund());
			
			numReg = pstmt.executeUpdate();
						
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if (pstmt != null) {
					pstmt.close();
				} 
				if (con != null) {
					con.close();
				}
			} catch (SQLException ex) {
				ex.printStackTrace();
			}
		}
		
		return numReg;
	}
	
	public int consultaIdEquipo(String nombre) {
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rslt = null;
		int id = 0;
		
		try {
			con = acceso.getConexion();
			
			String sql = "SELECT ID_EQUIPO FROM EQUIPO WHERE NOMBRE = ?";
			pstmt = con.prepareStatement(sql);
			
			pstmt.setString(1, nombre);
			
			rslt = pstmt.executeQuery();
			
			if (rslt.next()) {
				id = rslt.getInt("ID_EQUIPO");
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
				if (pstmt != null) {
					pstmt.close();
				} 
				if (con != null) {
					con.close();
				}
			} catch (SQLException ex) {
				ex.printStackTrace();
			}
		}
		
		return id;
	}

}
