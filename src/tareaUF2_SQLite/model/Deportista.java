package tareaUF2_SQLite.model;

public class Deportista {
	private int id;
	private String nombre;
	private String fecNacimiento;
	private String posicion;
	private int numero;
	private Equipo equipo;
	
	public Deportista(String nombre, String fecNacimiento, String posicion, int numero, Equipo equipo) {
		this.nombre = nombre;
		this.fecNacimiento = fecNacimiento;
		this.posicion = posicion;
		this.numero = numero;
		this.equipo = equipo;
	}

	public int getId() {
		return id;
	}

	public String getNombre() {
		return nombre;
	}

	public String getFecNacimiento() {
		return fecNacimiento;
	}

	public String getPosicion() {
		return posicion;
	}

	public int getNumero() {
		return numero;
	}

	public Equipo getEquipo() {
		return equipo;
	}

	public void setId(int id) {
		this.id = id;
	}

	
	
}
