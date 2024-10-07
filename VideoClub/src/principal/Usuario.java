package principal;
import java.util.ArrayList;

public class Usuario {
	private String nombre;
	private String rut;
	private byte suscripcion;
	public static final byte isVIP = 1;
	public static final byte notVIP = 0;
	
	private ArrayList<Pelicula> peliculaPrestada;
	
	public Usuario(String nombre, String rut, byte suscripcion) {
		this.nombre = nombre;
		this.rut = rut;
		this.suscripcion = suscripcion;
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
	
	public byte getSuscripcion() {
		return suscripcion;
	}
	
	public void setSuscripcion(byte suscripcion) {
		this.suscripcion = suscripcion;
	}

	public ArrayList<Pelicula> getPeliculaPrestada() {
		return peliculaPrestada;
	}
	
	public void datos() {
		System.out.println("Nombre: " + nombre);
		System.out.println("Rut: " + rut);
		if(suscripcion == notVIP) {
			System.out.println("Suscripción: Básica");
		}
		else {
			System.out.println("Suscripción: VIP");
		}
		System.out.println();
		System.out.println("Películas prestadas");
		if(peliculaPrestada.size() != 0)
			for(int i = 0; i < peliculaPrestada.size(); i++) {
				System.out.println((i + 1 ) + ". " + peliculaPrestada.get(i).getTitulo());
			}
		else System.out.println("No se le ha prestado ninguna película");
		System.out.println();
	}
}
