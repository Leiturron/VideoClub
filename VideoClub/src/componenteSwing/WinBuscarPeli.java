package componenteSwing;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.*;

public class WinBuscarPeli extends VentanaPreset {	
	private JFrame frame;
	private JButton code;
	private JButton title;
	private JButton gener;
	private JButton direc;
	private JButton deca;
	private JButton volver;

	public WinBuscarPeli() {
		frame = new JFrame("Buscar película");
		
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

	public void setComponentes() {
		code = new JButton("Buscar por código");
		title = new JButton("Buscar por título");
		gener = new JButton("Buscar por genero");
		direc = new JButton("Buscar por director");
		deca = new JButton("Buscar por década");
		volver = new JButton("Volver");
		
		code.setSize(200, 30);
		code.setLocation(frame.getWidth() / 2 - code.getWidth() / 2, 50);
		
		title.setSize(200, 30);
		title.setLocation(frame.getWidth() / 2 - title.getWidth() / 2, 100);
		
		gener.setSize(200, 30);
		gener.setLocation(frame.getWidth() / 2 - gener.getWidth() / 2, 150);
		
		direc.setSize(200, 30);
		direc.setLocation(frame.getWidth() / 2 - direc.getWidth() / 2, 200);
		
		deca.setSize(200, 30);
		deca.setLocation(frame.getWidth() / 2 - deca.getWidth() / 2, 250);
		
		volver.setSize(100, 30);
		volver.setLocation(frame.getWidth() / 2 - volver.getWidth() / 2, 300);
		
		
		
		frame.add(code);
		frame.add(title);
		frame.add(gener);
		frame.add(direc);
		frame.add(deca);
		frame.add(volver);
	}

}
