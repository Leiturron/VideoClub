package principal;

public class Pelicula {
	private int codigo;
	private String titulo;
	private String director;
	private String genero;
	private int año;
	private int stock;
	private String descripcion;
	
	public Pelicula(int codigo, String titulo, String director, String genero, int año, int stock) {
		this.codigo = codigo;
		this.titulo = titulo;
		this.director = director;
		this.genero = genero;
		this.año = año;
		this.stock = stock;
	}
		
	public int getCodigo() {
		return codigo;
	}

	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}

	public String getTitulo() {
		return titulo;
	}
	public void setNombre(String titulo) {
		this.titulo = titulo;
	}
	public String getDirector() {
		return director;
	}
	public void setDirector(String director) {
		this.director = director;
	}
	public String getGenero() {
		return genero;
	}
	public void setGenero(String genero) {
		this.genero = genero;
	}
	public int getAño() {
		return año;
	}
	public void setAño(int año) {
		this.año = año;
	}
	public int getStock() {
		return stock;
	}
	public void setStock(int stock ) {
		this.stock = stock;
	}
	public String getDescripcion() {
		return descripcion;
	}
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public int getDecada(int año) {
		return año - (año % 10);
	}
	
	public void prestar() {
		stock--;
	}
	
	public void devolver() {
		stock++;
	}

}
