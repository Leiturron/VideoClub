package principal;
import java.util.ArrayList;

public class Usuario {
	private String nombre;
	private String rut;
	private ArrayList<Pelicula> peliculaPrestada;
	
	public Usuario(String nombre, String rut) {
		this.nombre = nombre;
		this.rut = rut;
		peliculaPrestada = new ArrayList<Pelicula>();
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

	public ArrayList<Pelicula> getPeliculaPrestada() {
		return peliculaPrestada;
	}
	
	public void datos() {
		System.out.println("Nombre: " + nombre);
		System.out.println("Rut: " + rut);
		System.out.println();
		System.out.println("Películas prestadas");
		if(peliculaPrestada.size() != 0)
			for(int i = 0; i < peliculaPrestada.size(); i++) {
				System.out.println((i + 1 ) + ". " + peliculaPrestada.get(i).getTitulo());
			}
		else System.out.println("No ha prestado ninguna película");
		System.out.println();
	}
	
}
