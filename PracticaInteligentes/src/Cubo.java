import java.io.IOException;
import java.util.Set;

public class Cubo implements Cloneable{
	private String estado;
	private int posiciones[][][];

	public Cubo(int[][][] posiciones) { // metodo constructor que determina el estado inicial
		this.posiciones = posiciones;
	}

	//metodo para clonar el cubo
	public Cubo clone() {
		Cubo clon = new Cubo(this.posiciones);
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
