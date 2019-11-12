import java.io.*;
import java.util.*;

public class Algoritmo {

	public static boolean busqueda_acotada(int[][][] problema, String estrategia, int pmaxima) throws IOException { // en anchura
		boolean solucion = false;
		Cubo c = new Cubo();
		Nodo[] lista_nodos;
		String[][] lista_sucesores;
		Frontera frontera = new FronteraPrioridad();
		frontera.crearFrontera();
		Nodo padre = null; // consultar porque me parece raro crearlo
		Nodo nodo_actual = null;
		Nodo nodo_inicial = new Nodo(padre, c, "", 0, 0, 0); // nodo padre, estado, accion, coste, profundidad, id
		frontera.insertarNodo(nodo_inicial);

		while (!solucion  && !frontera.estaVacia()) {
			nodo_actual = seleccionarNodo(frontera);
			if (Problema.esObjetivo(nodo_actual)) {
				solucion = true;
			} else {
				lista_sucesores = Estado.sucesores(nodo_actual.getEstado());
				lista_nodos = CrearListaNodos(lista_sucesores, nodo_actual, pmaxima, estrategia);
				for(int i=0; i<lista_nodos.length; i++)
					frontera.insertarNodo(lista_nodos[i]);
			} // fin if-else
		} // fin while

		if (solucion) {
			System.out.println("Entro a la solucion");
			CrearSolucion(nodo_actual); // aqui dudo de si tengo que imprimir, devolver true, crear el archivo dentro del metodo...
		} else {
			solucion = false;
		}

		return solucion;

	}// fin busqueda acotada

	public static Nodo seleccionarNodo(Frontera frontera) {
		Nodo nodo = null;
		Queue<Nodo> f = frontera.getFrontera();
		nodo = f.poll();
		System.out.println("Cojo el nodo de la frontera con id: " + nodo.getID());
		return nodo;
	}

	public static Nodo[] CrearListaNodos(String[][] lista_sucesores, Nodo nodo_actual, int pmaxima, String estrategia)
			throws IOException {

		// Esto es en anchura, por tanto la f es igual a la profundidad
		// Tenemos tambien la limitacion de la pmaxima a la hora de crear los nodos

		Nodo[] lista = new Nodo[lista_sucesores.length];// creamos la lista de los nodos que tendra la longitud del numero de filas
		Nodo nodo = null;
		Cubo cubo = null; // tiene dentro la matriz de posiciones crear los nodos y meterlos en lista
		double coste = 0;
		int d; // profundidad
		int id = nodo_actual.getD();
		System.out.println("Creo la lista nodos del nodo con ID " + id);
		
		if (nodo_actual.getD() < pmaxima) {
			for (int i = 0; i < lista_sucesores.length; i++) { // recorremos las filas de los sucesores
				coste = Double.parseDouble(lista_sucesores[i][2]) + nodo_actual.getCosto();
				d = nodo_actual.getD() + 1;
				cubo = Estado.obtenerCubo(lista_sucesores[i][1]);
				nodo = new Nodo(nodo_actual, cubo, lista_sucesores[i][0], coste, d, id);
				lista[i] = nodo;
			}
		} else {
			System.out.println("No se pueden hacer mas nodos");
		}

		return lista;
	}

	public static void CrearSolucion(Nodo nodo_actual) throws IOException { // importar siempre el java.io

		Stack<Nodo> pila = new Stack<Nodo>(); // creamos la pila donde iran entrando los nodos
		boolean primero = false;
		pila.push(nodo_actual); // meto el nodo de la solucion

		while (nodo_actual.getPadre() != null && primero == false) {

			pila.push(nodo_actual.getPadre()); // meto el nodo padre del actual
			nodo_actual = nodo_actual.getPadre(); // convierto al padre en nodo actual

			if (nodo_actual.getID() == 0 && nodo_actual.getPadre() == null) {
				// compruebo si el nodo actual tiene ID=0, porque seria el primero, el del
				// inicio
				// y que no tiene padre

				primero = true; // he encontrado el primero nodo de todo el arbol
				pila.push(nodo_actual); // meto ese nodo en la pila y me salgo del while
			}
		}

		// ya tenemos la pila llena, ahora ir sacando y metiendo en el archivo de texto
		// convertir el cubo a MD5 y guardarlo asi

		// LIMPIAMOS EL ANTERIOR ARCHIVO POR SI HUBIERAN DATOS

		BufferedWriter bw = new BufferedWriter(new FileWriter("solucion.txt"));
		bw.write("");
		bw.close();

		// Formato de guardado de los datos en el archivo
		// Prepresentaci�n del nodo del �rbol: [ID_Nodo]([accion]
		// ID_ESTADO,costo,profundidad,valor del nodo (f))
		// La profundidad es el valor d

		Nodo n = null;
		FileWriter fichero = null;
		PrintWriter pw = null;
		try {
			fichero = new FileWriter("solucion.txt");
			pw = new PrintWriter(fichero);

			while (!pila.empty()) {
				n = pila.pop();
				String md = Estado.getMD5(Estado.obtenerID(n.getEstado()));
				pw.println("[" + n.getID() + "]([" + n.getAccion() + "]" + md + "," + n.getCosto() + "," + n.getD()
						+ "," + n.getF() + "))");
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
