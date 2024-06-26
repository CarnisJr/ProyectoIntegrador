package Logica;

public class Biblioteca {

	//Constantes
	private final int TAMANIO = 5;
	private final String[] AUTOR_ARRAY = {"Jose Luis Borges", "Gabriel Garcia Marquez", "Julio Cortazar", "Homero", "Edgar Allan Poe"};
	private final String[] LIBRO_ARRAY = {"El Aleph", "Cronica de una muerte anunciada", "Omnibus", "Odiseo", "Corazon delator"};
	
	//Variables
	private Libro[] librosArray = new Libro[TAMANIO];

	private boolean libroDisponible = false;
	private boolean penalizado = false;
	
	//Multa y fondos estan medida en dolares
	private double multa = 10;
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
	
	//Retirar Libro
	public void retirarLibro(int codigoLibro) {
		
		boolean flag = false;

		for(int i = 0; i < TAMANIO; i++) {

			if(librosArray[i].getCodigoID() == codigoLibro && librosArray[i].getEstado()) {
				
				librosArray[i].setEstado(false);
				System.out.println(librosArray[i].getNombreLibro());
				flag= true;
				break;
			}
		}
		
		if(flag == false) {
			
			System.out.println("No existe ese libro o no esta disponible");
		}
	}
	
	//Devolver libro
	public void devolverLibro(int codigoLibro) {
		
		boolean flag = false;

		for(int i = 0; i < TAMANIO; i++) {

			if(librosArray[i].getCodigoID() == codigoLibro && !librosArray[i].getEstado()) {
				
				librosArray[i].setEstado(true);
				System.out.println(librosArray[i].getNombreLibro());
				flag= true;
				break;
			}
		}
		
		if(flag == false) {
			
			System.out.println("Este libro no pertenece a la biblioteca");
		}
	}

}
