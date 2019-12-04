import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {

		Problema problema = new Problema();
		Scanner leer = new Scanner(System.in);
		int profundidad = 0;
		int incProf = 1;
		boolean salida = false;
		char respuesta;
		boolean poda = true;
		do {
			System.out.println("Introduzca el numero de una opcion: " + "\n 1. Estrategia A*"
					+ "\n 2. Estrategia ANCHURA" + "\n 3. Estrategia PROFUNDIDAD SIMPLE"
					+ "\n 4. Estrategia PROFUNDIDAD ITERATIVA" + "\n 5. Estrategia PROFUNDIDAD ACOTADA"
					+ "\n 6. Estrategia COSTE UNIFORME" + "\n 7. Estrategia VORAZ" + "\n 8. SALIR");
			int eleccion = leer.nextInt();
			if (eleccion >= 1 && eleccion <= 7) {
				System.out.println("Introduzca la profundidad acotada:");
				profundidad = leer.nextInt();
				if (eleccion == 4) {
					System.out.println("Elija un incremento de profundidad");
					incProf = leer.nextInt();
				}
				do {
					System.out.println("¿Quieres poder podar los nodos del árbol? (S/N):");
					respuesta = leer.next().toUpperCase().charAt(0);
				} while (respuesta != 'S' && respuesta != 'N');

				if (respuesta == 'N') {
					poda = false;
				}
			}

			switch (eleccion) {
			case 1:
				Algoritmo.busqueda(problema, "A", profundidad, incProf, poda);
				break;
			case 2:
				Algoritmo.busqueda(problema, "ANCHURA", profundidad, incProf, poda);
				break;
			case 3:
				Algoritmo.busqueda(problema, "PROFUNDIDAD_SIMPLE", profundidad, incProf, poda);
				break;
			case 4:
				Algoritmo.busqueda(problema, "PROFUNDIDAD_ITERATIVA", profundidad, incProf, poda);
				break;
			case 5:
				Algoritmo.busqueda(problema, "PROFUNDIDAD_ACOTADA", profundidad, incProf, poda);
				break;
			case 6:
				Algoritmo.busqueda(problema, "COSTO_UNIFORME", profundidad, incProf, poda);
				break;
			case 7:
				Algoritmo.busqueda(problema, "VORAZ", profundidad, incProf, poda);
				break;
			case 8:
				System.out.println("APLICACIÓN FINALIZADA");
				salida = true;
				break;
			default:
				System.out.println("ELECCION INCORRECTA!!\n");
				break;
			}
		} while (salida == false);

		leer.close();
	}

}