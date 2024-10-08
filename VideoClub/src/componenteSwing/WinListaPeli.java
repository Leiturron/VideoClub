package componenteSwing;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import principal.*;
public class WinListaPeli extends VentanaPreset {
	private JFrame frame;
	private List list;
	private ScrollPane pane;
	private JButton volver;
	
	public WinListaPeli() {
		frame = new JFrame("Lista de película");
		
		VentanaPreset.setVentanaPropiedad(frame);
		setComponentes();
		setLogic();
	}
	
	public void show() {
		frame.setVisible(true);
	}

	public void setLogic() {
		frame.addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e) {
				VentanaGestionPeli ventanaGestionPeli = new VentanaGestionPeli();
				ventanaGestionPeli.show();
			}
		});
		
		volver.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.dispose();
				VentanaGestionPeli ventanaGestionPeli = new VentanaGestionPeli();
				ventanaGestionPeli.show();
			}
		});
	}

	@Override
	public void setComponentes() {
		pane = new ScrollPane();
		volver = new JButton("Volver");
		volver.setSize(100,20);
		volver.setLocation(5, frame.getHeight() - 82);
		
		list = new List();
		for(int i = 0; i < VentanaPrincipal.almacen1.getSizePeliculas(); i++) {
			Pelicula peli = VentanaPrincipal.almacen1.getPelicula(i);
			String titulo = peli.getTitulo();
			list.add(titulo);
		}
		pane.setSize(frame.getWidth() - 10, frame.getHeight() - 80);
		
		pane.add(list);
		
		frame.add(volver);
		frame.add(pane);
	}

}
