package Logica;

public class Persona {

	private int multa = 0;
	private String nombre = "";
	private String cedula = "";
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

	//Presentar informacion del cliente
	public void infoCliente() {
		
		System.out.println(".:Informacion del cliente:.");
		System.out.println("Nombre: " + this.nombre);
		System.out.println("Cedula: " + this.cedula);
		if(this.estado) {
			
			System.out.println("No tiene deudas pendientes");
		}else {
			
			System.out.println("Tiene deudas pendientes");
			System.out.println("Deuda: " + this.multa);
		}
	}
}
