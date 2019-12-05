import java.io.*;
import java.util.*;

public class Main {
	static Scanner leer = new Scanner(System.in);

	public static void main(String[] args) throws IOException {
		Problema problema = new Problema();
		int incProf = 1;
		int profundidad = 0;
		boolean salida = false;
		boolean poda = true;
		do {
			int eleccion = recogerEleccion();
			if (eleccion >= 1 && eleccion <= 6) {
				profundidad = recogerProfundidad();
				if (eleccion == 3) {
					System.out.println("Elija un incremento de profundidad");
					incProf = leer.nextInt();
				}
				poda = recogidaPoda();
			}

			switch (eleccion) {
			case 1:
				Algoritmo.busqueda(problema, "A*", profundidad, incProf, poda);
				break;
			case 2:
				Algoritmo.busqueda(problema, "ANCHURA", profundidad, incProf, poda);
				break;
			case 3:
				Algoritmo.busqueda(problema, "PROFUNDIDAD_ITERATIVA", profundidad, incProf, poda);
				break;
			case 4:
				Algoritmo.busqueda(problema, "PROFUNDIDAD_ACOTADA", profundidad, incProf, poda);
				break;
			case 5:
				Algoritmo.busqueda(problema, "COSTO_UNIFORME", profundidad, incProf, poda);
				break;
			case 6:
				Algoritmo.busqueda(problema, "VORAZ", profundidad, incProf, poda);
				break;
			case 7:
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

	private static boolean recogidaPoda() {
		char respuesta = 0;
		boolean poda = true;
		boolean correcto = false;
		while (!correcto) {
			System.out.println("¿Quieres poder podar los nodos del árbol? (S/N):\n");
			respuesta = leer.next().toUpperCase().charAt(0);
			if (respuesta != 'S' && respuesta != 'N') {
				System.out.println("Tiene que ser Si o No\n");
				correcto = false;
			} else
				correcto = true;

		}
		if (respuesta == 'N') {
			poda = false;
		}
		return poda;
	}

	private static int recogerProfundidad() {
		boolean correcto = false;
		int profundidad = 0;
		System.out.println("Introduzca la profundidad maxima:");
		while (!correcto) {
			try {
				profundidad = leer.nextInt();
				correcto = true;
			} catch (InputMismatchException e) {
				System.out.println("El valor introducido tiene que ser un número. Prueba otra vez.\n");
				leer.nextLine();
			}

		}
		return profundidad;
	}

	private static int recogerEleccion() {
		boolean correcto = false;
		int eleccion = 0;
		System.out.println("Introduzca el numero de una opcion: " + "\n 1. Estrategia A*" + "\n 2. Estrategia ANCHURA"
				+ "\n 3. Estrategia PROFUNDIDAD ITERATIVA" + "\n 4. Estrategia PROFUNDIDAD ACOTADA"
				+ "\n 5. Estrategia COSTE UNIFORME" + "\n 6. Estrategia VORAZ" + "\n 7. SALIR");
		while (!correcto) {
			try {
				eleccion = leer.nextInt();
				correcto = true;
			} catch (InputMismatchException e) {
				System.out.println("El valor introducido tiene que ser un número. Prueba otra vez.\n");
				leer.nextLine();
			}

		}

		return eleccion;
	}

}