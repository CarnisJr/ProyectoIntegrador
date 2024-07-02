package Logica;
import java.util.Scanner;

public class Main {
	
	public static Scanner scan = new Scanner(System.in);
	
	public static void main(String[] args) {
		
		Biblioteca biblio = new Biblioteca();
		Persona persona = null;

		int codigoLibro = 0;
		int selector = 0;
		
		do {
			
			System.out.println(".:Menu principal:.");
			System.out.println("1. Ingresa Cliente");
			System.out.println("2. Retirar libro");
			System.out.println("3. Devolver libro");
			System.out.println("4. Ver lista de multas pendientes");
			System.out.println("5. Mostrar libros");
			System.out.println("6. Fondos recaudados por multas");
			System.out.println("7. Siguiente dia");
			System.out.println("8. Salir");
			selector = scan.nextInt();
			
			switch(selector) {
			
				case 1: 
					
					System.out.println(".:Ingresa Cliente:.");
					ingresarNuevoCliente(biblio);
					break;
				case 2: 

					System.out.println(".:Retirar un libro:.");
					persona = buscarCliente(biblio);
					if(persona == null) {
						
						System.out.println("No existe ese cliente");
						break;
					}
					System.out.println("Ingrese el codigo del libro que quiere retirar");
					codigoLibro = scan.nextInt();
					biblio.retirarLibro(codigoLibro, persona);
					break;
				case 3: 

					System.out.println(".:Devolver un libro:.");
					persona = buscarCliente(biblio);
					if(persona == null) {
						
						System.out.println("No existe ese cliente");
						break;
					}else {
						
						biblio.devolverLibro(persona);
						biblio.eliminarDeudor();
					}
					break;
				case 4: 

					System.out.println(".:Deudores:.");
					biblio.agregarDeudor();
					biblio.mostrarDeudor();
					break;
				case 5: 
					
					System.out.println(".:Listado de libros:.");
					biblio.mostrarListadoLibros();
					break;
				case 6: 

					System.out.println(".:Fondos recaudados de deudores:.");
					System.out.println("$" + biblio.getFondosRecaudados());
					break;
				case 7: 

					biblio.avanzarDia();
					biblio.diasLibroRetirado();
					System.out.println("Se avanzo al dia siguiente (Dia " + biblio.getDia() + ")...");
					break;
				case 8: 

					System.out.println(".:Saliendo:.");
					break;
				default:

					System.out.println(".:Opcion no disponible:.");
					break;
			}
		}while(selector != 8);
	}

	//Buscar Cliente
	public static Persona buscarCliente(Biblioteca biblioteca) {
		
		String cedula = "";
		System.out.print("Ingrese la cedula del cliente: ");
		cedula = scan.next();
		return biblioteca.buscarCliente(cedula);
	}
	
	//Ingresar Nuevo Cliente
	public static void ingresarNuevoCliente(Biblioteca biblioteca) {
		
		String nombre = "";
		String cedula = "";
		
		System.out.print("Ingresa el nombre: ");
		nombre = scan.next();
		System.out.print("Ingresa la cedula: ");
		cedula = scan.next();
		if(biblioteca.buscarCliente(cedula) != null) {
			
			System.out.println("Ya existe este cliente");
		}else {
			
			biblioteca.listarNuevoCliente(nombre, cedula);;
		}
	}

}
