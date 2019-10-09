import java.io.IOException;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.io.IOException;

//en esta clase tendremos varios metodos de ayuda, de momomento, seran los de generarMD5 y obtenerMD5
//este ultimo lo estaba haciendo el main para ir probando a ver si funciona
public class Auxiliar {
	public static void main(String[] args) throws IOException{
	
}
	public static String obtenerID(Cubo cubo) {
		StringBuffer cadena = new StringBuffer();
		String ID="";
		
		int [] almacen;
		int [][][] tri = cubo.getPosiciones();
		almacen = new int [tri.length*tri[0].length*tri[0][0].length];
		
		System.out.println("Longitud almacen "+almacen.length);
		
		int longitud = almacen.length;
		int contador=0;
		for (int i = 0; i < tri.length; i++) {
			for (int j = 0; j < tri[0].length; j++) {
				for (int k = 0; k < tri[0][0].length; k++) {
					if(contador<longitud) {
					almacen [contador] = tri[i][j][k];
					contador++;
					}
				}
			}
		}
		// voy guardando cada dato del vector almacen en el buffer cadena
		for (int x=0;x<almacen.length;x++){
			   cadena =cadena.append(almacen[x]);
			}
		//convierto el buffer cadena a string y lo guardo en ID
		ID = cadena.toString();
		
		// compruebo que este bien guardado 
		System.out.println("La cadena es: \n"+ID);
		
		/*System.out.println("El vector almacen es: \n");
		for (int k = 0; k < almacen.length; k++) {
			System.out.print(almacen [k]);
		}*/
		
		// devuelvo el id del cubo
		return ID;
		
	}//final obtener MD5

//Método md5, utilizar cuando sea necesario
public static String getMD5(String clave) {
	try {

		MessageDigest mensaje = MessageDigest.getInstance("MD5");
		byte[] messageDigest = mensaje.digest(clave.getBytes());
		BigInteger numero = new BigInteger(1, messageDigest);
		String encriptacion = numero.toString();
		while (encriptacion.length() < 32)
			encriptacion = "0" + encriptacion;
		return encriptacion;
	} catch (NoSuchAlgorithmException o) {
		throw new RuntimeException(o);
	}

}
}
