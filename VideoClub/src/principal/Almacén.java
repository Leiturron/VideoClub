package principal;

import java.util.ArrayList;
import java.util.HashMap;

public class Almacén {
	private ArrayList<Pelicula> películas;
	private HashMap<String, Pelicula> mapaGéneros;
	private HashMap<String, Pelicula> mapaDirectores;
	private HashMap<String, Pelicula> mapaDécadas;
	
	public Almacén(){
		películas = new ArrayList<Pelicula>();
		mapaGéneros = new HashMap<String, Pelicula>();
		mapaDirectores = new HashMap<String, Pelicula>();
		mapaDécadas = new HashMap<String, Pelicula>();
	}

	public ArrayList<Pelicula> getPelículas() {
		return películas;
	}

	public HashMap<String, Pelicula> getMapaGéneros() {
		return mapaGéneros;
	}

	public HashMap<String, Pelicula> getMapaDirectores() {
		return mapaDirectores;
	}

	public HashMap<String, Pelicula> getMapaDécadas() {
		return mapaDécadas;
	}
}
