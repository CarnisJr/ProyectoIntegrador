package Logica;

public class Persona {

	private int multa = 0;
	private String nombre = "";
	private String cedula = "";
	private boolean tieneLibro = false;
	private boolean estado = false;
	private int codigoLibroRetirado = 0;
	
	public Persona(String nombre, String cedula) {
		
		this.nombre = nombre;
		this.cedula = cedula;
	}
	
	public int getMulta() {
		
		return this.multa;
	}

	public void setMulta(int multa) {
		
		this.multa = multa;
	}
	
	public String getNombre() {
		
		return this.nombre;
	}
	
	public String getCedula() {
		
		return this.cedula;
	}

	public int getCodigoLibroRetirado() {
		
		return this.codigoLibroRetirado;
	}

	public void setCodigoLibroRetirado(int codigoLibro) {
		
		this.codigoLibroRetirado = codigoLibro;
	}
}
