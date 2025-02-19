package principal;
import java.util.HashMap;

public class Cliente {
	private HashMap<String, Usuario> cliente;
	
	public Cliente() {
		cliente = new HashMap<String, Usuario>();
	}
	
	public HashMap<String, Usuario> getCliente(){
		return cliente;
	}
	
	public void agregarUsuario(String nombre, String rut, byte suscripcion) {
		Usuario usuario = new Usuario(nombre, rut, suscripcion);
		cliente.put(rut, usuario);
	}
	
	public void eliminarUsuario(String rut) {
			cliente.remove(rut);
	}
	
	public void eliminarPrestamo(Usuario user, String prestamo) {
		for(int i = 0; i < user.getPeliculaPrestada().size(); i++){
			if(user.getPeliculaPrestada().get(i).getTitulo().equalsIgnoreCase(prestamo)) {
				user.getPeliculaPrestada().remove(i);
				return;
			}
		}
		System.out.println("No se encontró película " + prestamo + " en los prestamos del usuario");
		System.out.println();
	}
	
	public void agregarPrestamo(String rut, Pelicula peli) {
		cliente.get(rut).getPeliculaPrestada().add(peli);
	}
	
	public void agregarPrestamo(Usuario user, Pelicula peli) {
		String rut = user.getRut();
		cliente.put(rut, user);
		cliente.get(rut).getPeliculaPrestada().add(peli);
	}
	
	public Usuario buscarUsuario(String rut) throws InvalidUserException {
		if(cliente.containsKey(rut)) {
			return cliente.get(rut);
		}
		throw new InvalidUserException();
	}
}
