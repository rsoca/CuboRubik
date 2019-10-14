
public class Movimientos {

	public static Cubo giroL (Cubo cubo) {
		
		//obtenemos la matriz del cubo 
		Cubo c=cubo;
		int [][][] aux = c.getPosiciones();
		
		// variable para saber la longitud del cubo
		int longitud = aux[0].length;
		
		System.out.println("El cubo antes del giro");
		Auxiliar.imprimir(aux);//impresion del cubo antes del giro
		
		
		//primero giro L0 (izquierda del front, giro completo de cara LEFT)
		
		// variable para guardar la filas y caras
		int [] up = new int [longitud]; 
		int [] down =  new int [longitud];
		int [] front =  new int [longitud];
		int [] back = new int [longitud];
		int [][] left = new int [longitud][longitud];

		// guardamos los datos en las variables
		
		for(int i=0; i<longitud;i++){
			up [i] = aux [0][i][0];
			down[i] = aux [1][i][0];
			front [i] = aux [2][i][0];
			back [i] = aux [3][i][0];
		}
		
		/*System.out.println("Lo que cojo del cubo");
		for(int g=0;g<longitud;g++){
			System.out.print(up[g]);
			System.out.print(down[g]);
			System.out.print(front[g]);
			System.out.print(back[g]);
			System.out.println("");
		}*/
		
		
		for(int j=0; j<longitud; j++) {
			for(int k=0;k<longitud; k++) {
				left[j][k] = aux[4][j][k];
			}
		}
		
		//cambiamos los numeros en las caras del cubo
		
		for(int i=0; i<longitud;i++){
			aux [0][i][0] = back[i]; //En UP meto lo de BACK
			aux [1][i][0] = front[i]; //En DOWN meto lo de FRONT
			aux [2][i][0] = up[i]; //En FRONT meto lo de UP
			aux [3][i][0] = down[i]; //En BACK meto lo de DOWN
		}
		
		int k;
		for(int i=0; i<longitud; i++) {
			k=longitud-1;
			for(int j=0;j<longitud; j++) {
				aux[4][i][j] = left[k][i];
				k--;
			}
		}
		
		
		System.out.println("El cubo DESPUES del giro");
		Auxiliar.imprimir(aux);//impresion del cubo antes del giro
		
		
		return c;
	}
	
	
	
}
