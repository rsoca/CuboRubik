import java.io.IOException;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException{
		Cubo c= new Cubo();
		Cubo clon = new Cubo(c);
		Lectura leer = new Lectura();
		
		int [][][] posiciones = leer.leerArchivo();
		
		//Cubo clon= new Cubo(c);
		//Estado.imprimirCubo(c);
		Algoritmo.busqueda_acotada(posiciones, "e", 6);
		//Estado.sucesores(c);
		
		//Estado.imprimirCubo(c);
		//System.out.println("Cubo movido");
		//c=Movimiento.movimiento(c, 'd', 2);
		//Estado.imprimirCubo(c);
		/*  QUITAR ESTA LINEA PARA QUE EJECUTE EL CODIGO

//-----------------------------------------------------------------------------------------------------------------
		Movimiento.movimiento(clon, 'L', 0); 
		String id=Estado.obtenerID(clon);
		System.out.println("Estado"+id);    
		Movimiento.movimiento(clon, 'l', 0);   // AQUI HAGO LA INVERSA PARA QUE COMPROBEIS QUE SALE LO MISMO, 
		Movimiento.movimiento(clon, 'l', 0);
		id=Estado.obtenerID(clon);
		System.out.println("Estado"+id);
		Movimiento.movimiento(clon, 'L', 0);     // AQUI HAGO LA INVERSA PARA QUE COMPROBEIS QUE SALE LO MISMO
		Movimiento.movimiento(clon, 'D', 0);
		id=Estado.obtenerID(clon);
		System.out.println("Estado"+id);
		Movimiento.movimiento(clon, 'd', 0);    // AQUI HAGO LA INVERSA PARA QUE COMPROBEIS QUE SALE LO MISMO
//------------------------------------------------------------------------------------------------------------------        		
        		//BORRAR CODIGO ENTRE GUIONES PARA QUE HAGA SUCESORES SIN COMPROBAR LOS MOVIMIENTOS
        		
	    
		Estado.sucesores(clon);
		
		
		//c=Movimiento.movimiento(clon, 'L', 0);
		//Estado.imprimirCubo(c);
		//clon=Movimiento.movimiento(clon, 'l', 0);
		//Estado.imprimirCubo(clon);

		//Algoritmos.busqueda_acotada(leer.leerArchivo(), "anchura", 6);
				
		
		//Nodo n1 = null;
		//Nodo n2 = new Nodo(n1, clon, "s", 1, 2, 0);
		
		//boolean objetivo = Problema.esObjetivo(n2);
		//System.out.println("Nodo prueba (Objetivo): "+objetivo);
		//Estado.sucesores(c);
		
		//Cubo nuevo = Estado.obtenerCubo("133133133211211211022022022444444444555555555003003003");
		//System.out.println("Situacion del cubo nuevo");
		//Estado.imprimirCubo(nuevo);
		
		/*
		 * MOVIMIENTOS Y MD5 CUBO 
		 * 
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
		
*/
	}
}