 
public class Nodo implements Comparable<Nodo>{
	
	private Nodo padre;
	private Cubo estado; // como el estado es una representacion del cubo, pues es un cubo
	private String accion; // desde el padre para alcanzar el nodo actual (supongo que se refiere al movimiento) ?�?�?
	private double costo;
	private int f;
	private int d; // profundidad del nodo
	int id; //int porque llega a 2 millones

	public Nodo(Nodo padre, Cubo estado, String accion, double costo, int d, int id) {
		setPadre(padre);
		setEstado(estado);
		setAccion(accion);
		setCosto(costo);
		setD(d);
		setId(id);
		//this.padre = padre;
		//this.estado = estado;
		this.f = Integer.valueOf((int) (Math.random() * 10)); // Valor aleatorio entre 0 y 10
		//this.accion = accion;
		//this.costo = costo;
		//this.d = d;
		//this.id=id;
	}

	public void setPadre(Nodo padre) {
		this.padre = padre;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public void setAccion(String accion) {
		this.accion = accion;
	}

	public void setCosto(double costo) {
		this.costo = costo;
	}

	public void setF(int f) {
		this.f = f;
	}

	public void setD(int d) {
		this.d = d;
	}

	public Nodo getPadre() {
		return padre;
	}

	public Cubo getEstado() {
		return estado;
	}

	public void setEstado(Cubo estado) {
		this.estado = estado;
	}
	
	public int getF() {
		return f;
	}

	public String getAccion() {
		return accion;
	}

	public int getD() {
		return d;
	}

	public double getCosto() {
		return costo;
	}
	
	public int getID(){
		return id;
	}
	@Override
	public int compareTo(Nodo nodo) {
		return nodo.getID();
	}
}
