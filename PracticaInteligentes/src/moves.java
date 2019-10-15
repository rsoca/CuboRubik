public class moves {
	// Back (0) - Down (1) - Front (2) - Left (3) - Right (4) - Up (5)
	public static Cubo movimiento(Cubo cubo, char letra, int n) {
		int[][][] cuboRotar = cubo.getPosiciones();
		int longitud = cuboRotar[0].length;
		int[] up = new int[longitud];
		int[] down = new int[longitud];
		int[] front = new int[longitud];
		int[] back = new int[longitud];
		int[][] left = new int[longitud][longitud];
		int[][] right = new int[longitud][longitud];
		if (Character.valueOf(letra).equals('l') || Character.valueOf(letra).equals('L')) {
			cubo.setPosiciones(girolL(cuboRotar, cubo, up, down, front, back, left, right, n, letra));
		}
		return cubo;
	}

	private static int[][][] rotacionlL(int[][][] cuboRotarComun, int[] up, int[] down, int[] front, int[] back,
			int longitud, int n, char letra) {
		if (n >= 0 && n <= longitud) {
			for (int i = 0; i < longitud; i++) {
				back[i] = cuboRotarComun[0][i][n];
				down[i] = cuboRotarComun[1][i][n];
				front[i] = cuboRotarComun[2][i][n];
				up[i] = cuboRotarComun[5][i][n];
			}
			switch (letra) {
			case 'l':
				if (n > 0 && n < longitud) { // Si no estoy en los bordes, girame el centro cara up
					for (int i = 0; i < longitud; i++) {
						cuboRotarComun[1][i][n] = back[i];
						cuboRotarComun[2][i][n] = down[i];
						cuboRotarComun[5][i][longitud - 1 - n] = front[i];
						cuboRotarComun[0][i][n] = up[i];
					}
				} else { // Estoy en un borde
					for (int i = 0; i < longitud; i++) {
						cuboRotarComun[1][i][n] = back[i];
						cuboRotarComun[2][i][n] = down[i];
						cuboRotarComun[5][i][n] = front[i];
						cuboRotarComun[0][i][n] = up[i];
					}
				}
				break;
			case 'L':
				if (n > 0 && n < longitud) { // Si no estoy en los bordes, girame el centro cara up
					for (int i = 0; i < longitud; i++) {
						cuboRotarComun[5][i][longitud - 1 - n] = back[i];
						cuboRotarComun[0][i][n] = down[i];
						cuboRotarComun[1][i][n] = front[i];
						cuboRotarComun[2][i][n] = up[i];
					}
				} else {
					for (int i = 0; i < longitud; i++) {
						cuboRotarComun[5][i][n] = back[i];
						cuboRotarComun[0][i][n] = down[i];
						cuboRotarComun[1][i][n] = front[i];
						cuboRotarComun[2][i][n] = up[i];
					}
				}
				break;
			}

		}
		return cuboRotarComun;
	}

	
	//MIRAR GIRO -90 Y 90
	private static int[][][] girolL(int[][][] cuboInicial, Cubo c, int[] up, int[] down, int[] front, int[] back,
			int[][] left, int[][] right, int n, char letra) {
		int longitud = cuboInicial[0].length;
		int[][][] cuboRotado = rotacionlL(cuboInicial, up, down, front, back, longitud, n, letra);
		// ESTAMOS EN LA IZQUIERDA
		if (n == 0) {
			if (Character.valueOf(letra).equals('l')) {
				for (int i = 0; i < longitud; i++) {
					for (int j = 0; j < longitud; j++) {
						left[j][i] = cuboRotado[3][i][j];
					}
				}
			} else {
				for (int i = 0; i < longitud; i++) {
					for (int j = 0; j < longitud; j++) {
						left[i][j] = cuboRotado[3][i][j];
					}
				}
			}
			// Giramos cara izquierda
			for (int i = 0; i < longitud; i++) {
				for (int j = 0; j < longitud; j++) {
					cuboRotado[3][i][j] = left[j][i];
				}
			}

		} else if(n == longitud) { // ESTAMOS EN LA DERECHA
			if (Character.valueOf(letra).equals('l')) {
				for (int i = 0; i < longitud; i++) {
					for (int j = 0; j < longitud; j++) {
						right[j][i] = cuboRotado[4][i][j];
					}
				}
			} else {
				for (int i = 0; i < longitud; i++) {
					for (int j = 0; j < longitud; j++) {
						right[i][j] = cuboRotado[4][i][j];
					}
				}
			}
			// Giramos cara derecha
			for (int i = 0; i < longitud; i++) {
				for (int j = 0; j < longitud; j++) {
					cuboRotado[4][i][j] = right[j][i];
				}
			}
		}
		return cuboRotado;
	}

}
