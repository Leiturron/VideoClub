package principal;

public class Ventas {
	private int ventas;
	
	public Ventas() {
		ventas = 0;
	}
	
	public void setVentas(int ventas) {
		this.ventas = ventas;
	}
	
	public int getVentas() {
		return ventas;
	}
	
	public void hacerVenta(int precio) {
		ventas += precio;
	}
	
	public int cerrarVentas() {
		int totalVentas = ventas;
		ventas = 0;
		return totalVentas;
	}
}

