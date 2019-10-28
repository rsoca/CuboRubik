import java.io.IOException;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class Main {
	public static void main(String[] args) throws IOException{
		
		Lectura leer = new Lectura();
		Cubo c= new Cubo(leer.leerArchivo());
		Cubo clon = c.clone();
		
		
		Nodo n1 = null;
		
		Nodo n2 = new Nodo(n1, c, "s", 1, 2);
		
		boolean objetivo = Problema.esObjetivo(n2);
		
		System.out.println(objetivo);
		
		
		/*
		
		// OBTENER MD5 DEL CUBO DE 10X10 
		String id = Estado.obtenerID(clon);
		System.out.println("El ID es:"+id);	
		String md= Estado.getMD5(id);
		System.out.println("El MD5 ES:"+md);	
		//Estado.imprimir(clon.getPosiciones());
		//comprobamos movimientos
		clon=Movimiento.movimiento(clon, 'l', 3);
		id = Estado.obtenerID(clon);
		System.out.println("El ID es:"+id);	
		md= Estado.getMD5(id);
		System.out.println("El MD5 ES:"+md);
		//Estado.imprimir(clon.getPosiciones());
		clon=Movimiento.movimiento(clon, 'D', 1);
		id = Estado.obtenerID(clon);
		System.out.println("El ID es:"+id);	
		md= Estado.getMD5(id);
		System.out.println("El MD5 ES:"+md);
		//Estado.imprimir(clon.getPosiciones());
		clon=Movimiento.movimiento(clon, 'l', 1);
		id = Estado.obtenerID(clon);
		System.out.println("El ID es:"+id);	
		md= Estado.getMD5(id);
		System.out.println("El MD5 ES:"+md);
		//Estado.imprimir(clon.getPosiciones());
		clon=Movimiento.movimiento(clon, 'd', 0);
		id = Estado.obtenerID(clon);
		System.out.println("El ID es:"+id);	
		md= Estado.getMD5(id);
		System.out.println("El MD5 ES:"+md);
		//Estado.imprimir(clon.getPosiciones());
		clon=Movimiento.movimiento(clon, 'B', 0);
		id = Estado.obtenerID(clon);
		System.out.println("El ID es:"+id);	
		md= Estado.getMD5(id);
		System.out.println("El MD5 ES:"+md);
		//Estado.imprimir(clon.getPosiciones());
		clon=Movimiento.movimiento(clon, 'b', 5);
		id = Estado.obtenerID(clon);
		System.out.println("El ID es:"+id);	
		md= Estado.getMD5(id);
		System.out.println("El MD5 ES:"+md);
		//Estado.imprimir(clon.getPosiciones());
		clon=Movimiento.movimiento(clon, 'l', 2);
		id = Estado.obtenerID(clon);
		System.out.println("El ID es:"+id);	
		md= Estado.getMD5(id);
		System.out.println("El MD5 ES:"+md);
		//Estado.imprimir(clon.getPosiciones());
		clon=Movimiento.movimiento(clon, 'd', 1);
		id = Estado.obtenerID(clon);
		System.out.println("El ID es:"+id);	
		md= Estado.getMD5(id);
		System.out.println("El MD5 ES:"+md);
		//Estado.imprimir(clon.getPosiciones());
		//vemos sucesores actuales
		//Estado.Sucesores(clon);
*/
	}
}