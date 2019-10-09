import java.io.IOException;

public class Main {
	public static void main(String[] args) throws IOException{
	//public void prueba() throws IOException{
		Lectura leer = new Lectura();
		Cubo c= new Cubo(leer.leerArchivo());
		int [][][] tri = c.getPosiciones();
		
		//System.out.print("Longitud"+tri.+"Longitud en 0"+tri[0].length);
		
		/*for (int i = 0; i < 6; i++) {
			for (int j = 0; j < tri[0].length; j++) {
				for (int k = 0; k < tri[0][0].length; k++) {
					System.out.println(tri[i][j][k]);
				}
			}
		}*/
	}

}
