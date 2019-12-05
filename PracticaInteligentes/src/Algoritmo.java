import java.io.*;
import java.util.*;

/**
 * ***************************************************************
 *
 * Class Name: Algoritmo
 * 
 * Main Author/s name: Ricardo Rodríguez Mateos-Aparicio, Razvan Dan Socaciu, Juan Manuel Palacios Navas
 * 
 * Esta clase se encargará de realizar la búsqueda de la solución partiendo de un cubo leído a través de la clase problema. Contaremos
 * con una variable global idN que nos permitirá asignar a los nodos sus ids correspondientes de forma que no se repitan y ordenados, y
 * una variable para cada una de las estrategias.
 */

public class Algoritmo {
	private static int idN;
	private static final String ANCHURA = "ANCHURA";
	private static final String PROFUNDIDAD_ITERATIVA = "PROFUNDIDAD_ITERATIVA";
	private static final String PROFUNDIDAD_ACOTADA = "PROFUNDIDAD_ACOTADA";
	private static final String COSTO_UNIFORME = "COSTO_UNIFORME";
	private static final String A = "A*";
	private static final String VORAZ = "VORAZ";

	public static void busqueda(Problema problema, String estrategia, int profMax, int incProf, boolean poda) throws IOException {
		long profActual = incProf;
		boolean esSolucion = false;
		while (esSolucion==false && profActual <= profMax) {
			esSolucion = busqueda_acotada(problema, estrategia, profActual, poda);
			profActual = profActual + incProf;
		}
	}
	
	
	/**
	 * ***************************************************************
	 *
	 * Method name: busqueda_acotada()
	 * 
	 * Este método se encargará de buscar la solución. Si un nodo no es solución, generaremos sus sucesores y crearemos sus nodos
	 * correspondientes, para finalmente añadirlos a la frontera y seguir buscando el nodo objetivo recorriendo dicha frontera.
	 *
	 */
	
	private static boolean busqueda_acotada(Problema problema, String estrategia, long profMax, boolean poda) throws IOException { 
		idN=0;
		Cubo c = new Cubo();
		c.setPosiciones(problema.getPos());
		c.setEstado(Estado.obtenerID(c));
		List<Nodo> lista_nodos;
		String[][] lista_sucesores;
		Frontera frontera = new FronteraPrioridad();
		frontera.crearFrontera();
		Nodo nodo_actual = null;
		
		double h = calcularEntropia(c);
		Nodo nodo_inicial = null ;
		
		switch(estrategia) {
		case ANCHURA:
			nodo_inicial = new Nodo(null, c, "", 0, 0, 0, 0, 0);
			break;
		case PROFUNDIDAD_ITERATIVA:
			nodo_inicial = new Nodo(null, c, "", 0, 0, 0, 1.0, 0);
			break;
		case PROFUNDIDAD_ACOTADA:
			nodo_inicial = new Nodo(null, c, "", 0, 0, 0, 1.0, 0);
			break;
		case COSTO_UNIFORME:
			nodo_inicial = new Nodo(null, c, "", 0, 0, 0, 0, 0);
			break;
		case A:
			nodo_inicial = new Nodo(null, c, "", 0, 0, 0, h, h);
			break;
		case VORAZ:
			nodo_inicial = new Nodo(null, c, "", 0, 0, 0, h, h);
			break;
			
		}
		frontera.insertarNodo(nodo_inicial, estrategia, poda);
		boolean solucion = false;
		while (frontera.estaVacia()==false && solucion==false ) {
			nodo_actual = frontera.sacarNodo();
			frontera.comprobacion(nodo_actual);
			solucion = Problema.esObjetivo(nodo_actual);
			if (solucion) {
				System.out.println("\nENCONTRAMOS LA SOLUCION\n");
			} else{
				lista_sucesores = Estado.sucesores(nodo_actual.getEstado());
				lista_nodos = crearListaNodos(lista_sucesores, nodo_actual, profMax, estrategia);
				frontera.insertarNodos(lista_nodos, estrategia, poda);
			
			}
		}
		
		if(solucion==true) {
			System.out.println("LA SOLUCION ESTA EN : solucion.txt\n");
			crearSolucion(nodo_actual, estrategia);
		}else {
			System.out.println("NO HAY SOLUCION \n");
		}
		return solucion;

	}

	/**
	 * ***************************************************************
	 *
	 * Method name: crearListaNodos
	 * 
	 * Creación de los nodos a partir de los sucesores generados anteriormente y donde tendremos en cuenta las diferentes estrategias
	 *
	 */
	
	private static List<Nodo> crearListaNodos(String[][] lista_sucesores, Nodo nodo_actual, long pmaxima,
			String estrategia) throws IOException {
		List<Nodo> lista = new ArrayList<Nodo>();
		double valorF = 0.0;
		double h = 0.0;
		int id = nodo_actual.getId();
		System.out.println("Generamos los nodos de: " + id);
		System.out.println("Estado del nodo: " + nodo_actual.getEstado().getEstado());
		for (int i = 0; i < lista_sucesores.length; i++) { 
			Cubo cubo = Estado.obtenerCubo(lista_sucesores[i][1]);
			String accion = lista_sucesores[i][0];
			double coste_sucesor = Double.parseDouble(lista_sucesores[i][2]);
			double nuevo_coste = coste_sucesor + nodo_actual.getCosto();
			int d = nodo_actual.getD() + 1; //
			switch (estrategia) {
			case ANCHURA:
				valorF = nodo_actual.getD() + 1;
				break;
			case PROFUNDIDAD_ITERATIVA:
				valorF = redondearDecimales(((double)1/(d + 1)),2);
				break;
			case PROFUNDIDAD_ACOTADA:
				valorF = redondearDecimales(((double)1/(d + 1)),2);
				break;
			case COSTO_UNIFORME:
				valorF = redondearDecimales((double)nuevo_coste, 2);
				break;
			case A:
				h = calcularEntropia(cubo);
				valorF = redondearDecimales(((double)h + nuevo_coste), 2);
				break;
			case VORAZ:
				h = calcularEntropia(cubo);
				valorF = redondearDecimales((double)h, 2);
				break;
			}

			idN = idN + 1;

			Nodo nodo = new Nodo(nodo_actual, cubo, accion, nuevo_coste, d, idN, valorF, h);

			if (nodo.getD() < pmaxima) {
				lista.add(nodo);
			}
		}
		return lista;
	}

	/**
	 * ***************************************************************
	 *
	 * Method name: crearSolucion
	 * 
	 * Generamos el archivo que contendrá nuestra solución
	 *
	 */
	
	private static void crearSolucion(Nodo nodo_actual, String estrategia) throws IOException { 

		Stack<Nodo> pila = new Stack<Nodo>(); 
		boolean primero = false;
		pila.push(nodo_actual); 

		do {
			nodo_actual = nodo_actual.getPadre(); 
			pila.push(nodo_actual);

			if (nodo_actual.getId() == 0) {
				primero = true;
			}
		} while (primero == false);

		Nodo n = null;
		FileWriter fichero = null;
		try {
			fichero = new FileWriter("solucion.txt");
			fichero.write("ID NODO, ACCION, ESTADO, COSTE, PROFUNDIDAD, VALOR DE F \n");

			switch (estrategia) {
			case ANCHURA:
				fichero.write("\nANCHURA \n ================================================= \n");
				break;
			case PROFUNDIDAD_ITERATIVA:
				fichero.write("\nPROFUNDIDAD ITERATIVA \n ================================================= \n");
				break;
			case PROFUNDIDAD_ACOTADA:
				fichero.write("\nPROFUNDIDAD ACOTADA \n ================================================= \n");
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

	/**
	 * ***************************************************************
	 *
	 * Method name: calcularEntropia
	 * 
	 * En este método calcularemos la entropía en base al estado del cubo
	 *
	 */
	
	private static double calcularEntropia(Cubo cubo) {
		double entropia = 0.0;
		int[][][] matriz = cubo.getPosiciones();
		int N = matriz[0].length;
		int NN = N * N;
		int contador[] = new int[6]; 

		for (int i = 0; i < matriz.length; i++) {

			contador = new int[6];
			for (int j = 0; j < matriz[0].length; j++) { 
				for (int k = 0; k < matriz[0][0].length; k++) {
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

	private static double redondearDecimales(double valorInicial, int numeroDecimales) {
		double resultado;
        resultado = valorInicial * Math.pow(10, 2);
        resultado = Math.round(resultado);
        resultado = resultado/Math.pow(10, 2);
        return resultado;
	}

}
