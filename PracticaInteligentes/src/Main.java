import java.io.IOException;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException{
		
		Cubo c = new Cubo();
		
		Problema problema = new Problema();
		//Algoritmo.busqueda(problema, "VORAZ", 6, 0);
		Algoritmo.busqueda(problema, "PROFUNDIDAD", 6, 0);
		//Algoritmo.busqueda(problema, "ANCHURA", 6, 0);
		
		//Double m = Algoritmo.calcularEntropia(c);
		
		//System.out.println("El valor de m es: "+m);
		
	}
}