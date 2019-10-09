import java.io.IOException;
import java.util.Set;

public class Cubo implements Cloneable{
	private Lectura leer = new Lectura();
	private String estado;
	private int ID;
	private int posiciones[][][];// matriz de 3 dimensiones: la primera para decirme que cara es, la segunda y
									// tercera son las dimensiones de la cara.

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

	public int [][][] getPosiciones() {
		return posiciones;
	}
	
	public void setPosiciones(int [][][] posiciones) {
		this.posiciones=posiciones;
	}
	
	
	// LOS MOVIMIENTOS SON DE Ln, Dn Y Bn

}
//metodos necesarios:
//Clonar HECHO
//Contructor que reciba el string del json HECHO
//Generador de numero unico de MD5 
//Para comprobar si esta bien partir del cubo hecho, desacerlo y volver a hacer movimientos al reves para resolverlo a ver si sale bien.