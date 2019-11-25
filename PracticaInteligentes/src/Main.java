import java.io.IOException;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException{
		Problema problema = new Problema();
		Algoritmo.busqueda(problema, "PROFUNDIDAD", 6, 0);

	}
}