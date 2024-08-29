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
				String codigo = datos[0];
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
			if(mapaGéneros.get(película.getGenero()).get(i).getTitulo() == película.getTitulo()) {
				mapaGéneros.get(película.getGenero()).remove(i);
			}
			if(mapaDirectores.get(película.getDirector()).get(i).getDirector() == película.getDirector()) {
				mapaDirectores.get(película.getDirector()).remove(i);
			}
			if(mapaDécadas.get(película.getDecada(película.getAño())).get(i).getAño() == película.getAño()) {
				mapaDécadas.get(película.getDecada(película.getAño())).remove(i);
			}
		}
	}
	
	public void buscarPelícula(String titulo) {
		for(short i = 0; i < películas.size(); i++) {
			if(i == películas.size() - 1 && películas.get(i).getTitulo() != titulo) {
				System.out.println("Película no encontrada");
				break;
			}
			else if(películas.get(i).getTitulo() == titulo) {
				System.out.println("Película encontrada:");
				System.out.println();
				System.out.println("Título:" + películas.get(i).getTitulo());
				System.out.println("Código:" + películas.get(i).getCodigo());
				System.out.println("Género:" + películas.get(i).getGenero());
				System.out.println("Año:" + películas.get(i).getAño());
				System.out.println("Director:" + películas.get(i).getDirector());
			}
		}
	}
	
	public void buscarPelicula(String codigo) {
		for(short i = 0; i < películas.size(); i++) {
			if(i == películas.size() - 1 && películas.get(i).getCodigo() != codigo) {
				System.out.println("Película no encontrada");
				break;
			}
			else if(películas.get(i).getCodigo() == codigo) {
				System.out.println("Película encontrada:");
				System.out.println();
				System.out.println("Título:" + películas.get(i).getTitulo());
				System.out.println("Género:" + películas.get(i).getGenero());
				System.out.println("Año:" + películas.get(i).getAño());
				System.out.println("Director:" + películas.get(i).getDirector());
			}
		}
	}
}