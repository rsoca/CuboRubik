
public class Nodo {
	private Nodo nodo;
	private Estado estado;
	private String accion;
	private double costo;
	private int f; 
	private long profundidad;
	
	public Nodo(Nodo nodo, Estado estado, String accion, double costo, long profundidad) {
		this.nodo = nodo;
		this.estado = estado;
		this.f = Integer.valueOf((int)(Math.random() * 10)); //Valor aleatorio entre 0 y 10
		this.accion = accion;
		this.costo = costo;
		this.profundidad = profundidad;
	}

	public Nodo getNodo() {
		return nodo;
	}

	public Estado getEstado() {
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

	public long getProfundidad() {
		return profundidad;
	}
}
