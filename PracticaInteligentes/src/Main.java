import java.io.IOException;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class Main {
	public static void main(String[] args) throws IOException{

	
		EspacioDeEstados leer = new EspacioDeEstados();
		Cubo c= new Cubo(leer.leerArchivo());
		
		Cubo clon = c.clone();
		
		int [][][] tri = clon.getPosiciones();
		
		String id= Auxiliar.obtenerID(clon);
		
		System.out.println("El ID en el main es : \n\n"+ id);
		
		String cripto = Auxiliar.getMD5(id);
		
		System.out.println("El codigo MD5 es : \n"+ cripto);
		
		//Movimientos.giroL(clon);

	}
	

}