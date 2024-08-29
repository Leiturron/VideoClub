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
	
	public Pelicula buscarPorCodigo(int codigo) {
		for(short i = 0; i < películas.size(); i++)
			if(películas.get(i).getCodigo() == codigo) return películas.get(i);
		return null;
	}
	
	public Pelicula buscarPorTitulo(String titulo) {
		for(short i = 0; i < películas.size(); i++) 
			if(películas.get(i).getTitulo() == titulo) return películas.get(i);
		return null;
	}
	
	public void buscarPorDirector(String director) {
		if(mapaDirectores.get(director) == null) {
			System.out.println("No existen películas dirigidas por " + director);
			System.out.println();
		}
		else {
			System.out.println("Películas dirigidas por " + director);
			System.out.println();
			for(short i = 0; i < mapaDirectores.get(director).size(); i++) {
				System.out.println((i + 1) + "." + " Título: " + mapaDirectores.get(director).get(i).getTitulo());
				System.out.println("   Género: " + mapaDirectores.get(director).get(i).getGenero());
				System.out.println("   Año: " + mapaDirectores.get(director).get(i).getAño());
				System.out.println("   Director: " + mapaDirectores.get(director).get(i).getAño());
				System.out.println("   Stock: " + mapaDirectores.get(director).get(i).getStock());
			}
		}
	}
	
	public void buscarPorGénero(String género) {
		if(mapaGéneros.get(género) == null) {
			System.out.println("No existen películas del género " + género);
			System.out.println();
		}
		else {
			System.out.println("Películas del género " + género);
			System.out.println();
			for(short i = 0; i < mapaGéneros.get(género).size(); i++) {
				System.out.println((i + 1) + "." + " Título: " + mapaGéneros.get(género).get(i).getTitulo());
				System.out.println("   Género: " + mapaGéneros.get(género).get(i).getGenero());
				System.out.println("   Año: " + mapaGéneros.get(género).get(i).getAño());
				System.out.println("   Director: " + mapaGéneros.get(género).get(i).getAño());
				System.out.println("   Stock: " + mapaGéneros.get(género).get(i).getStock());
			}
		}
	}
	
	public void buscarPorDécada(int década) {
		if(mapaDécadas.get(década) == null) {
			System.out.println("No existen películas en la década de " + década);
			System.out.println();
		}
		else {
			System.out.println("Películas en la década de" + década);
			System.out.println();
			for(short i = 0; i < mapaDécadas.get(década).size(); i++) {
				System.out.println((i + 1) + "." + " Título: " + mapaDécadas.get(década).get(i).getTitulo());
				System.out.println("   Género: " + mapaDécadas.get(década).get(i).getGenero());
				System.out.println("   Año: " + mapaDécadas.get(década).get(i).getAño());
				System.out.println("   Director: " + mapaDécadas.get(década).get(i).getAño());
				System.out.println("   Stock: " + mapaDécadas.get(década).get(i).getStock());
			}
		}
	}
}