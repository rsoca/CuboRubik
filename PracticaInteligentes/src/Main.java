import java.io.IOException;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class Main {
	public static void main(String[] args) throws IOException {

		Lectura leer = new Lectura();
		Cubo c = new Cubo(leer.leerArchivo());
		Cubo clon = c.clone();

		String id = Auxiliar.obtenerID(clon);
		System.out.println("El ID es:" + id);

		String md = Auxiliar.getMD5(id);
		System.out.println("El MD5 ES:" + md);

		Movimiento mov = new Movimiento();
		clon = mov.movimiento(clon, 'l', 3);
		// Auxiliar.imprimir(clon.getPosiciones());
		String id2 = Auxiliar.obtenerID(clon);
		String md2 = Auxiliar.getMD5(id2);
		System.out.println("El MD5 ES:" + md2);

		clon = mov.movimiento(clon, 'D', 1);
		// Auxiliar.imprimir(clon.getPosiciones());
		id2 = Auxiliar.obtenerID(clon);
		md2 = Auxiliar.getMD5(id2);
		System.out.println("El MD5 ES:" + md2);
		// Movi.giroL(clon, 3); //GIRO Lfinal FUNCIONA BIEN

		clon = mov.movimiento(clon, 'l', 1);
		// Auxiliar.imprimir(clon.getPosiciones());
		id2 = Auxiliar.obtenerID(clon);
		md2 = Auxiliar.getMD5(id2);
		System.out.println("El MD5 ES:" + md2);

		clon = mov.movimiento(clon, 'd', 0);
		// Auxiliar.imprimir(clon.getPosiciones());
		id2 = Auxiliar.obtenerID(clon);
		md2 = Auxiliar.getMD5(id2);
		System.out.println("El MD5 ES:" + md2);

		clon = mov.movimiento(clon, 'B', 0);
		// Auxiliar.imprimir(clon.getPosiciones());
		id2 = Auxiliar.obtenerID(clon);
		md2 = Auxiliar.getMD5(id2);
		System.out.println("El MD5 ES:" + md2);

		clon = mov.movimiento(clon, 'b', 5);
		// Auxiliar.imprimir(clon.getPosiciones());
		id2 = Auxiliar.obtenerID(clon);
		md2 = Auxiliar.getMD5(id2);
		System.out.println("El MD5 ES:" + md2);

		clon = mov.movimiento(clon, 'l', 2);
		// Auxiliar.imprimir(clon.getPosiciones());
		id2 = Auxiliar.obtenerID(clon);
		md2 = Auxiliar.getMD5(id2);
		System.out.println("El MD5 ES:" + md2);

		clon = mov.movimiento(clon, 'd', 1);
		// Auxiliar.imprimir(clon.getPosiciones());
		id2 = Auxiliar.obtenerID(clon);
		md2 = Auxiliar.getMD5(id2);
		System.out.println("El MD5 ES:" + md2);
	}
}