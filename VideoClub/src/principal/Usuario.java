package principal;
import java.util.ArrayList;

public class Usuario {
	private String nombre;
	private int rut;
	private ArrayList<String> peliculaPrestada;
	
	public Usuario(String nombre, int rut) {
		this.nombre = nombre;
		this.rut = rut;
		peliculaPrestada = new ArrayList<String>();
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public int getRut() {
		return rut;
	}

	public void setRut(int rut) {
		this.rut = rut;
	}

	public ArrayList<String> getPeliculaPrestada() {
		return peliculaPrestada;
	}
}
