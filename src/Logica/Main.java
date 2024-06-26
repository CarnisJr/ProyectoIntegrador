package Logica;
import java.util.Scanner;

public class Main {
	
	public static Scanner scan = new Scanner(System.in);
	
	public static void main(String[] args) {
		
		Biblioteca biblio = new Biblioteca();
		
		biblio.retirarLibro(5);
		pruebas(biblio);
		biblio.devolverLibro(5);
		pruebas(biblio);
	}

	// Para hacer pruebas
	public static void pruebas(Biblioteca biblioteca) {
		
		for(int i = 0; i < biblioteca.getTamanioBiblioteca(); i++) {
			
			System.out.println(biblioteca.getLibroBiblioteca(i).getEstado());
		}
		
	}

}
