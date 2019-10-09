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
		
		String id= obtenerID(clon);
		
		System.out.println("El ID en el main es : \n\n"+ id);
		
		String cripto = getMD5(id);
		
		System.out.println("El codigo MD5 es : \n"+ cripto);
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
		 }
		 catch (NoSuchAlgorithmException e) {
		 throw new RuntimeException(e);
		 }
		 }

}
