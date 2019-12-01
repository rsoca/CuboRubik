import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException{
		
		Problema problema = new Problema();
		Scanner leer = new Scanner (System.in);
		int profundidad=0;
		int incprof= 1;
		boolean salida = false; 
		do {
			System.out.println("Introduzca el numero de una opcion: "
					+ "\n 1. Estrategia A*"
					+ "\n 2. Estrategia ANCHURA"
					+ "\n 3. Estrategia PROFUNDIDAD"
					+ "\n 4. Estrategia COSTE UNIFORME"
					+ "\n 5. Estrategia VORAZ"
					+ "\n 6. SALIR");
			int eleccion= leer.nextInt();
			if(eleccion >= 1 && eleccion <=5) {
			System.out.println("Introduzca la profundidad acotada:");
			profundidad= leer.nextInt();
			}
			
			switch(eleccion) {
			case 1:
				Algoritmo.busqueda(problema, "A", profundidad, incprof);
				break;
			case 2:
				Algoritmo.busqueda(problema, "ANCHURA", profundidad, incprof);
				break;
			case 3:
				Algoritmo.busqueda(problema, "PROFUNDIDAD", profundidad, incprof);
				break;
			case 4:Algoritmo.busqueda(problema, "COSTO_UNIFORME", profundidad, incprof);
				break;
			case 5:
				Algoritmo.busqueda(problema, "VORAZ", profundidad, incprof);
				break;
			case 6:
				System.out.println("FINALIZANDO LA APLICACION. ADIOS");
				salida = true;
				break;
			default:
				System.out.println("ELECCION INCORRECTA!!\n");
			break;
			}
		}while(salida==false);
		
		leer.close();
		}
		
	
}