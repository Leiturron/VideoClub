package componenteSwing;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.*;

import principal.*;

public class WinAgregarPeli extends VentanaPreset {
	private JFrame frame;
	private JTextField titleField;
	private JTextField directField;
	private JTextField generField;
	private JTextField yearField;
	private JTextField stockField;
	private JLabel pista;
	private JLabel titleLabel;
	private JLabel directLabel;
	private JLabel generLabel;
	private JLabel yearLabel;
	private JLabel stockLabel;
	private JButton cancel;
	private JButton confirm;

	public WinAgregarPeli() {
		frame = new JFrame("Agregar Película");
		
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
		
		cancel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.dispose();
				VentanaGestionPeli ventanaGestionPeli = new VentanaGestionPeli();
				ventanaGestionPeli.show();
			}
		});
		
		confirm.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try{
					int codigo = VentanaPrincipal.almacen1.getOrden();
					String titulo = titleField.getText();
					System.out.println(titleField.getText());
					String director = directField.getText();
					String genero = generField.getText();
					int anno = Integer.parseInt(yearField.getText());
					int stock = Integer.parseInt(stockField.getText());
					Pelicula peli = new Pelicula(codigo, titulo, director, genero, anno, stock);
					VentanaPrincipal.almacen1.agregarPelícula(peli);
					JOptionPane.showMessageDialog(frame, "Se agregó exitosamente");
				}
				catch(EmptyValueException e2) {
					JOptionPane.showMessageDialog(frame, "Algunos campos se encuentran vacíos");
				}
				catch(Exception e3) {
					JOptionPane.showMessageDialog(frame, "Error de ingresar el año o stock");
				}
			}
		});
	}

	public void setComponentes() {
		pista = new JLabel("Ingrese los datos de la película al agregar");
		pista.setSize(250, 20);
		pista.setLocation(frame.getWidth() / 2 - pista.getWidth() / 2, 20);
		
		titleLabel = new JLabel("Título de la película");
		titleLabel.setBounds(50, 60, 200, 20);
		
		directLabel = new JLabel("Director de la película");
		directLabel.setBounds(36, 100, 200, 20);
		
		generLabel = new JLabel("Género de la película");
		generLabel.setBounds(40, 140, 200, 20);
		
		yearLabel = new JLabel("Año de la película");
		yearLabel.setBounds(60, 180, 200, 20);
		
		stockLabel = new JLabel("Cantidad disponible");
		stockLabel.setBounds(47, 220, 200, 20);
		
		confirm = new JButton("Confirmar");
		confirm.setSize(150, 30);
		confirm.setLocation(frame.getWidth() / 2 - confirm.getWidth() / 2, 270);
		
		cancel = new JButton("Cancelar");
		cancel.setSize(100, 30);
		cancel.setLocation(frame.getWidth() / 2 - cancel.getWidth() / 2, 310);
		
		titleField = new JTextField();
		titleField.setBounds(170, 62, 150, 20);
		
		directField = new JTextField();
		directField.setBounds(170, 102, 150, 20);
		
		generField = new JTextField();
		generField.setBounds(170, 142, 150, 20);
		
		yearField = new JTextField();
		yearField.setBounds(170, 182, 150, 20);
		
		stockField = new JTextField();
		stockField.setBounds(170, 222, 150, 20);
		
		frame.add(pista);
		frame.add(titleLabel);
		frame.add(directLabel);
		frame.add(generLabel);
		frame.add(yearLabel);
		frame.add(stockLabel);
		
		frame.add(confirm);
		frame.add(cancel);
		
		frame.add(titleField);
		frame.add(directField);
		frame.add(generField);
		frame.add(yearField);
		frame.add(stockField);
	}

}
