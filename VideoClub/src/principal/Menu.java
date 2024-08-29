package principal;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class Menu {
	private int opcion;
	private BufferedReader lector;
	private Almacén almacen1;
	
	public Menu() throws IOException {
		almacen1 = new Almacén();
		almacen1.Datos();
		lector = new BufferedReader(new InputStreamReader(System.in));
	}
	
	public void menuPrincipal() throws IOException {
		int opcion;
		while(true) {
			System.out.println("     Sistema de gestión");
			System.out.println("1. Gestión de las películas");
			System.out.println("2. Gestión de los usuarios");
			System.out.println("3. Salir del sistema");
			opcion = Integer.parseInt(lector.readLine());
			switch(opcion) {
				case 1: //Menu de gestionar películas
					gestionPeliculas();
					break;
				case 2: //Menu de gestionar usuarios
					gestionUsuarios();
					break;
				case 3:
					System.out.println("Saliendo del sistema");
					System.exit(0);
				default:
					System.out.println("Opción invalido");
					break;
			}
			System.out.println();
			System.out.println("Presiona ENTER para continuar");
			lector.readLine();
		}
	}
	
	public void gestionPeliculas() throws IOException {
		while(true) {
			System.out.println("Gestión de películas");
			System.out.println("1. Agregar película");
			System.out.println("2. Eliminar película");
			System.out.println("3. Buscar película");
			System.out.println("4. Listar Películas");
			System.out.println("5. Volver");
			opcion = Integer.parseInt(lector.readLine());
			if(opcion == 5) break;
			switch(opcion){
				case 1:
					addNewPeli();
					break;
				case 2:
				case 3:
				case 4:
				default:
			}
		}
	}
	
	public void gestionUsuarios() throws IOException {
		while(true) {
			System.out.println("Gestion de usuarios");
			System.out.println("1. Agregar un préstamo");
			System.out.println("2. Eliminar un préstamo");
			System.out.println("3. Buscar usuario");
			System.out.println("4. Listar usuarios");
			System.out.println("5. Volver");
			opcion = Integer.parseInt(lector.readLine());
			if(opcion == 5) break;
			switch(opcion) {
				case 1:
				case 2:
				case 3:
				case 4:
				default:
			}
		}
	}
	
	public void addNewPeli() throws IOException {
		int codigo = almacen1.getPelículas().size();
		System.out.print("Ingrese el título de la película: ");
		String titulo = lector.readLine();
		System.out.print("Ingrese el director de la película: ");
		String director = lector.readLine();
		System.out.println("Ingrese el género: ");
		String genero = lector.readLine();
		System.out.print("Ingrese el año de estreno: ");
		int anno = Integer.parseInt(lector.readLine());
		System.out.println("Ingrese el Stock");
		int stock = Integer.parseInt(lector.readLine());
		Pelicula peli = new Pelicula(codigo, titulo, director, genero, anno, stock);
		almacen1.agregarPelícula(peli);
	}
}
