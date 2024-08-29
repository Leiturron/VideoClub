package principal;

import java.util.ArrayList;
import java.util.HashMap;

public class Almacén {
	private ArrayList<Pelicula> películas;
	private HashMap<String, ArrayList<Pelicula>> mapaGéneros;
	private HashMap<String, ArrayList<Pelicula>> mapaDirectores;
	private HashMap<Integer, ArrayList<Pelicula>> mapaDécadas;
	
	public Almacén(){
		películas = new ArrayList<Pelicula>();
		mapaGéneros = new HashMap<String, ArrayList<Pelicula>>();
		mapaDirectores = new HashMap<String, ArrayList<Pelicula>>();
		mapaDécadas = new HashMap<Integer , ArrayList<Pelicula>>();
	}

	public ArrayList<Pelicula> getPelículas() {
		return películas;
	}

	public HashMap<String, ArrayList<Pelicula>> getMapaGéneros() {
		return mapaGéneros;
	}

	public HashMap<String, ArrayList<Pelicula>> getMapaDirectores() {
		return mapaDirectores;
	}

	public HashMap<Integer, ArrayList<Pelicula>> getMapaDécadas() {
		return mapaDécadas;
	}
	
	public void agregarPelícula(Pelicula película) {
		películas.add(película);
		if(mapaGéneros.get(película.getGenero()) == null) {
			ArrayList<Pelicula> pelisGénero = new ArrayList<Pelicula>();
			mapaGéneros.put(película.getGenero(), pelisGénero);
		}
		mapaGéneros.get(película.getGenero()).add(película);
		if(mapaDirectores.get(película.getDirector()) == null) {
			ArrayList<Pelicula> pelisDirector = new ArrayList<Pelicula>();
			mapaGéneros.put(película.getDirector(), pelisDirector);
		}
		mapaGéneros.get(película.getDirector()).add(película);
		if(mapaDécadas.get(película.getDecada(película.getAño())) == null) {
			ArrayList<Pelicula> pelisDécada = new ArrayList<Pelicula>();
			mapaDécadas.put(película.getDecada(película.getAño()), pelisDécada);
		}
		mapaDécadas.get(película.getDecada(película.getAño())).add(película);
	}
	
	public void eliminarPelícula(Pelicula película) {
		for(short i = 0; i < películas.size(); i++) {
			if(películas.get(i).getTitulo() == película.getTitulo()) {
				películas.remove(i);
			}
			
		}
	}
	
}
