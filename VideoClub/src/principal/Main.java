package principal;

import java.io.*;
public class Main {
	public static void main(String arr[]) throws IOException {
		//objeto lector
		BufferedReader lector = new BufferedReader(new InputStreamReader(System.in));
		Almacén almacen1 = new Almacén();
		almacen1.Datos();
		
		//Menu principal
		int opcion;
		while(true) {
			System.out.println("     Sistema de gestión");
			System.out.println("1. Gestión de las películas");
			System.out.println("2. Gestión de los usuarios");
			System.out.println("3. Salir del sistema");
			opcion = Integer.parseInt(lector.readLine());
			switch(opcion) {
				case 1: //Menu de gestionar películas
					while(true) {
						System.out.println("Gestión de películas");
						System.out.println("1. Agregar película");
						System.out.println("2. Eliminar película");
						System.out.println("3. Buscar película");
						System.out.println("4. Listar Películas");
						System.out.println("5. Volver");
						int opcionP = Integer.parseInt(lector.readLine());
						if(opcionP == 5) break;
						switch(opcionP){
							case 1:
							case 2:
							case 3:
							case 4:
							default:
						}
					}
					break;
				case 2: //Menu de gestionar usuarios
					while(true) {
						System.out.println("Gestion de usuarios");
						System.out.println("1. Agregar un préstamo");
						System.out.println("2. Eliminar un préstamo");
						System.out.println("3. Buscar usuario");
						System.out.println("4. Listar usuarios");
						System.out.println("5. Volver");
						int opcionU = Integer.parseInt(lector.readLine());
						if(opcionU == 5) break;
						switch(opcionU) {
							case 1:
							case 2:
							case 3:
							case 4:
							default:
						}
					}
					
					
					break;
				case 3:
					System.out.println("Saliendo del sistema");
					return;
				default:
					System.out.println("Opción invalido");
					break;
			}
			System.out.println();
			System.out.println("Presiona ENTER para continuar");
			lector.readLine();
		}
		
	}
}
