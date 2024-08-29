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
					menuBuscar();
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
	
	public void menuBuscar() throws IOException{
		while(true) {
			System.out.println("Buscar Película");
			System.out.println("1. Buscar por código");
			System.out.println("2. Buscar por título");
			System.out.println("3. Buscar por director");
			System.out.println("4. Buscar por género");
			System.out.println("5. Buscar por década");
			System.out.println("6. Volver");
			opcion = Integer.parseInt(lector.readLine());
			if(opcion == 6) break;
			switch(opcion) {
				case 1:
					searchCode();
					break;
				case 2:
					searchTitle();
				case 3:
				case 4:
				case 5:
				default:
			}
			System.out.println();
			System.out.println("Presiona ENTER para continuar");
			lector.readLine();		
			}
	}
	
	public void searchCode() throws IOException {
		System.out.print("Ingrese el código de la película a buscar: ");
		int codigo = Integer.parseInt(lector.readLine());
		Pelicula peli = almacen1.buscarPorCodigo(codigo);
		if(peli == null) System.out.println("Película no encontrada");
		else datosPelicula(peli);
	}
	
	public void searchTitle() throws IOException {
		System.out.print("Ingrese el título de la película a buscar: ");
		String title = lector.readLine();
		Pelicula peli = almacen1.buscarPorTitulo(title);
		if(peli == null) System.out.println("Película no encontrada");
		else datosPelicula(peli);
	}
	
	public void datosPelicula(Pelicula peli) {
		System.out.println("Título: " + peli.getTitulo());
		System.out.println("Código: " + peli.getCodigo());
		System.out.println("Género: " + peli.getGenero());
		System.out.println("Año: " + peli.getAño());
		System.out.println("Director: " + peli.getDirector());
	}
}



