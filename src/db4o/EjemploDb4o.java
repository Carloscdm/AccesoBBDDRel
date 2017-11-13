package db4o;

import com.db4o.Db4oEmbedded;
import com.db4o.ObjectContainer;
import com.db4o.ObjectSet;

public class EjemploDb4o {
	static final String BDPer = "db4o-8.0/BDPersona.yap";

	public static void main(String[] args) {
		ObjectContainer db = Db4oEmbedded.openFile(Db4oEmbedded.newConfiguration(), 
				BDPer);
		//insertarDatos(db);
		
		System.out.println("");
		System.out.println("CONSULTA GENÉRICA");
		consultarDatos(db);
		
		System.out.println("");
		System.out.println("CONSULTA ESPECÍFICA");
		consultarDatos2(db);
		
		System.out.println("");
		System.out.println("MODIFICACIÓN");
		modificarDatos(db);
		
		System.out.println("");
		System.out.println("BORRADO");
		eliminarDatos(db);
		
		db.close();
	}

	private static void consultarDatos(ObjectContainer db) {
		
		Persona pDefault = new Persona();
		
		ObjectSet<Persona> result = db.queryByExample(pDefault);
		
		if (result.size() == 0) {
			System.out.println("No existen registro de Persona");
		} else {
			System.out.println("Número de registros de Persona: " + result.size());
			while (result.hasNext()) {
				pDefault = result.next();
				System.out.println("Nombre: " + pDefault.getNombre() 
								+ " Ciudad: " + pDefault.getCiudad());
				
				
			}
		}
		
	}

	public static void insertarDatos(ObjectContainer db) {
		
		Persona p1 = new Persona("Ana", "Avila");
		Persona p2 = new Persona("Juan", "Leon");
		Persona p3 = new Persona("Gema", "Caceres");
		Persona p4 = new Persona("Sergio", "Bilbao");
		
		db.store(p1);
		db.store(p2);
		db.store(p3);
		db.store(p4);
		
	}
	
	private static void consultarDatos2(ObjectContainer db) {
		
		Persona pDefault = new Persona("Ana", null);
		
		ObjectSet<Persona> result = db.queryByExample(pDefault);
		
		if (result.size() == 0) {
			System.out.println("No existen registro de Persona para el nombre Ana");
		} else {
			System.out.println("Número de registros de Persona: " + result.size());
			while (result.hasNext()) {
				pDefault = result.next();
				System.out.println("Nombre: " + pDefault.getNombre() 
								+ " Ciudad: " + pDefault.getCiudad());
				
				
			}
		}
		
	}
	
	private static void modificarDatos(ObjectContainer db) {
		
		Persona pDefault = new Persona("Gema", null);
		
		ObjectSet<Persona> result = db.queryByExample(pDefault);
		
		if (result.size() == 0) {
			System.out.println("No existen registro de Persona para el nombre Gema");
		} else {
			System.out.println("Número de registros de Persona: " + result.size());
			pDefault = result.next();
				
			pDefault.setCiudad("Toledo");
			db.store(pDefault);
			
			result = db.queryByExample(new Persona("Gema", null));
			while (result.hasNext()) {
				pDefault = result.next();
				System.out.println("Nombre: " + pDefault.getNombre() 
								+ " Ciudad: " + pDefault.getCiudad());
			}

		}
		
	}
	
	private static void eliminarDatos(ObjectContainer db) {
		
		Persona pDefault = new Persona("Gema", "Caceres");
		
		ObjectSet<Persona> result = db.queryByExample(pDefault);
		
		if (result.size() == 0) {
			System.out.println("No existen registro de Persona para el nombre Gema y la ciudad Cáceres");
		} else {
			System.out.println("Número de registros de Persona: " + result.size());
			pDefault = result.next();
			System.out.println("Nombre: " + pDefault.getNombre() 
							+ " Ciudad: " + pDefault.getCiudad());
				
			if (result.size() > 1) {
				while (result.hasNext()) {
					pDefault = result.next();
					db.delete(pDefault);
				}
			}
			
			result = db.queryByExample(new Persona("Gema", "Caceres"));
			System.out.println("Número de registros de Persona para el nombre Gema y la ciudad Cáceres: " + result.size());
			

		}
		
	}
	
}
