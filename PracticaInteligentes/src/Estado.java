import java.io.*;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class Estado {

	public static void imprimirCubo(Cubo cubo) {
		
		int[][][] tri = cubo.getPosiciones();

		for (int i = 0; i < tri.length; i++) {
			for (int j = 0; j < tri[0].length; j++) {
				for (int k = 0; k < tri[0][0].length; k++) {
					System.out.print(tri[i][j][k]);
				}
				System.out.println();
			}
		}
	}
	
	
	public static String obtenerID(Cubo cubo) {
		String ID = "";
		int[][][] tri = cubo.getPosiciones();

		for (int i = 0; i < tri.length; i++) {
			for (int j = 0; j < tri[0].length; j++) {
				for (int k = 0; k < tri[0][0].length; k++) {
					ID += tri[i][j][k];
				}
			}
		}
		return ID;
	}
	
	public static Cubo obtenerCubo(String estado) throws IOException {
		Cubo c=null;
		int dimension = (int) Math.sqrt(estado.length()/6); //obtenemos la dimension del cubo
		int [][][] tri = new int [6][dimension][dimension];
		int contador = 0;
		int limite = estado.length();
		// hacemos un vector de string separando el de estado
		String[] lista = estado.split("");

		// creamos el vector donde guardaremos los numeros con la longitud de la lista
		// anterior
		int[] numeros = new int[lista.length];
		// int limite = 6 * dimension * dimension;

		// recorremos el string numeros y guardamos en cada posicion el estado
		// correspondiente
		for (int g = 0; g < numeros.length; g++) {
			numeros[g] = Integer.parseInt(lista[g]);
		}
		
		for (int i = 0; i < tri.length; i++) {
			for (int j = 0; j < tri[0].length; j++) {
				for (int k = 0; k < tri[0][0].length; k++) {
					if (contador < limite) {
						tri[i][j][k] = numeros[contador];
						contador++;
					}
					
				}
			}
		}
		
		c= new Cubo();
		
		return c;
	}
	
	

//Metodo md5, utilizar cuando sea necesario
	public static String getMD5(String input) {
		try {
			MessageDigest md = MessageDigest.getInstance("MD5");
			byte[] messageDigest = md.digest(input.getBytes());
			BigInteger number = new BigInteger(1, messageDigest);
			String hashtext = number.toString(16);

			while (hashtext.length() < 32) {
				hashtext = "0" + hashtext;
			}
			return hashtext;
		} catch (NoSuchAlgorithmException e) {
			throw new RuntimeException(e);
		}
	}

	public static void imprimirMatriz(int[][][] cubo) {

		for (int i = 0; i < cubo.length; i++) {
			for (int j = 0; j < cubo[0].length; j++) {
				for (int k = 0; k < cubo[0][0].length; k++) {
					System.out.print(" " + cubo[i][j][k]);
				}
				System.out.println();
			}
		}
	}

	public static String[][] sucesores(Cubo c) {

		int costActi = 1; // coste de cada accion
		int dimension = c.getPosiciones()[0].length; // obtenemos la dimension de la matriz sucesores a partir del
														// tamaño del cubo

		String sucesores[][] = new String[dimension * 6][3]; // matriz de sucesores que almacena
																// [movimiento,nuevoestado,coste]
		Cubo aux= new Cubo(c.getPosiciones());
		String id = aux.getEstado(); // obtenemos el estado actual del cubo
		//System.out.println("Sucesores de (" + id + ")= ");

		for (int i = 0; i < dimension; i++) { // rellenamos la matriz en trozos de 6 "i" veces( el numero de caras por
												// la dimension del cubo)
			id = Estado.obtenerID(Movimiento.movimiento(aux, 'L', i));
			sucesores[i * 6][0] = "L" + i;
			sucesores[i * 6][1] = id;
			sucesores[i * 6][2] = Integer.toString(costActi);
			aux= new Cubo(c.getPosiciones());
			id = Estado.obtenerID(Movimiento.movimiento(aux, 'l', i));
			sucesores[(i * 6) + 1][0] = "l" + i;
			sucesores[(i * 6) + 1][1] = id;
			sucesores[(i * 6) + 1][2] = Integer.toString(costActi);
			aux= new Cubo(c.getPosiciones());
			id = Estado.obtenerID(Movimiento.movimiento(aux, 'D', i));
			sucesores[(i * 6) + 2][0] = "D" + i;
			sucesores[(i * 6) + 2][1] = id;
			sucesores[(i * 6) + 2][2] = Integer.toString(costActi);
			aux= new Cubo(c.getPosiciones());
			id = Estado.obtenerID(Movimiento.movimiento(aux, 'd', i));
			sucesores[(i * 6) + 3][0] = "d" + i;
			sucesores[(i * 6) + 3][1] = id;
			sucesores[(i * 6) + 3][2] = Integer.toString(costActi);
			aux= new Cubo(c.getPosiciones());
			id = Estado.obtenerID(Movimiento.movimiento(aux, 'B', i));
			sucesores[(i * 6) + 4][0] = "B" + i;
			sucesores[(i * 6) + 4][1] = id;
			sucesores[(i * 6) + 4][2] = Integer.toString(costActi);
			aux= new Cubo(c.getPosiciones());
			id = Estado.obtenerID(Movimiento.movimiento(aux, 'b', i));
			sucesores[(i * 6) + 5][0] = "b" + i;
			sucesores[(i * 6) + 5][1] = id;
			sucesores[(i * 6) + 5][2] = Integer.toString(costActi);
			aux= new Cubo(c.getPosiciones());
		}

		System.out.println("\nEl numero de sucesores es: " + sucesores.length);

		for (int i = 0; i < sucesores.length; i++) {
			System.out.print("(");
			for (int j = 0; j < sucesores[0].length; j++) {
				System.out.print(sucesores[i][j] + ","); // se imprime la matriz sucesores
			}
			System.out.print(")\n");
		}
		return sucesores;
	}

}
