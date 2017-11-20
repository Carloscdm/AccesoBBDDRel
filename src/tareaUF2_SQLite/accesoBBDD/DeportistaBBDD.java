package tareaUF2_SQLite.accesoBBDD;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import tareaUF2_SQLite.model.Deportista;


public class DeportistaBBDD {
	private AccesoBBDD acceso;
	
	public DeportistaBBDD() {
		acceso = new AccesoBBDD();
	}
	
	public void crearTablaDeportista() {
		String sql = "CREATE TABLE DEPORTISTA ( ID_DEP INTEGER PRIMARY KEY AUTOINCREMENT, " 
						+ "NOMBRE VARCHAR(50) NOT NULL, "
						+ "FEC_NACIMIENTO DATE, "
						+ "POSICION VARCHAR(25), "
						+ "NUMERO INT, "
						+ "ID_EQUIPO INT, "
						+ "FOREIGN KEY(ID_EQUIPO) REFERENCES EQUIPO(ID_EQUIPO))";
			
		acceso.crearTabla(sql);
		
	}
	
	public int insertarDeportista(Deportista dep) {
		Connection con = null;
		PreparedStatement pstmt = null;
		int numReg = 0;
		
		try {
			con = acceso.getConexion();
			
			String sql = "INSERT INTO DEPORTISTA (NOMBRE, FEC_NACIMIENTO, "
					+ "POSICION, NUMERO, ID_EQUIPO) VALUES "
					+ "(?, DATE(?), ?, ?, ?)";
			pstmt = con.prepareStatement(sql);
			
			pstmt.setString(1, dep.getNombre());
			pstmt.setString(2, dep.getFecNacimiento());
			pstmt.setString(3, dep.getPosicion());
			pstmt.setInt(4, dep.getNumero());
			pstmt.setInt(5, dep.getEquipo().getId());
			
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
	
	
}
