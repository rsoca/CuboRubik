import java.io.IOException;
import java.util.Set;

public class Cubo { 
	private Lectura leer = new Lectura();
	private String estado;
	private int ID;
	private int posiciones [][][];//matriz de 3 dimensiones: la primera para decirme que cara es, la segunda y tercera son las dimensiones de la cara.
	public Cubo(String estado){ //metodo constructor que determina el estado inicial
		setEstado(estado);
		setPosicion(estado);
	}
	public void setEstado(String es){
		this.estado =es;
	}public void setPosicion(String es){
		int pointer=0;
		System.out.println("La dimension es nueva"+leer.getDimension());
		posiciones= new int [6][leer.getDimension()][leer.getDimension()];
		for(int i=0;i<6;i++){
			for(int j=0;j<leer.getDimension();j++){
				for(int k=0;k<leer.getDimension();k++){
					posiciones[i][j][k]=es.toCharArray()[pointer];
					pointer++;
					System.out.print(posiciones[i][j][k]);
				}//System.out.println("\r");
			}
		}
		
	}
	 //LOS MOVIMIENTOS SON DE Ln, Dn Y Bn
	
	
}
//metodos necesarios:
//Clonar
//Contructor que reciba el string del json
//Generador de numero unico de MD5
//Para comprobar si esta bien partir del cubo hecho, desacerlo y volver a hacer movimientos al reves para resolverlo a ver si sale bien.