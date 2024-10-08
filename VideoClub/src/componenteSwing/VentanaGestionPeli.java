package componenteSwing;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.WindowConstants;

public class VentanaGestionPeli extends VentanaPreset{
	private JFrame peliFrame;
	private JButton bAgregar;
	private JButton bEliminar;
	private JButton bBuscar;
	private JButton bLista;
	private JButton bVolver;
	
	public VentanaGestionPeli() {
		peliFrame = new JFrame("Gestion de Películas");
		
		VentanaPreset.setVentanaPropiedad(peliFrame);
		setComponentes();
		setLogic();
	}
	
	public void show() {
		peliFrame.setVisible(true);
	}
	
	public void setLogic() {
		peliFrame.addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e) {
				
				VentanaPrincipal ventanaPrincipal = new VentanaPrincipal();
				ventanaPrincipal.show();
			}
		});
		
		bAgregar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				peliFrame.dispose();
				WinAgregarPeli win = new WinAgregarPeli();
				win.show();
			}
		});
		
		bEliminar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				peliFrame.dispose();
				WinEliminarPeli win = new WinEliminarPeli();
				win.show();
			}
		});
		
		bBuscar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				peliFrame.dispose();
				WinBuscarPeli win = new WinBuscarPeli();
				win.show();
				
			}
		});
		
		bVolver.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				peliFrame.dispose();
				VentanaPrincipal ventanaPrincipal = new VentanaPrincipal();
				ventanaPrincipal.show();
			}
		});
	}
	
	public void setComponentes() {
		bAgregar = new JButton("Agregar Película");
		bEliminar = new JButton("Eliminar Película");
		bBuscar = new JButton("Buscar Película");
		bLista = new JButton("Lista de Películas");
		bVolver = new JButton("Volver");
		
		bAgregar.setSize(200, 30);
		bAgregar.setLocation(peliFrame.getWidth() / 2 - bAgregar.getWidth() / 2, 100);
		
		bEliminar.setSize(200, 30);
		bEliminar.setLocation(peliFrame.getWidth() / 2 - bEliminar.getWidth() / 2, 150);
		
		bBuscar.setSize(200, 30);
		bBuscar.setLocation(peliFrame.getWidth() / 2 - bBuscar.getWidth() / 2, 200);
		
		bLista.setSize(200, 30);
		bLista.setLocation(peliFrame.getWidth() / 2 - bLista.getWidth() / 2, 250);
		
		bVolver.setSize(100, 30);
		bVolver.setLocation(peliFrame.getWidth() / 2 - bVolver.getWidth() / 2, 300);
		
		
		peliFrame.add(bAgregar);
		peliFrame.add(bEliminar);
		peliFrame.add(bBuscar);
		peliFrame.add(bLista);
		peliFrame.add(bVolver);
	}
}
