import java.io.IOException;

/**
 * ***************************************************************
 *
 * Class Name: Problema
 * 
 * Main Author/s name: Ricardo Rodríguez Mateos-Aparicio, Razvan Dan Socaciu, Juan Manuel Palacios Navas
 * 
 * En esta clase obtendremos nuestro cubo a resolver leyendo nuestro archivo json a través de la clase lectura, 
 * y comprobaremos si hemos llegado a un nodo objetivo. 
 */


public class Problema {

	private int [][][] matriz;
	private Lectura l;
	public Problema() throws IOException {
		l=new Lectura();
		matriz = l.leerArchivo();
	}
	
	public Problema problema() throws IOException {
		Problema p = new Problema();
		return p;
	}
	
	public int[][][] getPos() {
		return matriz;
	}

	public void setPos(int[][][] pos) {
		this.matriz = pos;
	}
	
	/**
	 * ***************************************************************
	 *
	 * Method Name: esObjetivo()
	 * 
	 * 
	 * Este método se encargará de comprobar si un nodo es objetivo. Para ello, recorrerá el estado del nodo (una representación
	 * de un cubo), y en caso de que las caras tengan todos los números iguales, será un nodo objetivo.
	 */

	public static boolean esObjetivo(Nodo node) {
		boolean encontrado = true;
		Cubo estado = node.getEstado();
		int recorrido;
		int[][][] cubo = estado.getPosiciones();
		int i,j,k;
			for (i = 0; i < cubo.length; i++) { 
				recorrido = cubo [i][0][0];
				for (j = 0; j < cubo[0].length; j++) {
					for (k = 0; k < cubo[0][0].length; k++) {
						if (recorrido == cubo[i][j][k] && encontrado) {
							encontrado = true;
							
						} else { 
							encontrado = false;
						}
					}
				}
			}

		return encontrado;
	}
}
