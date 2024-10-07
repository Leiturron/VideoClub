package componenteSwing;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.WindowConstants;

public class VentanaGestionVenta extends VentanaPreset{
	private JFrame ventaFrame;
	private JButton bMostrar;
	private JButton bCerrar;
	private JButton bVolver;
	
	public VentanaGestionVenta() {
		ventaFrame = new JFrame("Gestion de Ventas");
		
		VentanaPreset.setVentanaDimension(ventaFrame);
		setComponentes();
		setLogic();
	}
	
	public void show() {
		ventaFrame.setVisible(true);
	}
	
	public void setLogic() {
		ventaFrame.addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e) {
				ventaFrame.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
				VentanaPrincipal ventanaPrincipal = new VentanaPrincipal();
				ventanaPrincipal.show();
			}
		});
		
		bVolver.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ventaFrame.dispose();
				VentanaPrincipal ventanaPrincipal = new VentanaPrincipal();
				ventanaPrincipal.show();
			}
		});
	}
	
	public void setComponentes() {
		bMostrar = new JButton("Mostrar ventas");
		bCerrar = new JButton("Cerrar ventas");
		bVolver = new JButton("Volver");
		
		bMostrar.setSize(200, 30);
		bMostrar.setLocation(ventaFrame.getWidth() / 2 - bMostrar.getWidth() / 2, 150);
		
		bCerrar.setSize(200, 30);
		bCerrar.setLocation(ventaFrame.getWidth() / 2 - bCerrar.getWidth() / 2, 200);
		
		bVolver.setSize(100, 30);
		bVolver.setLocation(ventaFrame.getWidth() / 2 - bVolver.getWidth() / 2, 250);
		
		ventaFrame.add(bMostrar);
		ventaFrame.add(bCerrar);
		ventaFrame.add(bVolver);
	}
}
