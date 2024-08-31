package principal;
import java.util.ArrayList;

public class Cliente {
	private ArrayList<Usuario> cliente;
	
	public Cliente() {
		cliente = new ArrayList<Usuario>();
	}
	
	public ArrayList<Usuario> getCliente(){
		return cliente;
	}
	
	public void eliminarPrestamo(Usuario user, String prestamo) {
		for(int i = 0; i < user.getPeliculaPrestada().size(); i++){
			if(user.getPeliculaPrestada().get(i).equalsIgnoreCase(prestamo)) {
				user.getPeliculaPrestada().remove(i);
				return;
			}
		}
		System.out.println("No se encontró película " + prestamo + " en el prestamo del usuario");
		System.out.println();
	}
	
	public void agregarPrestamo(String rut, String prestamo) {
		for(int i = 0; i < cliente.size(); i++){
			if(cliente.get(i).getRut().equalsIgnoreCase(rut)) {
				cliente.get(i).getPeliculaPrestada().add(prestamo);
				return;
			}
		}
	}
	
	public void agregarPrestamo(Usuario user, String prestamo) {
		cliente.add(user);
		cliente.getLast().getPeliculaPrestada().add(prestamo);
	}
	
	public Usuario buscarUsuario(String rut) {
		for(int i = 0; i < cliente.size(); i++) {
			if(cliente.get(i).getRut().equalsIgnoreCase(rut))
				return cliente.get(i);
		}
		return null;
	}
}

