package componenteSwing;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.*;
public class WinEliminarPeli extends VentanaPreset{
	private JFrame frame;
	private JButton elimCode;
	private JButton elimTitle;
	private JButton bVolver;

	public WinEliminarPeli() {
		frame = new JFrame("Eliminar película");
		
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
		
		bVolver.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.dispose();
				VentanaGestionPeli ventanaGestionPeli = new VentanaGestionPeli();
				ventanaGestionPeli.show();
			}
		});
	}

	public void setComponentes() {
		elimCode = new JButton("Eliminar por código");
		elimTitle = new JButton("Eliminar por título");		
		bVolver = new JButton("Volver");
		
		elimCode.setSize(200, 30);
		elimCode.setLocation(frame.getWidth() / 2 - elimCode.getWidth() / 2, 100);
		
		elimTitle.setSize(200, 30);
		elimTitle.setLocation(frame.getWidth() / 2 - elimTitle.getWidth() / 2, 150);
		
		bVolver.setSize(100, 30);
		bVolver.setLocation(frame.getWidth() / 2 - bVolver.getWidth() / 2, 300);
		
		frame.add(elimCode);
		frame.add(elimTitle);
		frame.add(bVolver);
	}
	
}
