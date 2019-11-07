import java.io.IOException;
import java.util.Set;

public class Cubo implements Cloneable{
	Lectura leer = new Lectura();
	private String estado;
	private int posiciones[][][];

	public Cubo(int posiciones[][][]) { // metodo constructor que determina el estado inicial
		this.posiciones=posiciones;
	}

	//metodo para clonar el cubo
	public Cubo clone() {
		int [][][] nueva;
		Cubo clon = null;
		return clon;
	}
	
	
	public void setEstado(String es) {
		this.estado = es;
	}
	public String getEstado(){
		return estado;
	}

	public int [][][] getPosiciones() {
		return posiciones;
	}
	
	public void setPosiciones(int [][][] posiciones) {
		this.posiciones=posiciones;
	}
	
}	
