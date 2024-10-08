package componenteSwing;

import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

public abstract class VentanaPreset {
	
	public static void setVentanaPropiedad(JFrame frame) {
		frame.setResizable(false);
		frame.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
		Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
		frame.setSize(400, 500);
		int dimX = (int) (dim.getWidth() / 2  - frame.getWidth() / 2);
		int dimY = (int) (dim.getHeight() / 2 - frame.getHeight() / 2);
		frame.setLocation(dimX, dimY);
		setBar(frame);
		frame.setLayout(null);
	}
	
	public abstract void setLogic();
	
	public abstract void setComponentes();
	
	private static void setBar(JFrame frame) {
		JMenuBar bar = new JMenuBar();
		JMenu menu = new JMenu("Menu");
		JMenuItem item = new JMenuItem("Salir del programa");
		
		item.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int opcion = JOptionPane.showConfirmDialog(frame, "Estas seguros de quieres salir del programa? (Todo los "
						+ "cambios serán guardado)", "Advertencia", JOptionPane.YES_NO_OPTION);
				if(opcion == JOptionPane.YES_OPTION)
					System.exit(0);
			}
		});
		
		menu.add(item);
		bar.add(menu);
		frame.setJMenuBar(bar);
	}
}
