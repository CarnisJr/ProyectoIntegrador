package Logica;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Scanner;

public class Biblioteca {

	Scanner scan = new Scanner(System.in);
	
	//Constantes
	private final int TAMANIO = 5;
	private final int MULTA_ATRASO = 5;
	private final String[] AUTOR_ARRAY = {"Jose Luis Borges", "Gabriel Garcia Marquez", "Julio Cortazar", "Homero", "Edgar Allan Poe"};
	private final String[] LIBRO_ARRAY = {"El Aleph", "Cronica de una muerte anunciada", "Omnibus", "Odiseo", "Corazon delator"};
	
	//Variables
	private Libro[] librosArray = new Libro[TAMANIO];
	
	List<Persona> listaPersonas = new ArrayList<Persona>();
	List<Persona> listaDeudores = new ArrayList<Persona>();

	private int dia = 0;

	//Multa y fondos estan medida en dolares
	private	int asignarMulta = 0;
	private int fondosRecaudados = 0;
	
	public Biblioteca() {
		
		this.fondosRecaudados = 0;
		
		for(int i = 0; i < TAMANIO; i++) {

			this.librosArray[i] = new Libro(i + 1, true, LIBRO_ARRAY[i], AUTOR_ARRAY[i]);
		}
	}

	// -----------------------------------------------------------------
	// Getters y Setters
	// -----------------------------------------------------------------

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
	
	public int getFondosRecaudados() {
		
		return this.fondosRecaudados;
	}

	// -----------------------------------------------------------------
	// Metodos asociados con las funciones de la biblioteca
	// -----------------------------------------------------------------

	//Avanzar dia
	public int avanzarDia() {

		return this.dia++;
	}

	//Multar
	public void multar() {
		
		for(int i = 0; i < TAMANIO; i++) {
			if(librosArray[i].getDiasRetirado() > librosArray[i].getDiasPermisoRetirado()) {
				for(Persona per : listaPersonas) {
					if(per.getCodigoLibroRetirado() == librosArray[i].getCodigoID()) {
						
						this.asignarMulta = MULTA_ATRASO * (librosArray[i].getDiasRetirado() - librosArray[i].getDiasPermisoRetirado());
						per.setMulta(this.asignarMulta);
						break;
					}
				}
			}
		}
	}
	
	//Mostrar fondos recaudados por deudores
	public int mostrarFondos() {
		
		return this.fondosRecaudados;
	}

	// -----------------------------------------------------------------
	// Metodos asociados con el comportamiento de los libros
	// -----------------------------------------------------------------

	//Calcular los dias que ha estado el libro fuera
	public void diasLibroRetirado() {
		
		for(int i = 0; i < TAMANIO; i++) { 
			if(!librosArray[i].getEstado()) {
				
				librosArray[i].setDiasRetirado(this.dia - librosArray[i].getDiaSalida());
			}
		}

		multar();
	}
	
	//Retirar Libro
	public void retirarLibro(int codigoLibro, Persona per) {
		
		boolean flag = false;

		for(int i = 0; i < TAMANIO; i++) {
			if(librosArray[i].getCodigoID() == codigoLibro && librosArray[i].getEstado()) {
				
				librosArray[i].setEstado(false);
				librosArray[i].setDiaSalida(this.dia);
				librosArray[i].setCedulaCliente(per.getCedula());
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
		int pagarMulta = 0;

		for(int i = 0; i < TAMANIO; i++) {
			if(per.getMulta() == 0) {
				if(librosArray[i].getCodigoID() == codigoLibro && !librosArray[i].getEstado()) {
					
					librosArray[i].setEstado(true);
					per.setCodigoLibroRetirado(0);
					flag = true;
					break;
				}
			}else {
				
				System.out.println("Existe una multa de $" + per.getMulta());
				System.out.print("Ingrese el monto total a pagar: ");
				pagarMulta = scan.nextInt();
				this.fondosRecaudados += pagarMulta;
				per.setMulta(0);
				flag = true;
				break;
			}
		}
		
		if(flag == false) {
			
			System.out.println("Este libro no pertenece a la biblioteca");
		}
	}
	
	//Mostrar libros de la biblioteca
	public void mostrarListadoLibros() {
		
		for(int i = 0; i < TAMANIO; i++) {
			
			librosArray[i].infoLibro();
		}
	}

	// -----------------------------------------------------------------
	// Metodos asociados con el comportamiento de los clientes
	// -----------------------------------------------------------------
	
	
	//Ingresar nuevo cliente
	public void listarNuevoCliente(String nombre, String cedula) {
		
		Persona persona = new Persona(nombre, cedula);
		
		listaPersonas.add(persona);
	}
	
	//Buscar Cliente
	public Persona buscarCliente(String cedula) {
		
		for(Persona per : listaPersonas) {
			if(Objects.equals(per.getCedula(), cedula)) {
				return per;
			}
		}
		
		return null;
	}
	
	//Agregar cliente a lista de deudores
	public void agregarDeudor() {
		
		for(Persona per : listaPersonas) {
			if(per.getMulta() != 0) {
				
				this.listaDeudores.add(per);
			}
		}
	}
	
	//Quitar cliente a lista de deudores
	public void eliminarDeudor() {
		
		for(Persona per : listaPersonas) {
			if(per.getMulta() == 0) {
				
				this.listaDeudores.remove(per);
			}
		}
	}

	//Mostrar lista de deudores
	public void mostrarDeudor() {
	
		if(listaDeudores.isEmpty()) {
			
			System.out.println("No hay deudores");
		}else {

			for(Persona per : listaDeudores) {

				per.infoCliente();	
			}
		}
	}
}
