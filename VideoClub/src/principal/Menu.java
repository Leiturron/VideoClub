package principal;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.ArrayList;

public class Menu {
	private int opcion;
	private BufferedReader lector;
	private Almacén almacen1;
	private Cliente clientes1;
	
	public Menu() throws IOException {
		almacen1 = new Almacén();
		almacen1.Datos();
		clientes1 = new Cliente();
		lector = new BufferedReader(new InputStreamReader(System.in));
	}
	//-----------------------------------------------------------------|
	//-------------------------Menu principal--------------------------|
	//-----------------------------------------------------------------|
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
	
	//-----------------------------------------------------------------|
	//-------------------Menu gestion de las peliculas-----------------|
	//-----------------------------------------------------------------|
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
					menuEliminar();
					break;
				case 3:
					menuBuscar();
					break;
				case 4:
					listarPeli();
					System.out.println();
					System.out.println("Presiona ENTER para continuar");
					lector.readLine();
					break;
				default:
					System.out.println("Opción invalida");
			}
		}
	}
	
	//-----------------------------------------------------------------|
	//--------------------Menu gestion de los usuarios-----------------|
	//-----------------------------------------------------------------|
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
					addPrestamo();
					break;
				case 2:
					deletePrestamo();
					break;
				case 3:
					searchUser();
					break;
				case 4:
					listUser();
					break;
				default:
					System.out.println("Opcion Invalida");
			}
		}
	}
	
	//-----------------------------------------------------------------|
	//---------------------------Herramientas--------------------------|
	//-----------------------------------------------------------------|
	
	//---------------------Imprimir datos de la pelicula---------------|
	public void datosPelicula(Pelicula peli) {
		System.out.println("Título: " + peli.getTitulo());
		System.out.println("Código: " + peli.getCodigo());
		System.out.println("Género: " + peli.getGenero());
		System.out.println("Año: " + peli.getAño());
		System.out.println("Director: " + peli.getDirector());
		System.out.println("Stock: " + peli.getStock());
	}
	
	//------------------------Listar peliculas-------------------------|
	public void listarPeli() throws IOException{
		System.out.println("Lista de las películas");
		for(int i= 0; i < almacen1.getPelículas().size(); i++) {
			System.out.println();
			datosPelicula(almacen1.getPelículas().get(i));
		}
	}
	
	//-----------------------------------------------------------------|
	//--------------Opciones del menu gestion pelicula-----------------|
	//-----------------------------------------------------------------|
	
	//---------------------- 1. Agregar película-----------------------|
	public void addNewPeli() throws IOException {
		int codigo = almacen1.getPelículas().size() + 1;
		System.out.print("Ingrese el título de la película: ");
		String titulo = lector.readLine();
		System.out.print("Ingrese el director de la película: ");
		String director = lector.readLine();
		System.out.print("Ingrese el género: ");
		String genero = lector.readLine();
		System.out.print("Ingrese el año de estreno: ");
		int anno = Integer.parseInt(lector.readLine());
		System.out.print("Ingrese el Stock: ");
		int stock = Integer.parseInt(lector.readLine());
		Pelicula peli = new Pelicula(codigo, titulo, director, genero, anno, stock);
		almacen1.agregarPelícula(peli);
		System.out.println();
		System.out.println("Se agregó correctamente");
		System.out.println("Presiona ENTER para continuar");
		lector.readLine();	
	}
	
	//---------------------- 2. Eliminar película----------------------|
	public void menuEliminar() throws IOException {
		while(true) {
			System.out.println("Eliminar una película");
			System.out.println("1. Eliminar por código");
			System.out.println("2. Eliminar por título");
			System.out.println("3. Volver");
			opcion = Integer.parseInt(lector.readLine());
			if(opcion == 3) return;
			System.out.print("Deseas ver la lista de las películas? (s/n): ");
			String opcionL = lector.readLine();
			if(opcionL.equalsIgnoreCase("s")) 
				listarPeli();
			else if(!opcionL.equalsIgnoreCase("n")) System.out.println("Opcion invalida (NO por defecto)");
			switch(opcion) {
				case 1:
					eliminarCode();
					break;
				case 2:
					eliminarTitle();
					break;
				default:
					System.out.println("Opcion invalida");
			}
			System.out.println();
			System.out.println("Presiona ENTER para continuar");
			lector.readLine();	
		}
	}
	
	public void eliminarCode() throws IOException {
		System.out.print("Ingrese el código de la película (0 para cancelar): ");
		int code = Integer.parseInt(lector.readLine());
		if(code == 0) return;
		almacen1.eliminarPelícula(code);
		System.out.println("Se eliminó correctamente");
	}
	
	public void eliminarTitle() throws IOException {
		System.out.print("Ingrese el título de la película (0 para cancelar): ");
		String title = lector.readLine();
		if(title.equals("0")) return;
		almacen1.eliminarPelícula(title);
		System.out.println("Se eliminó correctamente");
	}
	
	//------------------------ 3. Buscar película----------------------|
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
					break;
				case 3:
					searchDirect();
					break;
				case 4:
					searchGener();
					break;
				case 5:
					searchDecada();
					break;
				default:
					System.out.println("Opción Invalido");
					break;
			}
			System.out.println();
			System.out.println("Presiona ENTER para continuar");
			lector.readLine();	
			}
	}
	
	//Buscar por codigo
	public void searchCode() throws IOException {
		System.out.print("Ingrese el código de la película a buscar: ");
		int codigo = Integer.parseInt(lector.readLine());
		Pelicula peli = almacen1.buscarPorCodigo(codigo);
		if(peli == null) System.out.println("Película no encontrada");
		else datosPelicula(peli);
	}
	
	//Buscar por titulo
	public void searchTitle() throws IOException {
		System.out.print("Ingrese el título de la película a buscar: ");
		String title = lector.readLine();
		Pelicula peli = almacen1.buscarPorTitulo(title.toUpperCase());
		if(peli == null) System.out.println("Película no encontrada");
		else datosPelicula(peli);
	}
	
	//Buscar por director
	public void searchDirect()throws IOException {
		System.out.print("Ingrese el nombre del director: ");
		String nomb = lector.readLine();
		ArrayList<Pelicula> array = almacen1.buscarPorDirector(nomb.toUpperCase());
		if(array == null) System.out.println("No existe director llamado a " + nomb);
		else {
			System.out.println("Películas de " + nomb);
			for(int i = 0; i < array.size(); i++) {
				System.out.println();
				datosPelicula(array.get(i));
			}
		}
	}
	
	//Buscar por genero
	public void searchGener() throws IOException {
		System.out.print("Ingrese el género de la película: ");
		String genero = lector.readLine();
		ArrayList<Pelicula> array = almacen1.buscarPorGénero(genero.toUpperCase());
		if(array == null) System.out.println("No existe película de género " + genero);
		else {
			System.out.println("Películas de " + genero);
			for(int i = 0; i < array.size(); i++) {
				System.out.println();
				datosPelicula(array.get(i));
			}
		}
	}
	
	//Buscar por decada
	public void searchDecada() throws IOException {
		System.out.print("Ingrese el año (El sistema lo transforma a década): ");
		int anno = Integer.parseInt(lector.readLine());
		int decada = anno - anno % 10;
		ArrayList<Pelicula> array = almacen1.buscarPorDécada(decada);
		if(array == null) System.out.println("No existe película de década " + decada);
		else {
			System.out.println("Películas de década " + decada);
			for(int i = 0; i < array.size(); i++) {
				System.out.println();
				datosPelicula(array.get(i));
			}
		}
	}
	
	//-----------------------------------------------------------------|
	//-----------------Opciones del menu gestion usuario---------------|
	//-----------------------------------------------------------------|

	//-----------------------1. Agregar un préstamo--------------------|
	public void addPrestamo() throws IOException {
		System.out.print("Ingrese el rut del usuario: ");
		String rut = lector.readLine();
		Usuario user = clientes1.buscarUsuario(rut);
		if(user != null) {  //Usuario existente
			System.out.println("Se encontró el usuario: " + user.getNombre());
			System.out.println("Ingrese el título de la película a prestar: ");
			while(true) {
				String titulo = lector.readLine();
				Pelicula peli = almacen1.buscarPorTitulo(titulo);
				if(peli != null) {
					if(peli.getStock() != 0) {
						peli.prestar();
						clientes1.agregarPrestamo(rut, peli);
					}
					else
						System.out.println("Se acabó el stock de la pelicula " + peli.getTitulo());
					break;
				}
				else System.out.print("No encontró esta película, ingrese denuevo: ");
			}
		}
		else            //Usuario no esxistente
		{
			System.out.println("Registrando un nuevo usuario");
			System.out.print("Ingrese el nombre del usuario: ");
			String nombre = lector.readLine();
			Usuario newUser = new Usuario(nombre, rut);
			System.out.println("Ingrese el título de la película a prestar: ");
			while(true) {
				String titulo = lector.readLine();
				Pelicula peli = almacen1.buscarPorTitulo(titulo);
				if(peli != null) {
					if(peli.getStock() != 0) {
						peli.prestar();
						clientes1.agregarPrestamo(newUser, peli);
					}
					else
						System.out.println("Se acabó el stock de la pelicula " + peli.getTitulo());
					break;
					
				}
				else System.out.println("No encontró esta película, ingrese denuevo: ");
			}
		}	
	}
	
	//-----------------------2. Eliminar un préstamo-------------------|
	public void deletePrestamo() throws IOException {
		System.out.print("Ingrese el rut del usuario: ");
		String rut = lector.readLine();
		Usuario user = clientes1.buscarUsuario(rut);
		if(user != null) {
			System.out.println("Se encontró el usuario " + user.getNombre());
			System.out.println();
			if(user.getPeliculaPrestada().size() != 0) {
				System.out.println("Películas prestadas:");
				System.out.println();
				for(short i = 0; i < user.getPeliculaPrestada().size(); i++) {
					System.out.println((i + 1) + ". " + user.getPeliculaPrestada().get(i).getTitulo());
				}
				System.out.println();
				System.out.print("Ingrese el número de la película a devolver: ");
				int número = Integer.parseInt(lector.readLine());
				Pelicula peliUser = user.getPeliculaPrestada().get(número - 1);
				Pelicula peli = almacen1.buscarPorTitulo(peliUser.getTitulo());
				if(peli == null) {
					peliUser.setStock(1);
					almacen1.agregarPelícula(peliUser);
				}
				else {
					peli.devolver();
				}
				clientes1.eliminarPrestamo(user, peliUser.getTitulo());
				System.out.println();
				System.out.println("Película devuelta con éxito");
				System.out.println();
			}
			else System.out.println("El usuario no tiene películas prestadas");
		}
		else System.out.println("No existe usuario con ese Rut");
	}
	
	//-----------------------3. Buscar un usuario----------------------|
	public void searchUser() throws IOException {
		System.out.print("Ingrese el rut del usuario: ");
		System.out.println();
		String rut = lector.readLine();
		Usuario user = clientes1.buscarUsuario(rut);
		if(user != null) {
			System.out.println("Usuario encontrado:");
			System.out.println();
			user.datos();
		}
		else System.out.println("No existe usuario con ese Rut");
	}
	
	//--------------------------4. Listar usuarios---------------------|
	public void listUser() {
		if(clientes1.getCliente().size() != 0) {
			System.out.println("Lista de usuarios registrados:");
			System.out.println();
			int i = 1;
			for(String key: clientes1.getCliente().keySet()) {
				System.out.println("Usuario " + i);
				clientes1.getCliente().get(key).datos();
			}
		}
		else {
			System.out.println("No hay usuarios registrados para mostrar");
			System.out.println();
		}
	}
}



