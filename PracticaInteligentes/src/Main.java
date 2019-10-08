import java.io.IOException;

public class Main {
	public static void main(String[] args) throws IOException{
	//public void prueba() throws IOException{
		Lectura leer = new Lectura();
		Cubo c= new Cubo(leer.leerArchivo());
	}

}
