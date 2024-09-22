package principal;

public class PeliculaPrestada extends Pelicula {
	private String fechaPrestamo;
	private String fechaDevolucion;
	
	public PeliculaPrestada(int codigo, String titulo, String director, String genero, int año, String fechaP, String fechaD){
		super(codigo, titulo, director, genero, año, 1);
		fechaPrestamo = fechaP;
		fechaDevolucion = fechaD;
	}

	public String getFechaPrestamo() {
		return fechaPrestamo;
	}

	public void setFechaPrestamo(String fechaPrestamo) {
		this.fechaPrestamo = fechaPrestamo;
	}

	public String getFechaDevolucion() {
		return fechaDevolucion;
	}

	public void setFechaDevolucion(String fechaDevolucion) {
		this.fechaDevolucion = fechaDevolucion;
	}
	
}
