import java.io.IOException;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class Main {
	public static void main(String[] args) throws IOException{
		
		Lectura leer = new Lectura();
		Cubo c= new Cubo(leer.leerArchivo());
		Cubo clon = c.clone();
		
		// OBTENER MD5 DEL CUBO DE 10X10 
		String id = Estado.obtenerID(clon);
		System.out.println("El ID es:"+id);	
		String md= Estado.getMD5(id);
		System.out.println("El MD5 ES:"+md);	
		Estado.imprimir(clon.getPosiciones());
		//comprobamos movimientos
		clon=Movimiento.movimiento(clon, 'l', 1);// movimiento l1
		Estado.imprimir(clon.getPosiciones());
		clon=Movimiento.movimiento(clon, 'L', 1);// a la inversa para comprobar que esta bienç
		Estado.imprimir(clon.getPosiciones());
		//vemos sucesores actuales
		Estado.Sucesores(clon);

	}
}