package Logica;

public class Libro {
	
	private String nombreLibro = "";
	private String autor = "";

	private int codigoID = 0;
	private int diasRetirado = 0;
	private int diaDeSalida = 0;
	private int diasPermisoRetirado = 7;

	private boolean estado = true;
	
	public Libro(int codigo, boolean estado, String nombreLibro, String autor) {
		
		this.codigoID = codigo;
		this.estado = estado;
		this.autor = autor;
		this.nombreLibro = nombreLibro;
	}
	
	//Getters setters
	public String getNombreLibro() {
		
		return this.nombreLibro;
	}

	public String getAutor() {
		
		return this.autor;
	}

	public int getCodigoID() {
		
		return this.codigoID;
	}

	public boolean getEstado() {
		
		return this.estado;
	}

	public int getDiasRetirado() {
		
		return this.diasRetirado;
	}

	public void setDiasRetirado(int sumarDias) {
		
		this.diasRetirado = sumarDias;
	}

	public int getDiaSalida() {
		
		return this.diaDeSalida;
	}

	public void setDiaSalida(int diaSalida) {
		
		this.diaDeSalida = diaSalida;
	}

	public int getDiasPermisoRetirado() {
		
		return this.diasPermisoRetirado;
	}

	public void setDiasPermisoRetirado(int diasPermisoRetirado) {
		
		this.diasPermisoRetirado = diasPermisoRetirado;
	}
	public void setEstado(boolean estado) {
		
		this.estado = estado;
	}
}
