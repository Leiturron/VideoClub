package principal;

public class Pelicula {
	private String titulo;
	private String directores;
	private String genero;
	private int año;
	private int stock;
	
	public Pelicula(String titulo, String directores, String genero, int año, int stock) {
		this.titulo = titulo;
		this.directores = directores;
		this.genero = genero;
		this.año = año;
		this.stock = stock;
	}
		
		public String getTitulo() {
			return titulo;
		}
		public void setNombre(String titulo) {
			this.titulo = titulo;
		}
		public String getDirectores() {
			return directores;
		}
		public void setDirectores(String directores) {
			this.directores = directores;
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
}
