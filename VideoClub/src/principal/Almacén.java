package principal;

import java.io.*;
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
	
	public void Datos() throws IOException {
		File archivo = new File("src/recursos/infoPeliculas.csv");
		try(BufferedReader reader = new BufferedReader(new FileReader(archivo))){
			String linea = reader.readLine();
			while((linea = reader.readLine()) != null) {
				String[] datos = linea.split(",");
				int codigo = Integer.parseInt(datos[0]);
				String titulo = datos[1];
				String director = datos[2];
				String genero = datos[3];
				int año = Integer.parseInt(datos[4]);
				int stock = Integer.parseInt(datos[5]);
				Pelicula peli = new Pelicula(codigo, titulo, director, genero, año, stock);
				agregarPelícula(peli);
			}
		}
	}
	
	public void agregarPelícula(Pelicula película) {
		películas.add(película);
		
		if(mapaGéneros.get(película.getGenero().toUpperCase()) == null) {
			ArrayList<Pelicula> pelisGénero = new ArrayList<Pelicula>();
			mapaGéneros.put(película.getGenero().toUpperCase(), pelisGénero);
		}
		mapaGéneros.get(película.getGenero().toUpperCase()).add(película);
		
		if(mapaDirectores.get(película.getDirector().toUpperCase()) == null) {
			ArrayList<Pelicula> pelisDirector = new ArrayList<Pelicula>();
			mapaDirectores.put(película.getDirector().toUpperCase(), pelisDirector);
		}
		mapaDirectores.get(película.getDirector().toUpperCase()).add(película);
		
		if(mapaDécadas.get(película.getDecada(película.getAño())) == null) {
			ArrayList<Pelicula> pelisDécada = new ArrayList<Pelicula>();
			mapaDécadas.put(película.getDecada(película.getAño()), pelisDécada);
		}
		mapaDécadas.get(película.getDecada(película.getAño())).add(película);
	}
	
	public void eliminarPelícula(String titulo) {
		Pelicula película = null;
		for(short i = 0; i < películas.size(); i++) {
			if(películas.get(i).getTitulo().equalsIgnoreCase(titulo)) {
				película = películas.remove(i);
				for(short j = 0; j < mapaGéneros.get(película.getGenero()).size(); j++) {
					if(mapaGéneros.get(película.getGenero()).get(j).getTitulo().equalsIgnoreCase(titulo)) {
						mapaGéneros.get(película.getGenero()).remove(j);
					}
				}
				for(short j = 0; j < mapaDirectores.get(película.getDirector()).size(); j++) {
					if(mapaDirectores.get(película.getDirector()).get(j).getTitulo().equalsIgnoreCase(titulo)) {
						mapaDirectores.get(película.getDirector()).remove(j);
					}
				}
				for(short j = 0; j < mapaDécadas.get(película.getDecada(película.getAño())).size(); j++) {
					if(mapaDécadas.get(película.getDecada(película.getAño())).get(j).getTitulo().equalsIgnoreCase(titulo)) {
						mapaDécadas.get(película.getDecada(película.getAño())).remove(j);
					}
				}
				return;
			}
		}
		System.out.println("Película " + titulo + " no encontrada");
		System.out.println();
	}
	
	public void eliminarPelícula(int código) {
		Pelicula película = null;
		for(short i = 0; i < películas.size(); i++) {
			if(películas.get(i).getCodigo() == código) {
				película = películas.remove(i);
				for(short j = 0; j < mapaGéneros.get(película.getGenero()).size(); j++) {
					if(mapaGéneros.get(película.getGenero()).get(j).getCodigo() == código) {
						mapaGéneros.get(película.getGenero()).remove(j);
					}
				}
				for(short j = 0; j < mapaDirectores.get(película.getDirector()).size(); j++) {
					if(mapaDirectores.get(película.getDirector()).get(j).getCodigo() == código) {
						mapaDirectores.get(película.getDirector()).remove(j);
					}
				}
				for(short j = 0; j < mapaDécadas.get(película.getDecada(película.getAño())).size(); j++) {
					if(mapaDécadas.get(película.getDecada(película.getAño())).get(j).getCodigo() == código) {
						mapaDécadas.get(película.getDecada(película.getAño())).remove(j);
					}
				}
				return;
			}
		}
		System.out.println("Película con código " + código + " no encontrada");
		System.out.println();
	}
	
	public Pelicula buscarPorCodigo(int codigo) {
		for(short i = 0; i < películas.size(); i++)
			if(películas.get(i).getCodigo() == codigo) return películas.get(i);
		return null;
	}
	
	public Pelicula buscarPorTitulo(String titulo) {
		for(short i = 0; i < películas.size(); i++) 
			if(películas.get(i).getTitulo().equalsIgnoreCase(titulo)) return películas.get(i);
		return null;
	}
	
	public ArrayList<Pelicula> buscarPorDirector(String director) {
		return mapaDirectores.get(director);
	}
	
	public ArrayList<Pelicula> buscarPorGénero(String género) {
		return mapaGéneros.get(género);
	}
	
	public ArrayList<Pelicula> buscarPorDécada(int década) {
		return mapaDécadas.get(década);
	}
}