import java.io.*;
import java.util.*;

public class Algoritmo {

	private static int idN = 0;
	private static final String ANCHURA = "ANCHURA";
	private static final String PROFUNDIDAD = "PROFUNDIDAD";
	private static final String COSTO_UNIFORME = "COSTO UNIFORME";

	public static boolean busqueda(Problema problema, String estrategia, int profMax, int incProf) throws IOException {
		long profActual = incProf;
		boolean esSolucion = false;
		while (!esSolucion && profActual <= profMax) {
			esSolucion = busqueda_acotada(problema, estrategia, profMax);
			profActual = profActual + incProf;
		}

		return esSolucion;
	}

	private static boolean busqueda_acotada(Problema problema, String estrategia, int profMax) throws IOException { // en
																													// anchura
		boolean solucion = false;
		Cubo c = new Cubo();
		c.setPosiciones(problema.getPos());
		c.setEstado(Estado.obtenerID(c));
		Nodo[] lista_nodos;
		String[][] lista_sucesores;
		Frontera frontera = new FronteraLista();
		frontera.crearFrontera();
		Nodo nodo_actual = null;
		Nodo nodo_inicial = new Nodo(null, c, "", 0, 0, 0, 0); // nodo padre, estado, accion, coste, profundidad, id
		frontera.insertarNodo(nodo_inicial);

		while (!solucion && !frontera.estaVacia()) {
			nodo_actual = frontera.eliminarNodo();
			/*
			 * if (Problema.esObjetivo(nodo_actual)) { solucion = true; }
			 */
			solucion = Problema.esObjetivo(nodo_actual);
			if (solucion) {
				System.out.print("Lo tenemos");
			} else {
				lista_sucesores = Estado.sucesores(nodo_actual.getEstado());
				lista_nodos = CrearListaNodos(lista_sucesores, nodo_actual, profMax, estrategia);
				for (int i = 0; i < lista_nodos.length; i++)
					frontera.insertarNodo(lista_nodos[i]);
			}
		}
		if (solucion) {
			System.out.println("Creamos la solucion");
			CrearSolucion(nodo_actual); // aqui dudo de si tengo que imprimir, devolver true, crear el archivo dentro
										// del metodo...
		} else {
			System.out.println("No la hemos encontrado");
			// solucion = false;
		}

		return solucion;

	}// fin busqueda acotada

	public static Nodo[] CrearListaNodos(String[][] lista_sucesores, Nodo nodo_actual, int pmaxima, String estrategia)
			throws IOException {

		Nodo[] lista = new Nodo[lista_sucesores.length];
		Nodo nodo = null;
		double valor = 0;
		int id = nodo_actual.getId();
		System.out.println("Creo la lista nodos del nodo con ID " + id);
		System.out.println("Profundidad: " + nodo_actual.getD());
		for (int i = 0; i < lista_sucesores.length; i++) { // recorremos las filas de los sucesores
			switch (estrategia) {
			case ANCHURA:
				valor = nodo_actual.getD() + 1;
				break;
			case PROFUNDIDAD:
				valor = (-1) * (nodo.getD() + 1);
				break;
			case COSTO_UNIFORME:
				valor = nodo_actual.getCosto() + Double.parseDouble(lista_sucesores[i][2]);
			}

			idN = idN + 1; //Actualizamos el id de cada nodo
			nodo = new Nodo(nodo_actual, Estado.obtenerCubo(lista_sucesores[i][1]), lista_sucesores[i][0],
					Double.parseDouble(lista_sucesores[i][2]) + nodo_actual.getCosto(), nodo_actual.getD() + 1, idN,
					valor);
			if (nodo.getD() <= pmaxima) {
				lista[i] = nodo;
			}
			System.out.println("Id: " + nodo.getId());

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

			if (nodo_actual.getId() == 0 && nodo_actual.getPadre() == null) {
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
				pw.println("[" + n.getId() + "]([" + n.getAccion() + "]" + md + "," + n.getCosto() + "," + n.getId()
						+ "," + n.getF() + "))");
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
