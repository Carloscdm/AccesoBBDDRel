package tareaUF2_SQLite.model;

public class Equipo {
	
	private int id;
	private String nombre;
	private String ciudad;
	private int anioFund;
	
	public Equipo(String nombre, String ciudad, int anioFund) {
		this.nombre = nombre;
		this.ciudad = ciudad;
		this.anioFund = anioFund;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getId() {
		return id;
	}

	public String getNombre() {
		return nombre;
	}

	public String getCiudad() {
		return ciudad;
	}

	public int getAnioFund() {
		return anioFund;
	}
	
	

}
