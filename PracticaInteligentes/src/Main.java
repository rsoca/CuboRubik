import java.io.IOException;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class Main {
	public static void main(String[] args) throws IOException{

	//public void prueba() throws IOException{
		Lectura leer = new Lectura();
		Cubo c= new Cubo(leer.leerArchivo());
		
		Cubo clon = c.clone();
		
		int [][][] tri = clon.getPosiciones();
		
		//System.out.println("Longitud"+tri.length+"Longitud en 0 "+tri[0].length);
		
		/*for (int i = 0; i < tri.length; i++) {
			for (int j = 0; j < tri[0].length; j++) {
				for (int k = 0; k < tri[0][0].length; k++) {
					System.out.print(" "+tri[i][j][k]);
				}
				System.out.println();
			}
		}*/
		
		String id= Auxiliar.obtenerID(clon);
		
		System.out.println("El ID en el main es : \n\n"+ id);
		
		String cripto = Auxiliar.getMD5(id);
		
		System.out.println("El codigo MD5 es : \n"+ cripto);

	}
	

}