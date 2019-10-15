import java.io.IOException;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.io.IOException;

//en esta clase tendremos varios metodos de ayuda, de momomento, seran los de generarMD5 y obtenerMD5
//este ultimo lo estaba haciendo el main para ir probando a ver si funciona
public class Auxiliar {

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
		// compruebo que este bien guardado
		System.out.println("La cadena es: \n" + ID);

		// devuelvo el id del cubo
		return ID;

	}/// final obtener MD5

//Método md5, utilizar cuando sea necesario
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

	public static void imprimir(int[][][] cubo) {

		for (int i = 0; i < cubo.length; i++) {
			for (int j = 0; j < cubo[0].length; j++) {
				for (int k = 0; k < cubo[0][0].length; k++) {
					System.out.print(" " + cubo[i][j][k]);
				}
				System.out.println();
			}
		}
	}

}
