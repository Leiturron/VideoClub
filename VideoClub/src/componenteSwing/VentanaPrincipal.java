package componenteSwing;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.WindowConstants;

public class VentanaPrincipal extends VentanaPreset{
	private JFrame mainFrame;
	private JButton bPeli;
	private JButton bUser;
	private JButton bVenta;

	public VentanaPrincipal() {
		mainFrame = new JFrame("Administrador de Video Club");
		
		VentanaPreset.setVentanaDimension(mainFrame);
		setComponentes();
		setLogic();
	}
	
	public void show() {
		mainFrame.setVisible(true);
	}
	
	public void setLogic() {
		mainFrame.addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e) {
				mainFrame.setDefaultCloseOperation(WindowConstants.DO_NOTHING_ON_CLOSE);
				int opcion = JOptionPane.showConfirmDialog(mainFrame, "Estas seguros de quieres salir del programa? (Todos los "
						+ "cambios serán guardado)", "Advertencia", JOptionPane.YES_NO_OPTION);
				if(opcion == JOptionPane.YES_OPTION)
					System.exit(0);
			}
		});
		
		bPeli.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				VentanaGestionPeli ventanaGestionPeli = new VentanaGestionPeli();
				ventanaGestionPeli.show();
				mainFrame.dispose();
			}
		});
		
		bUser.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				VentanaGestionUser ventanaGestionUser = new VentanaGestionUser();
				ventanaGestionUser.show();
				mainFrame.dispose();
			}
		});
		
		bVenta.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				VentanaGestionVenta ventanaGestionUser = new VentanaGestionVenta();
				ventanaGestionUser.show();
				mainFrame.dispose();
			}
		});
	}
	
	public void setComponentes() {
		bPeli = new JButton("Gestión de Películas");
		bUser = new JButton("Gestión de Usuarios");
		bVenta = new JButton("Gestión de Ventas");
		
		bPeli.setSize(200, 30);
		bPeli.setLocation(mainFrame.getWidth() / 2 - bPeli.getWidth() / 2, 100);
		
		bUser.setSize(200, 30);
		bUser.setLocation(mainFrame.getWidth() / 2 - bPeli.getWidth() / 2, 200);
		
		bVenta.setSize(200, 30);
		bVenta.setLocation(mainFrame.getWidth() / 2 - bPeli.getWidth() / 2, 300);
		
		mainFrame.add(bPeli);
		mainFrame.add(bUser);
		mainFrame.add(bVenta);
	}
}
