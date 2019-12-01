import java.io.*;
import java.util.*;

public class Algoritmo {

	private static int idN = 0;
	private static final String ANCHURA = "ANCHURA";
	private static final String PROFUNDIDAD = "PROFUNDIDAD";
	private static final String COSTO_UNIFORME = "COSTO_UNIFORME";
	private static final String A = "A";
	private static final String VORAZ = "VORAZ";

	public static void busqueda(Problema problema, String estrategia, int profMax, int incProf) throws IOException {
		long profActual = incProf;
		boolean esSolucion = false;
		while (esSolucion==false && profActual <= profMax) {
			esSolucion = busqueda_acotada(problema, estrategia, profMax);
			profActual = profActual + incProf;
		}
	}

	public static boolean busqueda_acotada(Problema problema, String estrategia, int profMax) throws IOException { // en
																													// anchura
		
		Cubo c = new Cubo();
		c.setPosiciones(problema.getPos());
		c.setEstado(Estado.obtenerID(c));
		List<Nodo> lista_nodos;
		String[][] lista_sucesores;
		Frontera frontera = new FronteraPrioridad();
		frontera.crearFrontera();
		Nodo nodo_actual = null;
		
		double h = calcularEntropia(c);
		double valorf=0.0;
		Nodo nodo_inicial = null ;//nodo padre, estado, accion, coste, profundidad, id, heuristica
		
		switch(estrategia) {
		case ANCHURA:
			nodo_inicial = new Nodo(null, c, "", 0, 0, 0, 0, h);
			break;
		case PROFUNDIDAD:
			nodo_inicial = new Nodo(null, c, "", 0, 0, 0, 1.0, h);
			break;
		case COSTO_UNIFORME:
			nodo_inicial = new Nodo(null, c, "", 0, 0, 0, 0, h);
			break;
		case A:
			nodo_inicial = new Nodo(null, c, "", 0, 0, 0, h, h);
			break;
		case VORAZ:
			valorf = h;
			nodo_inicial = new Nodo(null, c, "", 0, 0, 0, valorf, h);
			break;
			
		}
		frontera.insertarNodo(nodo_inicial, estrategia);
		boolean solucion = false;
		while (frontera.estaVacia()==false && solucion==false ) {
			nodo_actual = frontera.sacarNodo();
			frontera.comprobacion(nodo_actual);
			solucion = Problema.esObjetivo(nodo_actual);
			if (solucion) {
				System.out.println("\nENCONTRAMOS LA SOLUCION\n");
			} else{
				lista_sucesores = Estado.sucesores(nodo_actual.getEstado());
				lista_nodos = CrearListaNodos(lista_sucesores, nodo_actual, profMax, estrategia);
				frontera.insertarNodos(lista_nodos, estrategia);
			
			}
		}
		
		if(solucion==true) {
			System.out.println("LA SOLUCION ESTA EN : solucion.txt\n");
			CrearSolucion(nodo_actual, estrategia);
		}else {
			System.out.println("NO HAY SOLUCION \n");
		}
		return solucion;

	}// fin busqueda acotada

	public static List<Nodo> CrearListaNodos(String[][] lista_sucesores, Nodo nodo_actual, int pmaxima,
			String estrategia) throws IOException {

		List<Nodo> lista = new ArrayList<Nodo>();
		Nodo nodo = null;
		double valorF = 0.0;
		int id = nodo_actual.getId();
		System.out.println("Generamos los nodos de: " + id);
		System.out.println("Estado del nodo: " + nodo_actual.getEstado().getEstado());
		for (int i = 0; i < lista_sucesores.length; i++) { // recorremos las filas de los sucesores
			Cubo cubo = Estado.obtenerCubo(lista_sucesores[i][1]);
			String accion = lista_sucesores[i][0];
			double coste_sucesor = Double.parseDouble(lista_sucesores[i][2]);
			double nuevo_coste = coste_sucesor + nodo_actual.getCosto();
			int d = nodo_actual.getD() + 1; //
			double h = calcularEntropia(cubo);
			switch (estrategia) {
			case ANCHURA:
				valorF = nodo_actual.getD() + 1;
				break;
			case PROFUNDIDAD:
				valorF = redondearDecimales(((double)1/(nodo_actual.getD() + 1)),2);
				break;
			case COSTO_UNIFORME:
				valorF = redondearDecimales((double)nuevo_coste, 2);
				break;
			case A:
				valorF = redondearDecimales(((double)h + nuevo_coste), 2);
				break;
			case VORAZ:
				valorF = redondearDecimales((double)h, 2);
				break;
			}

			idN = idN + 1; // Actualizamos el id de cada nodo
			// Nodo padre, Cubo estado, String accion, double costo, int d, int id, double
			// valor

			nodo = new Nodo(nodo_actual, cubo, accion, nuevo_coste, d, idN, valorF, h);

			if (nodo.getD() < pmaxima) {
				lista.add(nodo);
			}
		}
		return lista;
	}

	
	public static void CrearSolucion(Nodo nodo_actual, String estrategia) throws IOException { 

		Stack<Nodo> pila = new Stack<Nodo>(); // creamos la pila donde iran entrando los nodos
		boolean primero = false;
		pila.push(nodo_actual); // meto el nodo de la solucion

		do {
			nodo_actual = nodo_actual.getPadre(); // convierto al padre en nodo actual
			pila.push(nodo_actual); // meto ese nodo en la pila y me salgo del while

			if (nodo_actual.getId() == 0) { // si hemos llegado al primer nodo, ponemos a TRUE
				primero = true;
			}
		} while (primero == false);

		// ya tenemos la pila llena, ahora ir sacando y metiendo en el archivo de texto convertir el cubo a MD5 y guardarlo asi

		Nodo n = null;
		FileWriter fichero = null;
		try {
			fichero = new FileWriter("solucion.txt");
			// pw = new PrintWriter(fichero);
			fichero.write("ID NODO, ACCION, ESTADO, COSTE, PROFUNDIDAD, VALOR DE F \n");

			switch (estrategia) {
			case ANCHURA:
				fichero.write("\nANCHURA \n ================================================= \n");
				break;
			case PROFUNDIDAD:
				fichero.write("\nPROFUNDIDAD \n ================================================= \n");
				break;
			case COSTO_UNIFORME:
				fichero.write("\nCOSTO UNIFORME \n ================================================= \n");
				break;
			case A:
				fichero.write("\nA* \n ================================================= \n");
				break;
			case VORAZ:
				fichero.write("\nVORAZ \n ================================================= \n");
				break;
			}

			while (!pila.empty()) {
				n = pila.pop();
				String md = Estado.getMD5(Estado.obtenerID(n.getEstado()));

				if (n.getId() == 0) {
					fichero.write("[" + n.getId() + "] ([None] " + md + ", c=" + n.getCosto() + ", p=" + n.getD()
							+ ", f=" + n.getF() + " , h=" + n.getH() + ")) \n");
				} else {
					fichero.write("[" + n.getId() + "] ([" + n.getAccion() + "] " + md + ", c=" + n.getCosto() + ", p="
							+ n.getD() + ", f=" + n.getF() + " , h=" + n.getH() + ")) \n");
				}
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		fichero.close();

	}

	public static double calcularEntropia(Cubo cubo) {
		double entropia = 0.0;
		int[][][] matriz = cubo.getPosiciones();
		int N = matriz[0].length;
		int NN = N * N;
		int contador[] = new int[6]; // contador para los colores de las caras, 6 caras(filas) , y 6 colores(columnas)

		for (int i = 0; i < matriz.length; i++) { // caras

			contador = new int[6];
			for (int j = 0; j < matriz[0].length; j++) { // filas
				for (int k = 0; k < matriz[0][0].length; k++) { // columnas
					int valor = matriz[i][j][k];
					contador[valor]++;
				}
			}

			for (int l = 0; l < contador.length; l++) {
				if (contador[l] > 0.0) {
					double c = contador[l];
					double n = NN;
					double v = (c / n);
					double log = Math.log(v) / Math.log(6.0);
					entropia = entropia + (v * log);
				}
			}
		}
		double h_final = Math.abs(redondearDecimales(entropia, 2));
		return h_final;
	}

	public static double redondearDecimales(double valorInicial, int numeroDecimales) {
		double parteEntera, resultado;
		resultado = valorInicial;
		parteEntera = Math.floor(resultado);
		resultado = (resultado - parteEntera) * Math.pow(10, numeroDecimales);
		resultado = Math.round(resultado);
		resultado = (resultado / Math.pow(10, numeroDecimales)) + parteEntera;
		return resultado;
	}

}
