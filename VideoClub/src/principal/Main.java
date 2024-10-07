package principal;

import java.io.*;
import componenteSwing.VentanaPrincipal;

public class Main {
	public static void main(String arr[]) throws IOException {
		/*
		Menu menu = new Menu();
		menu.menuPrincipal();
		
		menu.actualizarFile();
		*/
		VentanaPrincipal ventanaP = new VentanaPrincipal();
		ventanaP.show();
	}
}
