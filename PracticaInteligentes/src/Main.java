import java.io.IOException;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class Main {
	public static void main(String[] args) throws IOException{
		
		Lectura leer = new Lectura();
		Cubo c= new Cubo(leer.leerArchivo());
		Cubo clon = c.clone();
		int [][][] tri = clon.getPosiciones();
		
		// OBTENER MD5 DEL CUBO DE 10X10 
		
		String id = Estado.obtenerID(clon);
		System.out.println("El ID es:"+id);
		
		String md= Estado.getMD5(id);
		System.out.println("El MD5 ES:"+md);
		

		//Movi.giroL(clon,0); // GIRO L0 FUNCIONA BIEN
		//Movi.giroL(clon, 3); //GIRO Lfinal FUNCIONA BIEN
		
		
		
		//System.out.println("La longitud es:"+tri[0].length);
		
		//System.out.println("Longitud"+tri.length+"Longitud en 0 "+tri[0].length);
		
		/*for (int i = 0; i < tri.length; i++) {
			for (int j = 0; j < tri[0].length; j++) {
				for (int k = 0; k < tri[0][0].length; k++) {
					System.out.print(" "+tri[i][j][k]);
				}
				System.out.println();
			}
		}*/
		
		//String id= Auxiliar.obtenerID(clon);
		
		//System.out.println("El ID en el main es : \n\n"+ id);
		
		//String cripto = Auxiliar.getMD5(id);
		
		//System.out.println("El codigo MD5 es : \n"+ cripto);
		//Movimientos.giroD(clon,0); 
		//Movimientos.giroD(clon,1); 
		//Movimientos.giroD(clon,2);
		//Movimientos.girod(clon,0);
		//Movimientos.girod(clon,1);
		//Movimientos.girod(clon,2);
		
		//Movimientos.giroB(clon,0);
		//Movimientos.giroB(clon,1);
		///////Movimientos.giroB(clon,2);
		///////Movimientos.girob(clon,0);
		///////Movimientos.girob(clon,1);
		///////Movimientos.girob(clon,2);
		
		//Movimientos.giroL(clon,0); //gira bien
		//Movimientos.giroL(clon,1); //bien
		//Movimientos.giroL(clon,3);
		/////////Movimientos.girol(clon,0); falla el back
		//Movimientos.girol(clon,1); //va bien
		//Movimientos.girol(clon,3); //falla el back
		
		/*System.out.println("EL ID ES: "+Auxiliar.getMD5(Auxiliar.obtenerID(clon)));
		clon=Movimientos.girol(clon,3);  //l3
		System.out.println("EL ID ES: "+Auxiliar.getMD5(Auxiliar.obtenerID(clon)));
		clon=Movimientos.giroD(clon,1);  //D1
		System.out.println("EL ID ES: "+Auxiliar.getMD5(Auxiliar.obtenerID(clon)));
		clon=Movimientos.girol(clon,1);  //l1
		System.out.println("EL ID ES: "+Auxiliar.getMD5(Auxiliar.obtenerID(clon)));
		clon=Movimientos.girod(clon,0);  //d0
		System.out.println("EL ID ES: "+Auxiliar.getMD5(Auxiliar.obtenerID(clon)));
		clon=Movimientos.giroB(clon,0);  //B0
		System.out.println("EL ID ES: "+Auxiliar.getMD5(Auxiliar.obtenerID(clon)));
		clon=Movimientos.girob(clon,5);  //b5
		System.out.println("EL ID ES: "+Auxiliar.getMD5(Auxiliar.obtenerID(clon)));
		clon=Movimientos.girol(clon,2);  //l2
		System.out.println("EL ID ES: "+Auxiliar.getMD5(Auxiliar.obtenerID(clon)));
		clon=Movimientos.girod(clon,1);  //d1
		System.out.println("EL ID ES: "+Auxiliar.getMD5(Auxiliar.obtenerID(clon)));
		*/
		
		

	}
	

}