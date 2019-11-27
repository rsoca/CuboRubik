import java.io.*;
import java.text.DecimalFormat;
import java.util.*;

public class Algoritmo {

	private static int idN = 0;
	private static final String ANCHURA = "ANCHURA";
	private static final String PROFUNDIDAD = "PROFUNDIDAD";
	private static final String COSTO_UNIFORME = "COSTO UNIFORME";
	private static final String A = "A";
	private static final String VORAZ = "VORAZ";

	public static boolean busqueda(Problema problema, String estrategia, int profMax, int incProf) throws IOException {
		long profActual = incProf;
		boolean esSolucion = false;
		while (!esSolucion && profActual <= profMax) {
			esSolucion = busqueda_acotada(problema, estrategia, profMax);
			profActual = profActual + incProf;
		}

		return esSolucion;
	}

	public static boolean busqueda_acotada(Problema problema, String estrategia, int profMax) throws IOException { // en
																													// anchura
		boolean solucion = false, salir = false;
		Cubo c = new Cubo();
		c.setPosiciones(problema.getPos());
		c.setEstado(Estado.obtenerID(c));
		List<Nodo> lista_nodos;
		String[][] lista_sucesores;
		Frontera frontera = new FronteraPrioridad();
		frontera.crearFrontera();
		Nodo nodo_actual = null;
		Nodo mejor_entropia = null;

		double h = calcularEntropia(c);
		
		Nodo nodo_inicial = new Nodo(null, c, "", 0, 0, 0, 0, h);//nodo padre, estado, accion, coste, profundidad, id, heuristica
		frontera.insertarNodo(nodo_inicial,estrategia);
		//calcular entropia (cubo cubo)

		while (solucion == false && salir == false && frontera.estaVacia()==false) {
			nodo_actual = frontera.sacarNodo();
			frontera.comprobacion(nodo_actual);
			solucion = Problema.esObjetivo(nodo_actual);

			if (solucion) { System.out.println("¡Hemos encontrado una solucion!"); salir = true;
			} else{
				if(nodo_actual.getD() == profMax && nodo_actual.getH() < mejor_entropia.getH()) {
					//si no solucion, y maxima profundidad, y la h del actual es menor que la que tenemos
					//asignamos el actual al que ya teniamos
					mejor_entropia = nodo_actual; 
				}
				
				if(nodo_actual.getD() > profMax) { //si nos pasamos de profundidad y no hay solucion, salimos del while
					salir=true;
				}
				lista_sucesores = Estado.sucesores(nodo_actual.getEstado());
				lista_nodos = CrearListaNodos(lista_sucesores, nodo_actual, profMax, estrategia);
				frontera.insertarNodos(lista_nodos,estrategia);
			}
		}

		if (solucion) {
			System.out.println("Creamos la solucion... (archivo solucion.txt)");
			CrearSolucion(nodo_actual, estrategia);
		} else{
			System.out.println("No hay solucion.\nLa mejor solucion es (archivo solucion.txt)");
			CrearSolucion(mejor_entropia, estrategia);
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
			switch (estrategia) {
			case ANCHURA:
				valorF = nodo_actual.getD() + 1;
				break;
			case PROFUNDIDAD:
				valorF = (double)1/(nodo_actual.getD() + 1);
				break;
			case COSTO_UNIFORME:
				valorF = (double)nodo_actual.getCosto() + Double.parseDouble(lista_sucesores[i][2]);
				break;
			case A:
				valorF = (double)nodo_actual.getH()+nodo_actual.getCosto();
				break;
			case VORAZ:
				valorF = (double)nodo_actual.getH();
				break;
			}

			idN = idN + 1; // Actualizamos el id de cada nodo
			// Nodo padre, Cubo estado, String accion, double costo, int d, int id, double
			// valor

			Cubo cubo = Estado.obtenerCubo(lista_sucesores[i][1]);
			String accion = lista_sucesores[i][0];
			double coste_sucesor = Double.parseDouble(lista_sucesores[i][2]);
			double nuevo_coste = coste_sucesor + nodo_actual.getCosto();
			int d = nodo_actual.getD() + 1; //
			double h = calcularEntropia(cubo);
			
			nodo = new Nodo(nodo_actual, cubo, accion, nuevo_coste, d, idN, valorF, h);

			if (nodo.getD() < pmaxima) {
				lista.add(nodo);
			}
		}
		return lista;
	}

	// acabado
	public static void CrearSolucion(Nodo nodo_actual, String estrategia) throws IOException { // importar siempre el java.io

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

		// ya tenemos la pila llena, ahora ir sacando y metiendo en el archivo de texto
		// convertir el cubo a MD5 y guardarlo asi

		// LIMPIAMOS EL ANTERIOR ARCHIVO POR SI HUBIERAN DATOS

		//BufferedWriter bw = new BufferedWriter(new FileWriter("solucion.txt"));
		//bw.write("");
		//bw.close();

		// Formato de guardado de los datos en el archivo
		// Prepresentaciï¿½n del nodo del ï¿½rbol: [ID_Nodo]([accion]
		// ID_ESTADO,costo,profundidad,valor del nodo (f))
		// La profundidad es el valor d

		Nodo n = null;
		FileWriter fichero = null;
		try {
			fichero = new FileWriter("solucion.txt");
			// pw = new PrintWriter(fichero);
			fichero.write("ID NODO, ACCION, ESTADO, COSTE, PROFUNDIDAD, VALOR DE F \n");
			
			switch(estrategia) {
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
				
				if(n.getId()==0) {
					fichero.write("[" + n.getId() + "] ([None] " + md + ", c=" + n.getCosto() + ", p="
							+ n.getD() + ", f=" + n.getF() + " , h=" +n.getH() +")) \n");	
				}else {
				fichero.write("[" + n.getId() + "] ([" + n.getAccion() + "] " + md + ", c=" + n.getCosto() + ", p="
						+ n.getD() + ", f=" + n.getF() + " , h=" +n.getH() +")) \n");
				}
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		fichero.close();

	}
	
	
	public static double calcularEntropia(Cubo cubo) {
		double entropia=0.0;
		//cubo = nodo.getEstado();
		int [][][] matriz = cubo.getPosiciones();
		int N = matriz[0].length;
		int NN = N*N;
		int contador [] = new int[6]; //contador para los colores de las caras, 6 caras(filas) , y 6 colores(columnas)
		
		for (int i = 0; i < matriz.length; i++) { //caras
			
			contador = new int[6];
				for (int j = 0; j < matriz[0].length; j++) { //filas
					for (int k = 0; k < matriz[0][0].length; k++) { //columnas
						int valor = matriz[i][j][k];
						contador[valor]++;
					}
				}
			
			for(int l=0; l< contador.length; l++) {
				if(contador[l]>0.0) {
				//entropía = entropía + contador[c]/(N*N) * math.log(contador[c]/(N*N),6)
				double c = contador[l];
				double n = NN;
				//System.out.println("El c "+ c);
				double v =(c/n);
				double log = Math.log(v)/Math.log(6.0);
				//System.out.println("El primero"+ contador[l]);
				//System.out.println("El segundo"+ NN);
				//System.out.println("El v "+ v);
				//System.out.println("El logaritmo"+ (Math.log(v)));
				
				entropia =entropia + (v*log);
				}
				//System.out.println("Entropia vale "+Math.floor(entropia));
			}
			
		}
		double h_final = Math.abs(redondearDecimales(entropia, 2));
		
		return h_final;
	}
	
	
	public static double redondearDecimales(double valorInicial, int numeroDecimales) {
        double parteEntera, resultado;
        resultado = valorInicial;
        parteEntera = Math.floor(resultado);
        resultado=(resultado-parteEntera)*Math.pow(10, numeroDecimales);
        resultado=Math.round(resultado);
        resultado=(resultado/Math.pow(10, numeroDecimales))+parteEntera;
        return resultado;
    }

}
