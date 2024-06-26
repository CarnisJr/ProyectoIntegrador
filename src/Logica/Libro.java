package Logica;

public class Libro {
	

	private String nombreLibro = "";
	private String autor = "";

	private int codigoID = 0;

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

	public void setEstado(boolean estado) {
		
		this.estado = estado;
	}
}
