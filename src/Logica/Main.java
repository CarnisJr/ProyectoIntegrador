package Logica;
import java.util.Scanner;

public class Main {
	
	public static Scanner scan = new Scanner(System.in);
	
	public static void main(String[] args) {
		
		Biblioteca biblio = new Biblioteca();
		
		ingresarNuevoCliente(biblio);
		biblio.retirarLibro(5, biblio.getPersona(0));

		for(int i = 0; i < 10; i++) {
			
			biblio.avanzarDia();
		}

		ingresarNuevoCliente(biblio);
		biblio.retirarLibro(2, biblio.getPersona(1));
		
		for(int i = 0; i < 2; i++) {
			
			biblio.avanzarDia();
		}

		biblio.diasLibroRetirado();
		biblio.agregarDeudor();
		biblio.mostrarDeudor();
		biblio.devolverLibro(5, biblio.getPersona(0));
		biblio.eliminarDeudor();
		biblio.mostrarDeudor();
	}

	// Para hacer pruebas
	public static void pruebas(Biblioteca biblioteca) {
		
		for(int i = 0; i < biblioteca.getTamanioBiblioteca(); i++) {
			
			System.out.println(biblioteca.getLibroBiblioteca(i).getDiasRetirado());
		}
	}
	
	//Ingresar Nuevo Cliente
	public static void ingresarNuevoCliente(Biblioteca biblioteca) {
		
		String nombre = "";
		String cedula = "";
		
		System.out.print("Ingresa el nombre: ");
		nombre = scan.next();
		System.out.print("Ingresa la cedula: ");
		cedula = scan.next();
		
		biblioteca.listarNuevoCliente(nombre, cedula);;
	}

	//Menu
	public static void desplegarMenu(Biblioteca biblioteca) {
		
		int selector = 0;
		
		do {
			
			System.out.println(".:Menu principal:.");
			System.out.println("1. Ingresa Cliente");
			System.out.println("2. Retirar libro");
			System.out.println("3. Devolver libro");
			System.out.println("4. Cobrar multa");
			System.out.println("5. Ver lista de multas pendientes");
			System.out.println("6. Mostrar libros");
			System.out.println("7. Fondos recaudados por multas");
			System.out.println("8. Salir");
			selector = scan.nextInt();
			
			switch(selector) {
			
				case 1: 
					
					break;
				case 2: 

					break;
				case 3: 

					break;
				case 4: 

					break;
				case 5: 

					break;
				case 6: 

					break;
				case 7: 

					break;
				case 8: 

					break;
					
				default:

					break;
			}
		}while(selector != 5);
		
	}
}
