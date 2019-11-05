 
public class Nodo {
	
	private Nodo padre;
	private Cubo estado; // como el estado es una representacion del cubo, pues es un cubo
	private String accion; // desde el padre para alcanzar el nodo actual (supongo que se refiere al movimiento) ?¿?¿?
	private double costo;
	private int f;
	private long d; // profundidad del nodo

	public Nodo(Nodo padre, Cubo estado, String accion, double costo, long d) {
		this.padre = padre;
		this.estado = estado;
		this.f = Integer.valueOf((int) (Math.random() * 10)); // Valor aleatorio entre 0 y 10
		this.accion = accion;
		this.costo = costo;
		this.d = d;
	}

	public Nodo getPadre() {
		return padre;
	}

	public Cubo getEstado() {
		return estado;
	}

	public int getF() {
		return f;
	}

	public String getAccion() {
		return accion;
	}

	public double getCosto() {
		return costo;
	}

	public long getD() {
		return d;
	}
}
