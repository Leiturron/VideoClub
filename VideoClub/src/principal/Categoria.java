package principal;

import java.util.ArrayList;
public class Categoria {
	protected ArrayList<Pelicula> lista;
	
	protected Categoria() {
		lista = new ArrayList<Pelicula>();
	}
	
	public void agregar(Pelicula peli) {
		this.lista.add(peli);
	}
	
	public boolean eliminarPorTitulo(String title) {
		for(int i = 0; i < this.lista.size(); i++) {
			Pelicula peli = this.lista.get(i);
			
			if(peli.getTitulo().equalsIgnoreCase(title)) {
				this.lista.remove(i);
				return true;
			}
		}
		return false;
	}
	
	public boolean eliminarPorCodigo(int code) {
		for(int i = 0; i < this.lista.size(); i++) {
			Pelicula peli = this.lista.get(i);
			
			if(peli.getCodigo() == code) {
				this.lista.remove(i);
				return true;
			}
		}
		return false;
	}
	
	public void listarPeliculas() {
		for(int i = 0; i < this.lista.size(); i++) {
			Pelicula peli = this.lista.get(i);
			System.out.println();
			Menu.datosPelicula(peli);
		}
	}
}
