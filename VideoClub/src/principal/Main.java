package principal;

import java.io.*;
public class Main {
	public static void main(String arr[]) throws IOException {
		Menu menu = new Menu();
		menu.menuPrincipal();
		
		menu.actualizarFile();
	}
}
