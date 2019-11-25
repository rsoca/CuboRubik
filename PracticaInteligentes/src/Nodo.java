
public class Nodo implements Comparable<Nodo> {

	private Nodo padre;
	private Cubo estado; // como el estado es una representacion del cubo, pues es un cubo
	private String accion; // desde el padre para alcanzar el nodo actual (supongo que se refiere al
							// movimiento) ?�?�?
	private double costo;
	private double f;
	private int d; // profundidad del nodo
	private int id; // int porque llega a 2 millones

	public Nodo(Nodo padre, Cubo estado, String accion, double costo, int d, int id, double valor) {
		setPadre(padre);
		setEstado(estado);
		setAccion(accion);
		setCosto(costo);
		setD(d);
		setId(id);
		setF(valor);
	}

	public Nodo getPadre() {
		return padre;
	}

	public void setPadre(Nodo padre) {
		this.padre = padre;
	}

	public Cubo getEstado() {
		return estado;
	}

	public void setEstado(Cubo estado) {
		this.estado = estado;
	}

	public String getAccion() {
		return accion;
	}

	public void setAccion(String accion) {
		this.accion = accion;
	}

	public double getCosto() {
		return costo;
	}

	public void setCosto(double costo) {
		this.costo = costo;
	}

	public double getF() {
		return f;
	}

	public void setF(double f) {
		this.f = f;
	}

	public int getD() {
		return d;
	}

	public void setD(int d) {
		this.d = d;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int compareTo(Nodo nodo) {
		return Double.valueOf(this.f).compareTo(nodo.getF());
	}

}
