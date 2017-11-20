package tareaUF2_SQLite.main;

import tareaUF2_SQLite.accesoBBDD.DeportistaBBDD;

public class DeportistaMain {

	public static void main(String[] args) {
		DeportistaBBDD dbd = new DeportistaBBDD();
		dbd.crearTablaDeportista();

	}

}
