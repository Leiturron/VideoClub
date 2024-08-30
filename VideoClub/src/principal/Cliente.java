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
	
	public void eliminarPrestamo(int rut, String prestamo) {
		for(int i = 0; i < cliente.size(); i++){
			if(cliente.get(i).getRut() == rut) {
				
				for(int k = 0; k < cliente.get(i).getPeliculaPrestada().size(); k++) {
					if(cliente.get(i).getPeliculaPrestada().get(k) == prestamo) {
						cliente.get(i).getPeliculaPrestada().remove(k);
					}
				}
			
				System.out.println("El prestamo del usuario" + rut + "ha sido eliminado");
			}
			else {
				System.out.println("El " + rut + " no ha sido encontrado");
			}
		}
	}
	
	public void agregarPrestamo(int rut, String prestamo) {
		for(int i = 0; i < cliente.size(); i++){
			if(cliente.get(i).getRut() == rut) {
				for(int k = 0; k < cliente.get(i).getPeliculaPrestada().size(); k++) {
					if(cliente.get(i).getPeliculaPrestada().get(k) == prestamo) {
						System.out.println("El usuario ya  esta pelicula");
					}
					else {
						cliente.get(i).getPeliculaPrestada().add(prestamo);
						System.out.println("El usuario " + rut + " se le agregado " +prestamo);
					}
				}
			}
		}
		for(int p = 0; p < cliente.size(); p++){
			if(cliente.get(p).getRut() != rut) {
				for(int k = 0; k < cliente.get(p).getPeliculaPrestada().size(); k++) {
					if(cliente.get(p).getPeliculaPrestada().get(k) == prestamo) {
						cliente.get(p).getPeliculaPrestada().add(prestamo);
					}
				}
			}
		}
	}
	public boolean buscarUsuario(String usuario) {
		return cliente.contains(usuario);
	}
	public void enlistarUsuario() {
		System.out.println("Lista de Usuarios:");
		for(String usuario : cliente) {
			System.out.println(usuario);
		}
	}
}
