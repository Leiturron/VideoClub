package principal;

public class PeliculaPrestada extends Pelicula {
	public PeliculaPrestada(int codigo, String titulo, String director, String genero, int año, String fechaP, String fechaD){
		super(codigo, titulo, director, genero, año, 1);
	}
}
