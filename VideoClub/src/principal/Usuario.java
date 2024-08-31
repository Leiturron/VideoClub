package principal;
import java.util.ArrayList;

public class Usuario {
	private String nombre;
	private String rut;
	private ArrayList<String> peliculaPrestada;
	
	public Usuario(String nombre, String rut) {
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

	public String getRut() {
		return rut;
	}

	public void setRut(String rut) {
		this.rut = rut;
	}

	public ArrayList<String> getPeliculaPrestada() {
		return peliculaPrestada;
	}
	
	public void datos() {
		System.out.println("Nombre: " + nombre);
		System.out.println("Rut: " + rut);
		System.out.println();
		System.out.println("Películas prestadas");
		for(int i = 0; i < peliculaPrestada.size(); i++) {
			System.out.println(peliculaPrestada.get(i));
		}
	}
	
}
