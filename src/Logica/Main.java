package Logica;
import java.util.Scanner;

public class Main {
	
	public static Scanner scan = new Scanner(System.in);
	
	public static void main(String[] args) {
		
		Biblioteca biblio = new Biblioteca();
		
		biblio.retirarLibro(5);
		pruebas(biblio);
		
		for(int j = 0; j < 9; j++) {
			
			System.out.println(biblio.avanzarDia());
		}

		for(int i = 0; i < biblio.getTamanioBiblioteca(); i++) {
			
			System.out.println(biblio.getLibroBiblioteca(i).getDiasRetirado());
		}
	}

	// Para hacer pruebas
	public static void pruebas(Biblioteca biblioteca) {
		
		for(int i = 0; i < biblioteca.getTamanioBiblioteca(); i++) {
			
			System.out.println(biblioteca.getLibroBiblioteca(i).getEstado());
		}
		
	}

}
