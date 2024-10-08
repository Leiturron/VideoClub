package componenteSwing;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.WindowConstants;

public class VentanaGestionUser extends VentanaPreset{
	private JFrame userFrame;
	private JButton bAgregar;
	private JButton bEliminar;
	private JButton bBuscar;
	private JButton bLista;
	private JButton bVolver;
	
	public VentanaGestionUser() {
		userFrame = new JFrame("Gestion de Usuarios");
				
		VentanaPreset.setVentanaPropiedad(userFrame);
		setComponentes();
		setLogic();
	}
	
	public void show() {
		userFrame.setVisible(true);
	}
	
	public void setLogic() {
		userFrame.addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e) {
				VentanaPrincipal ventanaPrincipal = new VentanaPrincipal();
				ventanaPrincipal.show();
			}
		});
		
		bVolver.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				userFrame.dispose();
				VentanaPrincipal ventanaPrincipal = new VentanaPrincipal();
				ventanaPrincipal.show();
			}
		});
	}
	
	public void setComponentes() {
		bAgregar = new JButton("Agregar Usuario");
		bEliminar = new JButton("Eliminar Usuario");
		bBuscar = new JButton("Buscar Usuario");
		bLista = new JButton("Lista de Usuarios");
		bVolver = new JButton("Volver");
		
		bAgregar.setSize(200, 30);
		bAgregar.setLocation(userFrame.getWidth() / 2 - bAgregar.getWidth() / 2, 100);
		
		bEliminar.setSize(200, 30);
		bEliminar.setLocation(userFrame.getWidth() / 2 - bEliminar.getWidth() / 2, 150);
		
		bBuscar.setSize(200, 30);
		bBuscar.setLocation(userFrame.getWidth() / 2 - bBuscar.getWidth() / 2, 200);
		
		bLista.setSize(200, 30);
		bLista.setLocation(userFrame.getWidth() / 2 - bLista.getWidth() / 2, 250);
		
		bVolver.setSize(100, 30);
		bVolver.setLocation(userFrame.getWidth() / 2 - bVolver.getWidth() / 2, 300);
		
		
		userFrame.add(bAgregar);
		userFrame.add(bEliminar);
		userFrame.add(bBuscar);
		userFrame.add(bLista);
		userFrame.add(bVolver);
	}
}
