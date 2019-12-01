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
		Cubo c=new Cubo();
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
		
		c.setPosiciones(tri);
		c.setEstado(estado);
		return c;
	}
	

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

		int costActi = 1; 
		int dimension = c.getPosiciones()[0].length; 
		String sucesores[][] = new String[dimension * 6][3]; 
		Cubo aux= new Cubo(c);
		String estado = aux.getEstado();
		char[] orden = { 'B', 'b', 'D', 'd', 'L', 'l' };
		int bucle = 0;
		for (int contador = 0; contador < orden.length; contador++) {
			String letra = String.valueOf(orden[contador]);
			for (int j = 0; j < dimension; j++) {
				estado = Estado.obtenerID(Movimiento.movimiento(aux, orden[contador], j));
				sucesores[bucle][0] = letra + j;
				sucesores[bucle][1] = estado;
				sucesores[bucle][2] = Integer.toString(costActi);
				aux = new Cubo(c);
				bucle++;
			}
		}
		return sucesores;
	}

}
