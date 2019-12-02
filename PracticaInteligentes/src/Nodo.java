
public class Nodo {

	private Nodo padre;
	private Cubo estado; 
	private String accion; 
	private double costo;
	private double f;
	private int d; 
	private int id; 
	private double h; 

	public Nodo(Nodo padre, Cubo estado, String accion, double costo, int d, int id, double valor, double h) {
		setPadre(padre);
		setEstado(estado);
		setAccion(accion);
		setCosto(costo);
		setD(d);
		setId(id);
		setF(valor);
		setH(h);
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

	public double getH() {
		return h;
	}
	
	public void setH(double h) {
		this.h=h;
	}
}
