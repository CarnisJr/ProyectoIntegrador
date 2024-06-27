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
		System.out.println("Dia: " + biblio.getDia());
		System.out.println("per 1: " + biblio.getPersona(0).getMulta());
		System.out.println("per 2: " + biblio.getPersona(1).getMulta());
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

}
