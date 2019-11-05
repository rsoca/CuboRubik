
public class Problema {

	public static boolean esObjetivo(Nodo node) {
		boolean encontrado = true;
		Cubo estado = node.getEstado();

		/*
		 * El bucle DO-WHILE recorre el cubo. Mientras coincidan los colores de las
		 * caras con los correspondientes segun su orden alfabetico, el bucle continua,
		 * y encontrado = true es decir, lo esta encontrando. Si resulta que en medio
		 * del bucle no coinciden, encontrado pasa a ser false, y nos devuelve
		 */

		int[] orden = { 3, 1, 2, 4, 5, 0 }; // variable donde tenemos el orden de los colores segun el orden de las
											// caras
		int recorrido; // variable donde se guarda la ultima cara recorrida
		int[][][] cubo = estado.getPosiciones();

		int longitud = (6 * cubo[0].length * cubo[0].length); // obtengo el numero total de cuadraditos a recorrer
		int contador = 0; // el contador para ir sabiendo en que parte de la longitud estoy

		int i, j, k;
		do {
			for (i = 0; i < cubo.length; i++) { // este for recorre las caras del cubo
				recorrido = orden[i];
				for (j = 0; j < cubo[0].length; j++) {
					for (k = 0; k < cubo[0][0].length; k++) {
						if (recorrido == cubo[i][j][k] && contador < longitud && encontrado == true) {
							
							encontrado = true;
							
						} else { // este else es porque si resulta que un cuadradito no corresponde con el color
									// de la cara correspondiente
							encontrado = false;
							contador = longitud;
							i = cubo.length;
							j = cubo[0].length;
							k = cubo[0][0].length;
						}
						contador++;
					}
				}
			}

		} while (encontrado == true && contador < longitud);

		return encontrado;
	}
}
