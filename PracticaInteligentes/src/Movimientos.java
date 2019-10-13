
public class Movimientos {

	
public static Cubo giroL (Cubo cubo, int n) {
		
		int [][][] aux = cubo.getPosiciones();  //obtenemos la matriz del cubo
		
		int longitud = aux[0].length;  // variable para saber la longitud del cubo

		int ultimo = longitud -1; //variable que nos indicara la ultima fila del cubo
		
		System.out.println("La longitud del cubo es: "+longitud+" El ultimo es: "+ultimo);
		System.out.println("El cubo antes del giro");
		Auxiliar.imprimir(aux);//impresion del cubo antes del giro
		
		// variable para guardar la filas y caras
		int [] up = new int [longitud]; 
		int [] down =  new int [longitud];
		int [] front =  new int [longitud];
		int [] back = new int [longitud];
		int [][] left = new int [longitud][longitud];
		int [][] right = new int [longitud][longitud];

		if( n >= 0 && n < longitud) {
			
			if(n == 0) {//giro la parte left FUNCIONA NO MODIFICAR
				System.out.println("Me estoy metiendo en el bucle n==0");
								for(int i=0; i<longitud;i++){ //son las 4 caras que giran
									up [i] = aux [0][i][0];
									down[i] = aux [1][i][0];
									front [i] = aux [2][i][0];
									back [i] = aux [3][i][ultimo];
								}
								
								//obtengo la cara left
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
									aux [3][i][ultimo] = down[i]; //En BACK meto lo de DOWN
								}
								
								//
								int k;
								for(int i=0; i<longitud; i++) {
									k=longitud-1;
									for(int j=0;j<longitud; j++) {
										aux[4][i][j] = left[k][i];
										k--;
									}
								}
				
				
			}else if (n == longitud-1) { //es longitud menos 1 porque el cuadrado empieza a contar en 0
				//giro la parte con right
				
				System.out.println("Me estoy metiendo en el bucle del right");
				
								for(int i=0; i<longitud;i++){ //son las 4 caras que siempre cambiaran en un L
									up [i] = aux [0][i][n];
									down[i] = aux [1][i][n];
									front [i] = aux [2][i][n];
									back [i] = aux [3][i][0];
								}
								
								//obtengo la cara right
								for(int j=0; j<longitud; j++) {
									for(int k=0;k<longitud; k++) {
										right[j][k] = aux[5][j][k];
									}
								}
								
								//cambiamos los numeros en las caras del cubo
								
								for(int i=0; i<longitud;i++){
									aux [0][i][n] = back[i]; //En UP meto lo de BACK
									aux [1][i][n] = front[i]; //En DOWN meto lo de FRONT
									aux [2][i][n] = up[i]; //En FRONT meto lo de UP
									aux [3][i][0] = down[i]; //En BACK meto lo de DOWN
								}
								//GIRO DE -90 grados, cara contraria
								int k=longitud-1;
								for(int i=0; i<longitud; i++) {
									for(int j=0;j<longitud; j++) {
										aux[5][i][j] = right[j][k];
									}
									k--;
								}
								
			}else {//imprimo el giro interior
				System.out.println("Me estoy metiendo en el bucle central");
				for(int i=0; i<longitud;i++){ //son las 4 caras que tengo que obtener
					up [i] = aux [0][i][n];
					down[i] = aux [1][i][n];
					front [i] = aux [2][i][n];
					back [i] = aux [3][i][n];
				}
				
				//giro las caras
				for(int i=0; i<longitud;i++){
					aux [0][i][n] = back[i]; //En UP meto lo de BACK
					aux [1][i][n] = front[i]; //En DOWN meto lo de FRONT
					aux [2][i][n] = up[i]; //En FRONT meto lo de UP
					aux [3][i][n] = down[i]; //En BACK meto lo de DOWN
				}
				
				
			}
			
			
			
		}else {
			System.out.println("El giro no es posible, elija otra fila");
		}
		
		
		
		System.out.println("El cubo DESPUES del giro");
		Auxiliar.imprimir(aux);//impresion del cubo antes del giro
		
		cubo.setPosiciones(aux);
		return cubo;
	}
	
public static Cubo girol (Cubo cubo, int n) {
	
	int [][][] aux = cubo.getPosiciones();  //obtenemos la matriz del cubo
	
	int longitud = aux[0].length;  // variable para saber la longitud del cubo

	int ultimo = longitud -1; //variable que nos indicara la ultima fila del cubo
	
	System.out.println("La longitud del cubo es: "+longitud+" El ultimo es: "+ultimo);
	System.out.println("El cubo antes del giro");
	Auxiliar.imprimir(aux);//impresion del cubo antes del giro
	
	// variable para guardar la filas y caras
	int [] up = new int [longitud]; 
	int [] down =  new int [longitud];
	int [] front =  new int [longitud];
	int [] back = new int [longitud];
	int [][] left = new int [longitud][longitud];
	int [][] right = new int [longitud][longitud];

	if( n >= 0 && n < longitud) {
		
		if(n == 0) {//giro la parte left FUNCIONA NO MODIFICAR
			System.out.println("Me estoy metiendo en el bucle n==0");
							for(int i=0; i<longitud;i++){ //son las 4 caras que giran
								up [i] = aux [0][i][0];
								down[i] = aux [1][i][0];
								front [i] = aux [2][i][0];
								back [i] = aux [3][i][ultimo];
							}
							
							//obtengo la cara left
							for(int j=0; j<longitud; j++) {
								for(int k=0;k<longitud; k++) {
									left[j][k] = aux[4][j][k];
								}
							}
							
							//cambiamos los numeros en las caras del cubo
							
							for(int i=0; i<longitud;i++){
								aux [0][i][0] = front[i]; //En UP meto lo de FRONT
								aux [1][i][0] = back[i]; //En DOWN meto lo de BACK
								aux [2][i][0] = down[i]; //En FRONT meto lo de DOWN
								aux [3][i][ultimo] = up[i]; //En BACK meto lo de UP
							}
							
							//
							int k=longitud-1;
							System.out.println("El valor de K es: "+k);
							for(int i=0; i<longitud; i++) {
								for(int j=0;j<longitud; j++) {
									aux[4][i][j] = left[j][k];
								}
								k--;
							}
			
		}else if (n == longitud-1) { //es longitud menos 1 porque el cuadrado empieza a contar en 0
			//giro la parte con right
			
			System.out.println("Me estoy metiendo en el bucle del right");
			
							for(int i=0; i<longitud;i++){ //son las 4 caras que siempre cambiaran en un L
								up [i] = aux [0][i][n];
								down[i] = aux [1][i][n];
								front [i] = aux [2][i][n];
								back [i] = aux [3][i][0];
							}
							
							//obtengo la cara right
							for(int j=0; j<longitud; j++) {
								for(int k=0;k<longitud; k++) {
									right[j][k] = aux[5][j][k];
								}
							}
							
							//cambiamos los numeros en las caras del cubo
							
							for(int i=0; i<longitud;i++){
								aux [0][i][n] = front[i]; //En UP meto lo de FRONT
								aux [1][i][n] = back[i]; //En DOWN meto lo de BACK
								aux [2][i][n] = down[i]; //En FRONT meto lo de DOWN
								aux [3][i][0] = up[i]; //En BACK meto lo de UP
							}
							//GIRO DE -90 grados, cara contraria
							int k;
							for(int i=0; i<longitud; i++) {
								k=longitud-1;
								for(int j=0;j<longitud; j++) {
									aux[5][i][j] = right[k][i];
									k--;
								}
							}
							
		}else {//imprimo el giro interior
			System.out.println("Me estoy metiendo en el bucle central");
			for(int i=0; i<longitud;i++){ //son las 4 caras que tengo que obtener
				up [i] = aux [0][i][n];
				down[i] = aux [1][i][n];
				front [i] = aux [2][i][n];
				back [i] = aux [3][i][n];
			}
			
			//giro las caras
			for(int i=0; i<longitud;i++){
				aux [0][i][n] = front[i]; //En UP meto lo de FRONT
				aux [1][i][n] = back[i]; //En DOWN meto lo de BACK
				aux [2][i][n] = down[i]; //En FRONT meto lo de DOWN
				aux [3][i][n] = up[i]; //En BACK meto lo de UP
			}
			
			
		}
		
		
		
	}else {
		System.out.println("El giro no es posible, elija otra fila");
	}
	
	
	
	System.out.println("El cubo DESPUES del giro");
	Auxiliar.imprimir(aux);//impresion del cubo antes del giro
	
	cubo.setPosiciones(aux);
	return cubo;
}


public static Cubo giroD (Cubo cubo, int n) {

	int [][][] aux = cubo.getPosiciones();
	
	int longitud = aux[0].length; // variable para saber la longitud del cubo
	int m= longitud-1; //total -1 por tanto pilla la linea de abajo
	
	System.out.println("El cubo antes del giro");
	Auxiliar.imprimir(aux);//impresion del cubo antes del giro
	
	// variable para guardar la filas y caras
	int [] right = new int [longitud]; 
	int [] left =  new int [longitud];
	int [] front =  new int [longitud];
	int [] back = new int [longitud];
	int [][] down = new int [longitud][longitud];
	int [][] up = new int [longitud][longitud];
	
	System.out.println(" El n es: "+n+" La Logitud es: "+ longitud);
	
	if( n >= 0 && n < longitud) {
		
		
			
		if (n == 0) { // PRIMERO GIRO DOWN: EMPIEZA DESDE ABAJO HACIA ARRIBA
			
			System.out.println("Me estoy metiendo en el bucle del DOWN");
			
							for(int i=0; i<longitud;i++){ //son las 4 caras que siempre cambiaran en un L
								right [i] = aux [5][m][i];
								left[i] = aux [4][m][i];
								front [i] = aux [2][m][i];
								back [i] = aux [3][m][i];
							}
							
							//obtengo la cara right
							for(int j=0; j<longitud; j++) {
								for(int k=0;k<longitud; k++) {
									down[j][k] = aux[1][j][k];
								}
							}
							
							//cambiamos los numeros en las caras del cubo
							
							for(int i=0; i<longitud;i++){
								aux [2][m][i] = right[i]; //En FRONT meto lo de RIGHT
								aux [3][m][i] = left[i]; //En BACK meto lo de LEFT
								aux [4][m][i] = front[i]; //En LEFT lo de FRONT
								aux [5][m][i] = back[i]; //En RIGHT lo de BACK
							}
							
							//-90 grados giro
							int k=longitud-1;
							for(int i=0; i<longitud; i++) {
								for(int j=0;j<longitud; j++) {
									aux[1][i][j] = down[j][k];
								}
								k--;
							}
		}else if(n == longitud-1) {//giro la parte down
			System.out.println("Me estoy metiendo en el giro UP");
			for(int i=0; i<longitud;i++){ //son las 4 caras que giran
				front [i] = aux [2][0][i];
				back [i] = aux [3][0][i];
				left[i] = aux [4][0][i];
				right [i] = aux [5][0][i];
			}
			
			//obtengo la cara up
			for(int j=0; j<longitud; j++) {
				for(int k=0;k<longitud; k++) {
					up[j][k] = aux[0][j][k];
				}
			}
			
			//cambiamos los numeros en las caras del cubo
			
			for(int i=0; i<longitud;i++){
				
				aux [2][0][i] = right[i]; //En FRONT meto lo de RIGHT
				aux [3][0][i] = left[i]; //En BACK meto lo de LEFT
				aux [4][0][i] = front[i]; //En LEFT lo de FRONT
				aux [5][0][i] = back[i]; //En RIGHT lo de BACK
			}
			
			
			int k;
			for(int i=0; i<longitud; i++) {
				k=longitud-1;
				for(int j=0;j<longitud; j++) {
					aux[0][i][j] = up[k][i];
					k--;
				}
			}
			
			}else{//imprimo el giro interior
			System.out.println("Me estoy metiendo en el bucle central");
			for(int i=0; i<longitud;i++){ //son las 4 caras que tengo que obtener
				right [i] = aux [5][n][i];
				left[i] = aux [4][n][i];
				front [i] = aux [2][n][i];
				back [i] = aux [3][n][i];
			}
			
			//giro las caras
			for(int i=0; i<longitud;i++){

				aux [2][n][i] = right[i]; //En FRONT meto lo de RIGHT
				aux [3][n][i] = left[i]; //En BACK meto lo de LEFT
				aux [4][n][i] = front[i]; //En LEFT lo de FRONT
				aux [5][n][i] = back[i]; //En RIGHT lo de BACK
			}
		}
		
	}else {
		System.out.println("El giro no es posible, elija otra fila");
	}
	
	System.out.println("El cubo DESPUES del giro");
	Auxiliar.imprimir(aux);//impresion del cubo antes del giro
	cubo.setPosiciones(aux);
	return cubo;
}

public static Cubo girod (Cubo cubo, int n) {

	int [][][] aux = cubo.getPosiciones();
	
	int longitud = aux[0].length; // variable para saber la longitud del cubo
	int m= longitud-1; //total -1 por tanto pilla la linea de abajo
	
	System.out.println("El cubo antes del giro");
	Auxiliar.imprimir(aux);//impresion del cubo antes del giro
	
	// variable para guardar la filas y caras
	int [] right = new int [longitud]; 
	int [] left =  new int [longitud];
	int [] front =  new int [longitud];
	int [] back = new int [longitud];
	int [][] down = new int [longitud][longitud];
	int [][] up = new int [longitud][longitud];
	
	System.out.println(" El n es: "+n+" La Logitud es: "+ longitud);
	
	if( n >= 0 && n < longitud) {
		
			
		if (n == 0) { // PRIMERO GIRO DOWN: EMPIEZA DESDE ABAJO HACIA ARRIBA
			
			System.out.println("Me estoy metiendo en el bucle del DOWN");
			
							for(int i=0; i<longitud;i++){ //son las 4 caras que siempre cambiaran en un L
								right [i] = aux [5][m][i];
								left[i] = aux [4][m][i];
								front [i] = aux [2][m][i];
								back [i] = aux [3][m][i];
							}
							
							//obtengo la cara right
							for(int j=0; j<longitud; j++) {
								for(int k=0;k<longitud; k++) {
									down[j][k] = aux[1][j][k];
								}
							}
							
							//cambiamos los numeros en las caras del cubo
							
							for(int i=0; i<longitud;i++){
								aux [2][m][i] = left[i]; //En FRONT meto lo de LEFT
								aux [3][m][i] = right[i]; //En BACK meto lo de RIGHT
								aux [4][m][i] = back[i]; //En LEFT lo de BACK
								aux [5][m][i] = front[i]; //En RIGHT lo de FRONT
							}
							
							//-90 grados giro
							int k;
							for(int i=0; i<longitud; i++) {
								k=longitud-1;
								for(int j=0;j<longitud; j++) {
									aux[1][i][j] = down[k][i];
									k--;
								}
							}
		}else if(n == longitud-1) {//giro la parte down
			System.out.println("Me estoy metiendo en el giro UP");
			for(int i=0; i<longitud;i++){ //son las 4 caras que giran
				front [i] = aux [2][0][i];
				back [i] = aux [3][0][i];
				left[i] = aux [4][0][i];
				right [i] = aux [5][0][i];
			}
			
			//obtengo la cara up
			for(int j=0; j<longitud; j++) {
				for(int k=0;k<longitud; k++) {
					up[j][k] = aux[0][j][k];
				}
			}
			
			//cambiamos los numeros en las caras del cubo
			
			for(int i=0; i<longitud;i++){
				
				aux [2][0][i] = left[i]; //En FRONT meto lo de LEFT
				aux [3][0][i] = right[i]; //En BACK meto lo de RIGHT
				aux [4][0][i] = back[i]; //En LEFT lo de BACK
				aux [5][0][i] = front[i]; //En RIGHT lo de FRONT
			}
			
			//giro -90 grados
			int k=longitud-1;;
			for(int i=0; i<longitud; i++) {
				for(int j=0;j<longitud; j++) {
					aux[0][i][j] = up[j][k];
				}
				k--;
			}
			
			}else{//imprimo el giro interior
			System.out.println("Me estoy metiendo en el bucle central");
			for(int i=0; i<longitud;i++){ //son las 4 caras que tengo que obtener
				right [i] = aux [5][n][i];
				left[i] = aux [4][n][i];
				front [i] = aux [2][n][i];
				back [i] = aux [3][n][i];
			}
			
			//giro las caras
			for(int i=0; i<longitud;i++){

				aux [2][n][i] = left[i]; //En FRONT meto lo de LEFT
				aux [3][n][i] = right[i]; //En BACK meto lo de RIGHT
				aux [4][n][i] = back[i]; //En LEFT lo de BACK
				aux [5][n][i] = front[i]; //En RIGHT lo de FRONT
			}
		}
		
	}else {
		System.out.println("El giro no es posible, elija otra fila");
	}
	
	System.out.println("El cubo DESPUES del giro");
	Auxiliar.imprimir(aux);//impresion del cubo antes del giro
	cubo.setPosiciones(aux);
	return cubo;
}


public static Cubo giroB (Cubo cubo, int n) {
	
	int [][][] aux = cubo.getPosiciones();
	
	// variable para saber la longitud del cubo
	int longitud = aux[0].length;
	
	System.out.println("El cubo antes del giro");
	Auxiliar.imprimir(aux);//impresion del cubo antes del giro
	
	int m=longitud-1;
	
	//primero giro L0 (izquierda del front, giro completo de cara LEFT)
	
	// variable para guardar la filas y caras
	int [] up = new int [longitud]; 
	int [] down =  new int [longitud];
	int [] left =  new int [longitud];
	int [] right = new int [longitud];
	int [][] back = new int [longitud][longitud];
	int [][] front = new int [longitud][longitud];
	
	System.out.println(" El n es: "+n+" La Logitud es: "+ longitud);
	
	
	
	/*System.out.println("Lo que cojo del cubo");
	for(int g=0;g<longitud;g++){
		System.out.print(up[g]);
		System.out.print(down[g]);
		System.out.print(front[g]);
		System.out.print(back[g]);
		System.out.println("");
	}*/
	
	if( n >= 0 && n < longitud) {
		
		if(n == 0) {//giro la parte left
			System.out.println("Me estoy metiendo en el bucle n==0");
							for(int i=0; i<longitud;i++){ //son las 4 caras que giran
								up [i] = aux [0][0][i]; 
								down[i] = aux [1][m][i]; //fila arriba
								left [i] = aux [4][i][0]; // columna izquierda
								right [i] = aux [5][i][m]; //columna derecha
							}
							
							
							
							//obtengo la cara back
							for(int j=0; j<longitud; j++) {
								for(int k=0;k<longitud; k++) {
									back[j][k] = aux[3][j][k];
								}
							}
							
							//cambiamos los numeros en las caras del cubo
							
							for(int i=0; i<longitud;i++){
								aux [0][0][i] = right[i]; //En UP meto lo de RIGHT
								aux [1][m][i] = left[i]; //En DOWN meto lo de LEFT
								aux [4][i][0] = up[i]; //En LEFT meto el UP
								aux [5][i][m] = down[i]; //En RIGHT meto DOWN
							}
							
							int k;
							for(int i=0; i<longitud; i++) {
								k=longitud-1;
								for(int j=0;j<longitud; j++) {
									aux[3][i][j] = back[k][i];
									k--;
								}
							}
			
			
		}else if (n == longitud-1) { //es longitud menos 1 porque el cuadrado empieza a contar en 0
			//giro la parte con right
			
			System.out.println("Me estoy metiendo en el bucle del FRONT");
			
							for(int i=0; i<longitud;i++){ //son las 4 caras que siempre cambiaran en un L
								up [i] = aux [0][m][i]; 
								down[i] = aux [1][0][i]; //fila arriba
								left [i] = aux [4][i][m]; // columna izquierda
								right [i] = aux [5][i][0]; //columna derecha
							}
							
							/*System.out.println("Lo que cojo del cubo");
							for(int g=0;g<longitud;g++){
								System.out.print(up[g]);
								System.out.print(down[g]);
								System.out.print(left[g]);
								System.out.print(right[g]);
								System.out.println("");
							}*/
							
							//obtengo la cara right
							for(int j=0; j<longitud; j++) {
								for(int k=0;k<longitud; k++) {
									front[j][k] = aux[2][j][k];
								}
							}
							
							//cambiamos los numeros en las caras del cub
							for(int i=0; i<longitud;i++){
								aux [0][m][i] = right[i]; //En UP meto lo de RIGHT
								aux [1][0][i] = left[i]; //En DOWN meto lo de LEFT
								aux [4][i][m] = up[i]; //En LEFT meto el UP
								aux [5][i][0] = down[i]; //En RIGHT meto DOWN
							}
							
							int k=longitud-1;
							for(int i=0; i<longitud; i++) {
								for(int j=0;j<longitud; j++) {
									aux[2][i][j] = front[j][k];
								}
								k--;
							}
							
							
		}else {//imprimo el giro interior
			System.out.println("Me estoy metiendo en el bucle central");
			for(int i=0; i<longitud;i++){ //son las 4 caras que tengo que obtener
				up [i] = aux [0][n][i]; 
				down[i] = aux [1][n][i]; //fila arriba
				left [i] = aux [4][i][n]; // columna izquierda
				right [i] = aux [5][i][n]; //columna derecha
			}
			
			//giro las caras
			for(int i=0; i<longitud;i++){
				aux [0][n][i] = right[i]; //En UP meto lo de RIGHT
				aux [1][n][i] = left[i]; //En DOWN meto lo de LEFT
				aux [4][i][n] = up[i]; //En LEFT meto el UP
				aux [5][i][n] = down[i]; //En RIGHT meto DOWN
			}
			
		}
		
		
		
	} else {
		System.out.println("El giro no es posible, elija otra fila");
	}
	
	System.out.println("El cubo DESPUES del giro");
	Auxiliar.imprimir(aux);//impresion del cubo antes del giro
	
	cubo.setPosiciones(aux);
	return cubo;
	

}


public static Cubo girob (Cubo cubo, int n) {
	
	int [][][] aux = cubo.getPosiciones();
	
	// variable para saber la longitud del cubo
	int longitud = aux[0].length;
	
	System.out.println("El cubo antes del giro");
	Auxiliar.imprimir(aux);//impresion del cubo antes del giro
	
	int m=longitud-1;
	
	//primero giro L0 (izquierda del front, giro completo de cara LEFT)
	
	// variable para guardar la filas y caras
	int [] up = new int [longitud]; 
	int [] down =  new int [longitud];
	int [] left =  new int [longitud];
	int [] right = new int [longitud];
	int [][] back = new int [longitud][longitud];
	int [][] front = new int [longitud][longitud];
	
	System.out.println(" El n es: "+n+" La Logitud es: "+ longitud);
	
	
	
	/*System.out.println("Lo que cojo del cubo");
	for(int g=0;g<longitud;g++){
		System.out.print(up[g]);
		System.out.print(down[g]);
		System.out.print(front[g]);
		System.out.print(back[g]);
		System.out.println("");
	}*/
	
	if( n >= 0 && n < longitud) {
		
		if(n == 0) {//giro la parte left
			System.out.println("Me estoy metiendo en el bucle n==0");
							for(int i=0; i<longitud;i++){ //son las 4 caras que giran
								up [i] = aux [0][0][i]; 
								down[i] = aux [1][m][i]; //fila arriba
								left [i] = aux [4][i][0]; // columna izquierda
								right [i] = aux [5][i][m]; //columna derecha
							}
							
							//obtengo la cara back
							for(int j=0; j<longitud; j++) {
								for(int k=0;k<longitud; k++) {
									back[j][k] = aux[3][j][k];
								}
							}
							
							//cambiamos los numeros en las caras del cubo
							
							for(int i=0; i<longitud;i++){
								aux [0][0][i] = left[i]; //En UP meto el LEFT
								aux [1][m][i] = right[i]; //En DOWN meto el RIGHT
								aux [4][i][0] = down[i]; //En LEFT meto el DOWN
								aux [5][i][m] = up[i]; //En RIGHT meto UP
							}
							
							//-90
							int k=longitud-1;
							for(int i=0; i<longitud; i++) {
								for(int j=0;j<longitud; j++) {
									aux[3][i][j] = back[j][k];
								}
								k--;
							}
			
			
		}else if (n == longitud-1) { //es longitud menos 1 porque el cuadrado empieza a contar en 0
			//giro la parte con right
			
			System.out.println("Me estoy metiendo en el bucle del right");
			
							for(int i=0; i<longitud;i++){ //son las 4 caras que siempre cambiaran en un L
								up [i] = aux [0][m][i]; 
								down[i] = aux [1][0][i]; //fila arriba
								left [i] = aux [4][i][m]; // columna izquierda
								right [i] = aux [5][i][0]; //columna derecha
							}
							
							//obtengo la cara right
							for(int j=0; j<longitud; j++) {
								for(int k=0;k<longitud; k++) {
									front[j][k] = aux[2][j][k];
								}
							}
							
							//cambiamos los numeros en las caras del cubo
							
							for(int i=0; i<longitud;i++){
								aux [0][m][i] = left[i]; //En UP meto el LEFT
								aux [1][0][i] = right[i]; //En DOWN meto el RIGHT
								aux [4][i][m] = down[i]; //En LEFT meto el DOWN
								aux [5][i][0] = up[i]; //En RIGHT meto UP
							}
							
							//90 grados
							int k;
							for(int i=0; i<longitud; i++) {
								k=longitud-1;
								for(int j=0;j<longitud; j++) {
									aux[2][i][j] = front[k][i];
									k--;
								}
							}
							
							
		}else {//imprimo el giro interior
			System.out.println("Me estoy metiendo en el bucle central");
			for(int i=0; i<longitud;i++){ //son las 4 caras que tengo que obtener
				up [i] = aux [0][n][i]; 
				down[i] = aux [1][n][i]; //fila arriba
				left [i] = aux [4][i][longitud-n]; // columna izquierda
				right [i] = aux [5][i][longitud-n]; //columna derecha
			}
			
			//giro las caras
			for(int i=0; i<longitud;i++){
				aux [0][n][i] = left[i]; //En UP meto el LEFT
				aux [1][n][i] = right[i]; //En DOWN meto el RIGHT
				aux [4][i][longitud-n] = down[i]; //En LEFT meto el DOWN
				aux [5][i][longitud-n] = up[i]; //En RIGHT meto UP
			}
		}
		
		
		
	} else {
		System.out.println("El giro no es posible, elija otra fila");
	}
	
	System.out.println("El cubo DESPUES del giro");
	Auxiliar.imprimir(aux);//impresion del cubo antes del giro
	
	cubo.setPosiciones(aux);
	return cubo;
	

}
}//clase

