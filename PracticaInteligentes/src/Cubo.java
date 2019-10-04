import java.io.IOException;
import java.util.Set;

public class Cubo { 
	
	public int BACK[][];
    public int DOWN[][];
    public int FRONT[][];
    public int LEFT[][];
    public int RIGHT[][];
    public int UP[][];
	private String estado;
	private int ID;
	private short caras=6,n=3,m=n;
	private int cube [][][]= new int[caras][n][m];//matriz de 3 dimensiones: la primera para decirme que cara es, la segunda y tercera son las dimensiones de la cara.
	public Cubo(String estado){ //metodo constructor que determina el estado inicial
		setEstado(estado);
	}
	public Cubo(){
		
	}public void setEstado(String es){
		this.estado =es;
	}public void iniciarCubo() throws IOException{ //metodo que crea un objeto cubo
		Lectura leer = new Lectura();
		Cubo c1 = leer.leerArchivo();//IDENTIFICADORES DE CARAS QUE SERIAN LOS COLORES(TIENEN QUE SER SHORT)
		c1.cube[0]=c1.UP;
		c1.cube[1]=c1.DOWN;
		c1.cube[2]=c1.FRONT;
		c1.cube[3]=c1.BACK;
		c1.cube[4]=c1.LEFT;
		c1.cube[5]=c1.RIGHT;
		//impresion del cubo para comprobar
		for(int i=0;i<caras;i++){
			for(int j=0;j<n;j++){
				for(int k=0;k<m;k++){
					System.out.print(c1.cube[i][j][k]);
				}System.out.println("\r");
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