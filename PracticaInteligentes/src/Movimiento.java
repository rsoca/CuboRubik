public class Movimiento {
	// Back (0) - Down (1) - Front (2) - Left (3) - Right (4) - Up (5)
	public static Cubo movimiento(Cubo cubo, char letra, int n) {
		// Definimos las variables que vamos a utilizar de las caras
		int[][][] cuboRotar = cubo.getPosiciones();
		int longitud = cuboRotar[0].length;
		int[] up = new int[longitud];
		int[] down = new int[longitud];
		int[] front = new int[longitud];
		int[] back = new int[longitud];
		int[] left = new int[longitud];
		int[] right = new int[longitud];
		if (Character.valueOf(letra).equals('l') || Character.valueOf(letra).equals('L')) {
			int[][] left1 = new int[longitud][longitud];
			int[][] right1 = new int[longitud][longitud];
			cubo.setPosiciones(girolL(cuboRotar, cubo, up, down, front, back, left1, right1, n, letra, longitud));
		} else if (Character.valueOf(letra).equals('d') || Character.valueOf(letra).equals('D')) {
			int[][] down1 = new int[longitud][longitud];
			int[][] up1 = new int[longitud][longitud];
			cubo.setPosiciones(girodD(cuboRotar, cubo, up1, down1, front, back, left, right, n, letra, longitud));
		} else if (Character.valueOf(letra).equals('b') || Character.valueOf(letra).equals('B')) {
			int[][] back1 = new int[longitud][longitud];
			int[][] front1 = new int[longitud][longitud];
			cubo.setPosiciones(girobB(cuboRotar, cubo, back1, front1, down, left, right, up, n, letra, longitud));
		}

		return cubo;
	}


	/*
	 * Los movimientos están divididos en dos partes.
	 * En los metodos 'giro' nos encargaremos de las caras
	 *  que tenemos que rotar dentro de sí mismas (90º y -90º).
	 * 
	 * En cuanto a los métodos 'rotación', es donde giraremos aquellas caras que se sobreescribirán las unas a las otras.
	 * 
	 */
	
	private static int[][][] girobB(int[][][] cuboInicial, Cubo cubo, int[][] back, int[][] front, int[] down,
			int[] left, int[] right, int[] up, int n, char letra, int longitud) {
		int[][][] cuboRotado = rotacionbB(cuboInicial, down, left, right, up, longitud, n, letra);
		if (n == 0) {
			if (Character.valueOf(letra).equals('b')) {
				for (int i = 0; i < longitud; i++) {
					for (int j = 0; j < longitud; j++) {
						back[longitud - 1 - j][i] = cuboRotado[0][i][j];
					}
				}
			} else {
				for (int i = 0; i < longitud; i++) {
					for (int j = 0; j < longitud; j++) {
						back[j][longitud - 1 - i] = cuboRotado[0][i][j];
					}
				}
			}
			// Giramos cara back
			for (int i = 0; i < longitud; i++) {
				for (int j = 0; j < longitud; j++) {
					cuboRotado[0][i][j] = back[i][j];
				}
			}

		} else if (n == longitud - 1) {
			if (Character.valueOf(letra).equals('b')) {
				for (int i = 0; i < longitud; i++) {
					for (int j = 0; j < longitud; j++) {
						front[longitud - 1 - j][i] = cuboRotado[2][i][j];
					}
				}
			} else {
				for (int i = 0; i < longitud; i++) {
					for (int j = 0; j < longitud; j++) {
						front[j][longitud - 1 - i] = cuboRotado[2][i][j];
					}
				}
			}
			// Giramos cara front
			for (int i = 0; i < longitud; i++) {
				for (int j = 0; j < longitud; j++) {
					cuboRotado[2][i][j] = front[i][j];
				}
			}
		}
		return cuboRotado;
	}

	private static int[][][] rotacionbB(int[][][] cuboRotarComun, int[] down, int[] left, int[] right, int[] up,
			int longitud, int n, char letra) {
		if (n >= 0 && n <= longitud) {
			for (int i = 0; i < longitud; i++) {
				down[i] = cuboRotarComun[1][n][i];
				left[i] = cuboRotarComun[3][n][i];
				right[i] = cuboRotarComun[4][n][i];
				up[i] = cuboRotarComun[5][n][i];
			}
			switch (letra) {
			case 'b':
				for (int i = 0; i < longitud; i++) {
					cuboRotarComun[3][n][i] = down[i];
					cuboRotarComun[5][n][i] = left[i];
					cuboRotarComun[1][n][i] = right[i];
					cuboRotarComun[4][n][i] = up[i];
				}
				break;
			case 'B':
				for (int i = 0; i < longitud; i++) {
					cuboRotarComun[4][n][i] = down[i];
					cuboRotarComun[1][n][i] = left[i];
					cuboRotarComun[5][n][i] = right[i];
					cuboRotarComun[3][n][i] = up[i];
				}
				break;
			}

		}
		return cuboRotarComun;
	}

	private static int[][][] girodD(int[][][] cuboInicial, Cubo cubo, int[][] up, int[][] down, int[] front, int[] back,
			int[] left, int[] right, int n, char letra, int longitud) {
		int[][][] cuboRotado = rotaciondD(cuboInicial, left, right, front, back, longitud, n, letra);
		if (n == 0) {
			if (Character.valueOf(letra).equals('d')) {
				for (int i = 0; i < longitud; i++) {
					for (int j = 0; j < longitud; j++) {
						down[longitud - 1 - j][i] = cuboRotado[1][i][j];
					}
				}
			} else {
				for (int i = 0; i < longitud; i++) {
					for (int j = 0; j < longitud; j++) {
						down[j][longitud - 1 - i] = cuboRotado[1][i][j];
					}
				}
			}
			// Actualizamos cara down
			for (int i = 0; i < longitud; i++) {
				for (int j = 0; j < longitud; j++) {
					cuboRotado[1][i][j] = down[i][j];
				}
			}

		} else if (n == longitud - 1) {
			if (Character.valueOf(letra).equals('d')) {
				for (int i = 0; i < longitud; i++) {
					for (int j = 0; j < longitud; j++) {
						up[longitud - 1 - j][i] = cuboRotado[5][i][j];
					}
				}
			} else {
				for (int i = 0; i < longitud; i++) {
					for (int j = 0; j < longitud; j++) {
						up[j][longitud - 1 - i] = cuboRotado[5][i][j];
					}
				}
			}
			// Actualizamos cara up
			for (int i = 0; i < longitud; i++) {
				for (int j = 0; j < longitud; j++) {
					cuboRotado[5][i][j] = up[i][j];
				}
			}
		}
		return cuboRotado;
	}

	private static int[][][] rotaciondD(int[][][] cuboRotarComun, int[] left, int[] right, int[] front, int[] back,
			int longitud, int n, char letra) {
		if (n >= 0 && n <= longitud) {
			for (int i = 0; i < longitud; i++) {
				back[i] = cuboRotarComun[0][longitud - n - 1][i];
				front[i] = cuboRotarComun[2][n][i];
				left[i] = cuboRotarComun[3][i][longitud - n - 1];
				right[i] = cuboRotarComun[4][i][n];
			}
			switch (letra) {
			case 'd':
				for (int i = 0; i < longitud; i++) {
					cuboRotarComun[3][i][longitud - n - 1] = back[longitud - i - 1];
					cuboRotarComun[4][i][n] = front[longitud - i - 1];
					cuboRotarComun[2][n][i] = left[i];
					cuboRotarComun[0][longitud - n - 1][i] = right[i];
				}
				break;
			case 'D':
				for (int i = 0; i < longitud; i++) {
					cuboRotarComun[4][i][n] = back[i];
					cuboRotarComun[3][i][longitud - n - 1] = front[i];
					cuboRotarComun[0][longitud - n - 1][i] = left[longitud - i - 1];
					cuboRotarComun[2][n][i] = right[longitud - i - 1];
				}
				break;
			}

		}
		return cuboRotarComun;
	}

	private static int[][][] rotacionlL(int[][][] cuboRotarComun, int[] up, int[] down, int[] front, int[] back,
			int longitud, int n, char letra) {
		if (n >= 0 && n <= longitud) {
			for (int i = 0; i < longitud; i++) {
				back[i] = cuboRotarComun[0][i][n];
				down[i] = cuboRotarComun[1][i][n];
				front[i] = cuboRotarComun[2][i][n];
				up[i] = cuboRotarComun[5][i][longitud - 1 - n];
			}
			switch (letra) {
			case 'l':
				for (int i = 0; i < longitud; i++) {
					cuboRotarComun[1][i][n] = back[i];
					cuboRotarComun[2][i][n] = down[i];
					cuboRotarComun[5][longitud - 1 - i][longitud - 1 - n] = front[i];
					cuboRotarComun[0][i][n] = up[longitud - i - 1];
				}
				break;
			case 'L':
				for (int i = 0; i < longitud; i++) {
					cuboRotarComun[5][longitud - 1 - i][longitud - 1 - n] = back[i];
					cuboRotarComun[0][i][n] = down[i];
					cuboRotarComun[1][i][n] = front[i];
					cuboRotarComun[2][i][n] = up[longitud - i - 1];
				}
				break;
			}
		}
		return cuboRotarComun;
	}

	private static int[][][] girolL(int[][][] cuboInicial, Cubo c, int[] up, int[] down, int[] front, int[] back,
			int[][] left, int[][] right, int n, char letra, int longitud) {
		int[][][] cuboRotado = rotacionlL(cuboInicial, up, down, front, back, longitud, n, letra);
		if (n == 0) {
			if (Character.valueOf(letra).equals('l')) {
				for (int i = 0; i < longitud; i++) {
					for (int j = 0; j < longitud; j++) {
						left[longitud - 1 - j][i] = cuboRotado[3][i][j];
					}
				}
			} else {
				for (int i = 0; i < longitud; i++) {
					for (int j = 0; j < longitud; j++) {
						left[j][longitud - 1 - i] = cuboRotado[3][i][j];
					}
				}
			}
			// Actualizamos cara izquierda
			for (int i = 0; i < longitud; i++) {
				for (int j = 0; j < longitud; j++) {
					cuboRotado[3][i][j] = left[i][j];
				}
			}

		} else if (n == longitud - 1) {
			if (Character.valueOf(letra).equals('l')) {
				for (int i = 0; i < longitud; i++) {
					for (int j = 0; j < longitud; j++) {
						right[longitud - 1 - j][i] = cuboRotado[4][i][j];
					}
				}
			} else {
				for (int i = 0; i < longitud; i++) {
					for (int j = 0; j < longitud; j++) {
						right[j][longitud - 1 - i] = cuboRotado[4][i][j];
					}
				}
			}
			// Actualizamos cara derecha
			for (int i = 0; i < longitud; i++) {
				for (int j = 0; j < longitud; j++) {
					cuboRotado[4][i][j] = right[i][j];
				}
			}
		}
		return cuboRotado;
	}

}
