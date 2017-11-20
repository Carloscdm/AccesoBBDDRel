package tareaUF2_SQLite.main;

import tareaUF2_SQLite.accesoBBDD.DeportistaBBDD;
import tareaUF2_SQLite.accesoBBDD.EquipoBBDD;
import tareaUF2_SQLite.model.Deportista;
import tareaUF2_SQLite.model.Equipo;


public class EquipoMain {

	public static void main(String[] args) {
		EquipoBBDD ebd = new EquipoBBDD();
		DeportistaBBDD dbd = new DeportistaBBDD();
		int res = 0;
		ebd.crearTablaEquipo();
		
		Equipo eq1 = new Equipo("Real Madrid", "Madrid", 1902);
		//Equipo eq2 = new Equipo("Atletico de Madrid", "Madrid", 1903);
		
		res = ebd.insertarEquipo(eq1);
		if (res == 1) {
			System.out.println("El equipo se ha insertado correctamente");
		}
		
		int id = ebd.consultaIdEquipo(eq1.getNombre());
		eq1.setId(id);
		
		Deportista dep1 = new Deportista("Sergio Ramos", "1985-10-15", "central", 4, eq1);
		Deportista dep2 = new Deportista("Marcelo", "1988-05-12", "lateral izquierdo", 12, eq1);
		
		res = dbd.insertarDeportista(dep1);
		if (res == 1) {
			System.out.println("El deportista se ha insertado correctamente");
		}
		res = dbd.insertarDeportista(dep2);
		if (res == 1) {
			System.out.println("El deportista se ha insertado correctamente");
		}
		
		/*res = ebd.insertarEquipo(eq2);
		if (res == 1) {
			System.out.println("El equipo se ha insertado correctamente");
		}*/

	}

}
