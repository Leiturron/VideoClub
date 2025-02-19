package principal;

import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;

public class Almacén {
	private int ordenCodigo;
	private ArrayList<Pelicula> películas;
	private HashMap<String, PeliGenero> mapaGéneros;
	private HashMap<String, PeliDirector> mapaDirectores;
	private HashMap<Integer, PeliDecada> mapaDécadas;
	
	public Almacén(){
		películas = new ArrayList<Pelicula>();
		mapaGéneros = new HashMap<String, PeliGenero>();
		mapaDirectores = new HashMap<String, PeliDirector>();
		mapaDécadas = new HashMap<Integer , PeliDecada>();
		this.ordenCodigo = 1;
	}
	
	public int getSizePeliculas() {
		return películas.size();
	}
	
	public Pelicula getPelicula(int i) {
		return películas.get(i);
	}
	
	public void agregarPelicula(Pelicula pelicula) {
		películas.add(pelicula);
	}
	
	public void Datos(){
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
		catch(IOException e) {
			e.printStackTrace();
		}
		catch(EmptyValueException e2) {
			e2.printStackTrace();
		}
	}
	
	public void agregarPelícula(Pelicula película) throws EmptyValueException {
		
		if(película.getTitulo().isEmpty() || película.getDirector().isEmpty() || 
		   película.getGenero().isEmpty() || película.getAño() == 0 ||
		   película.getStock() == 0) {
			throw new EmptyValueException();
		}
		películas.add(película);
		
		String genero = película.getGenero().toUpperCase();
		if(mapaGéneros.get(genero) == null) {
			PeliGenero peliGenre = new PeliGenero();
			peliGenre.setName(genero);
			mapaGéneros.put(genero, peliGenre);
		}
		
		String director = película.getDirector().toUpperCase();
		if(mapaDirectores.get(director) == null) {
			PeliDirector peliDir = new PeliDirector();
			peliDir.setName(director);
			mapaDirectores.put(director, peliDir);
		}
		
		int decada = película.getDecada(película.getAño());
		if(mapaDécadas.get(decada) == null) {
			PeliDecada peliDec = new PeliDecada();
			peliDec.setDecada(decada);
			mapaDécadas.put(decada, peliDec);
		}
		
		mapaGéneros.get(genero).agregar(película);
		mapaDirectores.get(director).agregar(película);
		mapaDécadas.get(decada).agregar(película);
		
		this.ordenCodigo++;
		
	}

	public boolean eliminarPelícula(String titulo) throws NameInvalidException {
		for(short i = 0; i < películas.size(); i++) {
			if(películas.get(i).getTitulo().equalsIgnoreCase(titulo)) {
				Pelicula película = películas.remove(i);
				
				
				String genero = película.getGenero().toUpperCase();
				PeliGenero tempGenre = mapaGéneros.get(genero);
				tempGenre.eliminarPorTitulo(titulo);
				
				
				String director = película.getDirector().toUpperCase();
				PeliDirector tempDir = mapaDirectores.get(director);
				tempDir.eliminarPorTitulo(titulo);
				
				int anno = película.getAño();
				int decada = película.getDecada(anno);
				PeliDecada tempDec = mapaDécadas.get(decada);
				tempDec.eliminarPorTitulo(titulo);
				
				return true;
			}
		}
		throw new NameInvalidException();
	}
	
	public boolean eliminarPelícula(int codigo) throws NumInvalidException {
		for(short i = 0; i < películas.size(); i++) {
			if(películas.get(i).getCodigo() == codigo) {
				Pelicula película = películas.remove(i);
				
				
				String genero = película.getGenero().toUpperCase();
				PeliGenero tempGenre = mapaGéneros.get(genero);
				tempGenre.eliminarPorCodigo(codigo);
				
				
				String director = película.getDirector().toUpperCase();
				PeliDirector tempDir = mapaDirectores.get(director);
				tempDir.eliminarPorCodigo(codigo);
				
				int anno = película.getAño();
				int decada = película.getDecada(anno);
				PeliDecada tempDec = mapaDécadas.get(decada);
				tempDec.eliminarPorCodigo(codigo);
				
				return true;
			}
		}
		throw new NumInvalidException();
	}
	
	public boolean editarPeli(String titulo, String descripcion) {
		for(short i = 0; i < películas.size(); i++) {
			if(películas.get(i).getTitulo().equalsIgnoreCase(titulo)) {
				Pelicula pelicula = películas.get(i);
				pelicula.setDescripcion(descripcion);
				
				//mapaGéneros.get(pelicula.getGenero()).editarPelicula(titulo, descripcion);
				//mapaDirectores.get(pelicula.getDirector()).editarPelicula(titulo, descripcion);
				//mapaDécadas.get(pelicula.getDecada(pelicula.getAño())).editarPelicula(titulo, descripcion);
				
				return true;
			}
		}
		return false;
	}
	
	public Pelicula buscarPorCodigo(int codigo) throws NumInvalidException{
		for(short i = 0; i < películas.size(); i++)
			if(películas.get(i).getCodigo() == codigo) return películas.get(i);
		throw new NumInvalidException();
	}
	
	public Pelicula buscarPorTitulo(String titulo) throws NameInvalidException {
		for(short i = 0; i < películas.size(); i++) 
			if(películas.get(i).getTitulo().equalsIgnoreCase(titulo)) return películas.get(i);
		throw new NameInvalidException();
	}

	public PeliGenero buscarPorGenero(String genero) throws InvalidGenreException {
		String genre = genero.toUpperCase();
		if(mapaGéneros.containsKey(genre)) {
			return mapaGéneros.get(genre);
		}
		throw new InvalidGenreException();
	}
	
	public PeliDirector buscarPorDirector(String director) throws InvalidDirectorException {
		String direc = director.toUpperCase();
		if(mapaDirectores.containsKey(direc)) {
			return mapaDirectores.get(direc);
		}
		throw new InvalidDirectorException();
	}
	
	public PeliDecada buscarPorDecada(int decada) throws InvalidDecadeException {
		if(mapaDécadas.containsKey(decada)) {
			return mapaDécadas.get(decada);
		}
		throw new InvalidDecadeException();
	}
	
	//getter setter
	public int getOrden() {
		return ordenCodigo;
	}

	public void setOrden(int ordenCodigo) {
		this.ordenCodigo = ordenCodigo;
	}
}
