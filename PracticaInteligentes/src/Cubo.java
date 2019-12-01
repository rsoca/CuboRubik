import java.io.IOException;

public class Cubo implements Cloneable{
	Lectura leer = new Lectura();
	private String estado;
	private int posiciones[][][];

	public Cubo() throws IOException { // metodo constructor que determina el estado inicial
		this.posiciones=leer.leerArchivo();
	}

	//metodo para clonar el cubo
	public Cubo(Cubo c){
		int[][][] pos=c.getPosiciones();
		int [][][] nueva = new int[pos.length][pos[0].length][pos[0][0].length];
		for (int i = 0; i < pos.length; i++) {
			for (int j = 0; j < pos[0].length; j++) {
				for (int k = 0; k < pos[0][0].length; k++) {
					nueva[i][j][k]=pos[i][j][k];
				}
			}
		}
		posiciones=nueva;
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
