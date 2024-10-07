package componenteSwing;

import java.awt.Dimension;
import java.awt.Toolkit;

import javax.swing.*;

public abstract class VentanaPreset {
	
	public static void show(JFrame frame) {
		frame.setVisible(true);
	}
	
	public static void setVentanaDimension(JFrame frame) {
		frame.setResizable(false);
		Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
		frame.setSize(400, 500);
		int dimX = (int) (dim.getWidth() / 2  - frame.getWidth() / 2);
		int dimY = (int) (dim.getHeight() / 2 - frame.getHeight() / 2);
		frame.setLocation(dimX, dimY);
		frame.setLayout(null);
	}
	
	public abstract void setLogic();
	
	public abstract void setComponentes();
}
