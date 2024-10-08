package principal;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.InputStreamReader;
import java.io.IOException;

public class Menu {
	private int opcion;
	private BufferedReader lector;
	private Almacén almacen1;
	private Cliente clientes1;
	private Ventas ventas1;
	
	public Menu() throws IOException, EmptyValueException {
		almacen1 = new Almacén();
		almacen1.Datos();
		clientes1 = new Cliente();
		ventas1 = new Ventas();
		lector = new BufferedReader(new InputStreamReader(System.in));
	}
	//-----------------------------------------------------------------|
	//-------------------------Menu principal--------------------------|
	//-----------------------------------------------------------------|
	public void menuPrincipal() throws IOException, NameInvalidException, InvalidDirectorException, EmptyValueException {
		int opcion;
		while(true) {
			System.out.println("     Sistema de gestión");
			System.out.println("1. Gestión de las películas");
			System.out.println("2. Gestión de los usuarios");
			System.out.println("3. Gestión de ventas");
			System.out.println("4. Salir del sistema");
			opcion = Integer.parseInt(lector.readLine());
			switch(opcion) {
				case 1: //Menu de gestion películas
					gestionPeliculas();
					break;
				case 2: //Menu de gestion usuarios
					gestionUsuarios();
					break;
				case 3: //Menu de gestion ventas
					gestionVentas();
					break;
				case 4:
					System.out.println("Saliendo del sistema");
					return;
				default:
					System.out.println("Opción invalida");
					break;
			}
			System.out.println();
		}
	}
	
	//-----------------------------------------------------------------|
	//-------------------Menu gestion de las peliculas-----------------|
	//-----------------------------------------------------------------|
	public void gestionPeliculas() throws IOException, NameInvalidException, InvalidDirectorException, EmptyValueException {
		while(true) {
			System.out.println("Gestión de películas");
			System.out.println("1. Agregar película");
			System.out.println("2. Eliminar película");
			System.out.println("3. Buscar película");
			System.out.println("4. Editar película");
			System.out.println("5. Listar Películas");
			System.out.println("6. Volver");
			opcion = Integer.parseInt(lector.readLine());
			if(opcion == 6) break;
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
					editPeli();
					break;
				case 5:
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
	public void gestionUsuarios() throws IOException, EmptyValueException {
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
	//--------------------Menu gestion de las ventas-------------------|
	//-----------------------------------------------------------------|
	public void gestionVentas() throws IOException {
		while(true) {
			System.out.println("Gestion de ventas");
			System.out.println("1. Mostrar ventas");
			System.out.println("2. Cerrar ventas");
			System.out.println("3. Volver");
			opcion = Integer.parseInt(lector.readLine());
			if(opcion == 3) break;
			switch(opcion) {
				case 1:
					mostrarVentas();
					break;
				case 2:
					cerrarVentas();
					break;
				default:
					System.out.println("Opción Invalida");
			}	
		}
	}
	
	//-----------------------------------------------------------------|
	//---------------------------Herramientas--------------------------|
	//-----------------------------------------------------------------|
	
	//----------------Imprimir los datos de la pelicula----------------|
	public static void datosPelicula(Pelicula peli) {
		System.out.println();
		System.out.println("Título: " + peli.getTitulo());
		System.out.println("Código: " + peli.getCodigo());
		System.out.println("Género: " + peli.getGenero());
		System.out.println("Año: " + peli.getAño());
		System.out.println("Director: " + peli.getDirector());
		System.out.println("Stock: " + peli.getStock());
		System.out.println("Descripción: " + peli.getDescripcion());
		System.out.println("Precio: $" + peli.getPrecio());
		System.out.println();
	}
	
	//------------------------Listar peliculas-------------------------|
	public void listarPeli() throws IOException{
		System.out.println("Lista de las películas");
		for(int i= 0; i < almacen1.getSizePeliculas(); i++) {
			System.out.println();
			datosPelicula(almacen1.getPelicula(i));
		}
	}
	
	//-----------------------------------------------------------------|
	//--------------Opciones del menu gestion pelicula-----------------|
	//-----------------------------------------------------------------|
	
	//---------------------- 1. Agregar película-----------------------|
	public void addNewPeli() throws IOException, EmptyValueException {
		int codigo = almacen1.getOrden();
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
			System.out.print("¿Deseas ver la lista de las películas? (s/n): ");
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
		try {
			System.out.print("Ingrese el código de la película (0 para cancelar): ");
			int code = Integer.parseInt(lector.readLine());
			if(code == 0) return;
			boolean eliminado = almacen1.eliminarPelícula(code);
			if(eliminado) {
				System.out.println("Se eliminó correctamente");
			}
		}
		catch (NumInvalidException e) {
			System.out.println("No se encontro el codigo");
		}
	}
	
	public void eliminarTitle() throws IOException {
		try {
			System.out.print("Ingrese el título de la película (0 para cancelar): ");
			String title = lector.readLine();
			if(title.equals("0")) return;
			boolean eliminado = almacen1.eliminarPelícula(title);
			if(eliminado) {
				System.out.println("Se eliminó correctamente");
			} 
		}
		catch (Exception e) {
			System.out.println("No se encontro el titulo");
		}
		
	}
	
	//------------------------ 3. Buscar película----------------------|
	public void menuBuscar() throws IOException, NameInvalidException, InvalidDirectorException{
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
					System.out.println("Opción Invalida");
					break;
			}
			System.out.println();
			System.out.println("Presiona ENTER para continuar");
			lector.readLine();	
			}
	}
	
	//Buscar por codigo
	public void searchCode() throws IOException {
		try {
		System.out.print("Ingrese el código de la película a buscar: ");
		int codigo = Integer.parseInt(lector.readLine());
		Pelicula peli = almacen1.buscarPorCodigo(codigo);
		if(peli == null) System.out.println("Película no encontrada");
		else datosPelicula(peli);
		}
		catch(NumInvalidException e) {
			System.out.println("No se encontró el código");
		}
	}
	
	//Buscar por titulo
	public void searchTitle() throws IOException, NameInvalidException {
		System.out.print("Ingrese el título de la película a buscar: ");
		String title = lector.readLine();
		Pelicula peli = almacen1.buscarPorTitulo(title.toUpperCase());
		if(peli == null) System.out.println("Película no encontrada");
		else datosPelicula(peli);
	}
	
	//Buscar por director
	public void searchDirect()throws IOException, InvalidDirectorException {
		System.out.print("Ingrese el nombre del director: ");
		String nomb = lector.readLine();
		
		PeliDirector objDirec = almacen1.buscarPorDirector(nomb);
		
		System.out.println("Películas de " + nomb);
		objDirec.listarPeliculas();
		
	}
	
	//Buscar por genero
	public void searchGener() throws IOException {
		System.out.print("Ingrese el género de la película: ");
		String genero = lector.readLine();
		try {
			PeliGenero objGenre = almacen1.buscarPorGenero(genero);
			System.out.println("Películas de " + genero);
			objGenre.listarPeliculas();
		}
		catch(InvalidGenreException e){
			System.out.println("No existe película de género " + genero);
		}
	}
	
	//Buscar por decada
	public void searchDecada() throws IOException {
		try {
			System.out.print("Ingrese el año (El sistema lo transforma a década): ");
			int anno = Integer.parseInt(lector.readLine());
			int decada = anno - anno % 10;
			PeliDecada objDec = almacen1.buscarPorDecada(decada);
			System.out.println("Películas de década " + decada);
			objDec.listarPeliculas();
		}
		catch(InvalidDecadeException e){
			System.out.println("No existen películas en esa década");
		}
	}
	
	//------------------------ 4. Editar película----------------------|
	public void editPeli() throws IOException {
		try {
			System.out.println("Ingrese el título de la película a editar: ");
			String titulo = lector.readLine();
			Pelicula peli = almacen1.buscarPorTitulo(titulo);
			System.out.println("Película encontrada");
			System.out.println();
			System.out.print("Ingrese nueva descripción de la película: ");
			String descripcion = lector.readLine();
			almacen1.editarPeli(titulo, descripcion);
			datosPelicula(peli);
		}
		catch(NameInvalidException e){
			System.out.println("No se encontró una película con ese título");
		}
	}
	
	//-----------------------------------------------------------------|
	//-----------------Opciones del menu gestion usuario---------------|
	//-----------------------------------------------------------------|

	//-----------------------1. Agregar un préstamo--------------------|
	public void addPrestamo() throws IOException {
		
		System.out.print("Ingrese el rut del usuario: ");
		String rut = lector.readLine();
		try {
		Usuario user = clientes1.buscarUsuario(rut);
		  //Usuario existente
			System.out.println("Se encontró el usuario: " + user.getNombre());
			if(user.getSuscripcion() == Usuario.notVIP && user.getPeliculaPrestada().size() < 3 || 
			  (user.getSuscripcion() == Usuario.isVIP && user.getPeliculaPrestada().size() < 5)) {
				String opcion;
				System.out.println("¿Deseas ver la lista de las películas? (s/n): ");
				opcion = lector.readLine();
				if(opcion.equalsIgnoreCase("s")) {
					listarPeli();
					System.out.println();
				}
				System.out.println("Ingrese el título de la película a prestar: ");
				while(true) {
					try {
						String titulo = lector.readLine();
						Pelicula peli = almacen1.buscarPorTitulo(titulo);
						if(peli != null) {
							if(peli.getStock() != 0) {
								int precioFinal;
								peli.prestar();
								clientes1.agregarPrestamo(rut, peli);
								if(user.getSuscripcion() == Usuario.isVIP) {
									precioFinal = (int) (peli.getPrecio() * 0.7);
								}
								else {
									precioFinal = peli.getPrecio();
								}
								ventas1.hacerVenta(precioFinal);
							}
							else
								System.out.println("Se acabó el stock de la pelicula " + peli.getTitulo());
							break;
						}
					}	
					catch(NameInvalidException e) {
						System.out.print("No encontró esa película, ingrese nuevamente: ");
					}
				}
			}	
			else System.out.println("Usuario no puede arrendar más películas por el momento");
		}
		catch(InvalidUserException e)            //Usuario no existente
		{
			System.out.println("Registrando un nuevo usuario");
			System.out.print("Ingrese el nombre del usuario: ");
			String nombre = lector.readLine();
			System.out.print("Ingrese el tipo de suscripción del usuario (1 = VIP, 0 = Básica): ");
			byte suscripcion = Byte.parseByte(lector.readLine());
			
			Usuario newUser = new Usuario(nombre, rut, suscripcion);
			String opcion;
			System.out.print("¿Deseas ver la lista de las películas? (s/n): ");
			opcion = lector.readLine();
			if(opcion.equalsIgnoreCase("s")) {
				System.out.println();
				listarPeli();
				System.out.println();
			}
	
			System.out.println("Ingrese el título de la película a prestar: ");
			while(true) {
				try {
				String titulo = lector.readLine();
				Pelicula peli = almacen1.buscarPorTitulo(titulo);
				if(peli.getStock() != 0) {
					int precioFinal;
					peli.prestar();
					clientes1.agregarPrestamo(newUser, peli);
					if(newUser.getSuscripcion() == Usuario.isVIP) {
						precioFinal = (int) (peli.getPrecio() * 0.7);
					}
					else {
						precioFinal = peli.getPrecio();
					}
					ventas1.hacerVenta(precioFinal);
				}
				else
					System.out.println("Se acabó el stock de la pelicula " + peli.getTitulo());
				break;
				
				}
				catch(NameInvalidException ex) {
					System.out.println("No se encontró esa película, ingrese nuevamente: ");
				}
			}
		}	
	}
	
	//-----------------------2. Eliminar un préstamo-------------------|
	public void deletePrestamo() throws IOException, EmptyValueException {
		System.out.print("Ingrese el rut del usuario: ");
		String rut = lector.readLine();
		try {
			Usuario user = clientes1.buscarUsuario(rut);
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
				try {
					Pelicula peli = almacen1.buscarPorTitulo(peliUser.getTitulo());
					peli.devolver();
				}
				catch(NameInvalidException e) {
					peliUser.setStock(1);
					almacen1.agregarPelícula(peliUser);
				}
				clientes1.eliminarPrestamo(user, peliUser.getTitulo());
				System.out.println();
				System.out.println("Película devuelta con éxito");
				System.out.println();
			}
			else System.out.println("El usuario no tiene películas prestadas");
		}
		catch(InvalidUserException e) {
			System.out.println("No existe usuario con ese rut");
		}
	}
	
	//-----------------------3. Buscar un usuario----------------------|
	public void searchUser() throws IOException {
		System.out.print("Ingrese el rut del usuario: ");
		String rut = lector.readLine();
		System.out.println();
		try {
			Usuario user = clientes1.buscarUsuario(rut);
			System.out.println("Usuario encontrado:");
			System.out.println();
			user.datos();
		}
		catch(InvalidUserException e) {
			System.out.println("No existe usuario con ese rut");
		}
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
				i++;
			}
		}
		else {
			System.out.println("No hay usuarios registrados para mostrar");
			System.out.println();
		}
	}
	
	//-----------------------------------------------------------------|
	//-----------------Opciones del menu gestion ventas----------------|
	//-----------------------------------------------------------------|

		//-----------------------1. Mostrar ventas--------------------|
	public void mostrarVentas() {
		System.out.println();
		System.out.println("Ventas: $" + ventas1.getVentas());
		System.out.println();
	}
	
	//-----------------------2. Cerrar ventas--------------------|
	public void cerrarVentas() {
		System.out.println();
		System.out.println("Total ventas: $" + ventas1.cerrarVentas());
		System.out.println();
	}
	
	public void actualizarFile() throws IOException{
		File archivo = new File("src/recursos/infoPeliculas.csv");
		try(BufferedWriter reader = new BufferedWriter(new FileWriter(archivo))){
			reader.append("código,título,director,género,año,stock");
			reader.newLine();
			for(int i = 0; i < almacen1.getSizePeliculas(); i++) {
				Pelicula peli = almacen1.getPelicula(i);
				reader.append(peli.getCodigo() + "," + peli.getTitulo() + "," + peli.getDirector() + ","
						+ peli.getGenero() + "," + peli.getAño() + "," + peli.getStock());
				reader.newLine();
			}
			reader.close();
		}
	}
}
