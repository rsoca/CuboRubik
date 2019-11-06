import java.io.*;
import java.util.*;

public class Algoritmos {
	

	
	public static void main (String [] args) throws IOException {
		
		Lectura leer = new Lectura();
		int [][][] c = leer.leerArchivo();
		
	}
	
	public static boolean busqueda_acotada(int [][][] problema, String estrategia, int pmaxima ) throws IOException { // en anchura
		boolean solucion=false;
		
		Cubo c = new Cubo (problema);
		FronteraPrioridad frontera = new FronteraPrioridad();
		Nodo padre = null; //consultar porque me parece raro crearlo
		Nodo nodo_actual = null;
		Nodo nodo_inicial = new Nodo(padre, c, "", 0, 0, 0); //nodo padre, estado, accion, coste, profundidad, id
		frontera.insertarNodo(nodo_inicial);
		
		
		
		while ( solucion == false && frontera.estaVacia()==false) {
		
			nodo_actual = seleccionarNodo(frontera);
			
			if (Problema.esObjetivo(nodo_actual)==true){
			solucion=true;
			}else{
			
			String [][] lista_sucesores = Estado.sucesores(c);
			
			Nodo [] lista_nodos = CrearListaNodos(lista_sucesores, nodo_actual, pmaxima, estrategia);
			
			frontera.insertarNodos(lista_nodos);
			
			
			} //fin if-else
		} // fin while
		
		
		if( solucion == true ){
		
			CrearSolucion(nodo_actual); //aqui dudo de si tengo que imprimir, devolver true, crear el archivo dentro del metodo...
		}else{
		
			solucion = false;
		}
		
		return solucion;
		
	}//fin busqueda acotada
	
	
	public static Nodo seleccionarNodo(FronteraPrioridad frontera) {
		Nodo nodo = null;
		
		Queue <Nodo> f = frontera.getFrontera();
		
		nodo = f.poll();
		//System.out.println("El id es"+nodo.getID());
		return nodo;
	}
	
	public static Nodo [] CrearListaNodos(String [][] lista_sucesores, Nodo nodo_actual,int pmaxima, String estrategia) {
		
		//Esto es en anchura, por tanto la f es igual a la profundidad
		//Tenemos tambien la limitacion de la pmaxima a la hora de crear los nodos 
		
		Nodo [] lista = new Nodo[lista_sucesores.length];//creamos la lista de los nodos que tendra la longitud del numero de filas
		
		Nodo nodo = null; 
		Cubo cubo = null; //tiene dentro la matriz de posiciones
		//crear los nodos y meterlos en lista
		
		//public Nodo(Nodo padre, Cubo estado, String accion, double costo, int d, int id)
		double coste=0;
		int d; //profundidad
		int id = nodo_actual.getID();
		
		if( nodo_actual.getD() < pmaxima) {
			for(int i = 0; i< lista_sucesores.length; i++) { //recorremos las filas de los sucesores
					
					coste = Double.parseDouble(lista_sucesores[i][2]) + nodo_actual.getCosto();
					d = nodo_actual.getD()+1;
					id++;
					cubo=Estado.obtenerCubo(lista_sucesores[i][1]);
					nodo = new Nodo(nodo_actual, cubo , lista_sucesores[i][0], coste, d, id );
					lista[i]=nodo;
				
			}
		}else {
				System.out.println("No se pueden hacer mas nodos");
		}
		
		return lista;
	}
	
	public static void CrearSolucion(Nodo nodo_actual) throws IOException { //importar siempre el java.io
		
		Stack <Nodo> pila = new Stack<Nodo>(); //creamos la pila donde iran entrando los nodos
		boolean primero = false;
		pila.push(nodo_actual); //meto el nodo de la solucion
		
		while(nodo_actual.getPadre()!=null && primero == false) {
			
			pila.push(nodo_actual.getPadre()); //meto el nodo padre del actual
			nodo_actual=nodo_actual.getPadre(); //convierto al padre en nodo actual
			
			if(nodo_actual.getID()==0 && nodo_actual.getPadre()==null) { 
				//compruebo si el nodo actual tiene ID=0, porque seria el primero, el del inicio
				//y que no tiene padre
				
				primero=true; //he encontrado el primero nodo de todo el arbol
				pila.push(nodo_actual); //meto ese nodo en la pila y me salgo del while
			}
		}
		
		//ya tenemos la pila llena, ahora ir sacando y metiendo en el archivo de texto
		//convertir el cubo a MD5 y guardarlo asi
		
		
		//LIMPIAMOS EL ANTERIOR ARCHIVO POR SI HUBIERAN DATOS
		
		BufferedWriter bw = new BufferedWriter(new FileWriter("solucion.txt"));
		bw.write("");
		bw.close();
		
		
		//Formato de guardado de los datos en el archivo
		//Prepresentación del nodo del árbol: [ID_Nodo]([accion] ID_ESTADO,costo,profundidad,valor del nodo (f)) 
		//La profundidad es el valor d
		
		
		Nodo n=null;
		FileWriter fichero = null;
        PrintWriter pw = null;
        try{
            fichero = new FileWriter("solucion.txt");
            pw = new PrintWriter(fichero);

            while(!pila.empty()) {
            	n=pila.pop();
            	String md= Estado.getMD5(Estado.obtenerID(n.getEstado()));
                pw.println("[" +n.getID()+"](["+n.getAccion()+"]"+md+","+n.getCosto()+","+n.getD()+","+n.getF()+"))");
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
		
	}
	
	
	
	
}
