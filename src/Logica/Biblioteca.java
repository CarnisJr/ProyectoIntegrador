package Logica;
import java.util.ArrayList;
import java.util.List;

public class Biblioteca {

	//Constantes
	private final int TAMANIO = 5;
	private final int MULTA_ATRASO = 5;
	private final String[] AUTOR_ARRAY = {"Jose Luis Borges", "Gabriel Garcia Marquez", "Julio Cortazar", "Homero", "Edgar Allan Poe"};
	private final String[] LIBRO_ARRAY = {"El Aleph", "Cronica de una muerte anunciada", "Omnibus", "Odiseo", "Corazon delator"};
	
	//Variables
	private Libro[] librosArray = new Libro[TAMANIO];
	
	List<Persona> listaPersonas = new ArrayList<Persona>();

	private int dia = 0;
	private int cont = 0;

	private boolean libroDisponible = false;
	private boolean penalizado = false;
	
	//Multa y fondos estan medida en dolares
	private int multa = 5;
	private	int asignarMulta = 0;
	private double fondosRecaudados = 0;
	
	public Biblioteca() {
		
		this.fondosRecaudados = 0;
		
		for(int i = 0; i < TAMANIO; i++) {

			this.librosArray[i] = new Libro(i + 1, true, LIBRO_ARRAY[i], AUTOR_ARRAY[i]);
		}
	}

	//Getter Setters
	public int getTamanioBiblioteca() {
		
		return this.TAMANIO;
	}

	public Libro getLibroBiblioteca(int i) {
		
		return this.librosArray[i];
	}
	
	public int getDia() {
		
		return this.dia;
	}
	
	public Persona getPersona(int i){
		
		return listaPersonas.get(i);
	}
	
	//Ingresar nuevo cliente
	public void listarNuevoCliente(String nombre, String cedula) {
		
		Persona persona = new Persona(nombre, cedula);
		
		listaPersonas.add(persona);
	}
	
	//Multar
	public void multar() {
		
		for(int i = 0; i < TAMANIO; i++) {
			if(librosArray[i].getDiasRetirado() > librosArray[i].getDiasPermisoRetirado()) {
				for(Persona per : listaPersonas) {
					if(per.getCodigoLibroRetirado() == librosArray[i].getCodigoID()) {
						
						this.asignarMulta = multa * (librosArray[i].getDiasRetirado() - librosArray[i].getDiasPermisoRetirado());
						per.setMulta(this.asignarMulta);
						break;
					}
				}
			}
		}
	}
	
	//Calcular los dias que ha estado el lubro fuera
	public void diasLibroRetirado() {
		
		for(int i = 0; i < TAMANIO; i++) { 

			if(!librosArray[i].getEstado()) {
				
				librosArray[i].setDiasRetirado(this.dia - librosArray[i].getDiaSalida());
			}
		}

		multar();
	}
	
	//Avanzar dia
	public int avanzarDia() {

		return this.dia++;
	}
	
	//Retirar Libro
	public void retirarLibro(int codigoLibro, Persona per) {
		
		boolean flag = false;

		for(int i = 0; i < TAMANIO; i++) {
			if(librosArray[i].getCodigoID() == codigoLibro && librosArray[i].getEstado()) {
				
				librosArray[i].setEstado(false);
				librosArray[i].setDiaSalida(this.dia);
				per.setCodigoLibroRetirado(librosArray[i].getCodigoID());
				flag = true;
				break;
			}
		}
		
		if(flag == false) {
			
			System.out.println("No existe ese libro o no esta disponible");
		}
	}
	
	//Devolver libro
	public void devolverLibro(int codigoLibro, Persona per) {
		
		boolean flag = false;

		for(int i = 0; i < TAMANIO; i++) {
			if(librosArray[i].getCodigoID() == codigoLibro && !librosArray[i].getEstado()) {
				
				librosArray[i].setEstado(true);
				per.setCodigoLibroRetirado(0);
				flag= true;
				break;
			}
		}
		
		if(flag == false) {
			
			System.out.println("Este libro no pertenece a la biblioteca");
		}
	}

}
