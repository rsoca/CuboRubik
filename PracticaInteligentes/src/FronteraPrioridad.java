import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Queue;

/**
 * ***************************************************************
 *
 * Class Name: FronteraPrioridad
 * 
 * Main Author/s name: Ricardo Rodríguez Mateos-Aparicio, Razvan Dan Socaciu, Juan Manuel Palacios Navas
 * 
 * En esta clase implementaremos nuestra frontera de tipo cola prioridad que nos permitirá insertar, borrar y comparar
 * nodos para llegar al nodo objetivo que buscamos.
 *
 */

public class FronteraPrioridad extends Frontera { 

	private Queue<Nodo> colaNodoFrontera;
	private List<Long> tiemposInsercion = new ArrayList<Long>(); 
	private Map<String, Double> map;
	long tiempoTotal;
	long tiempoMaximo;
	long tiempoMinimo;
	
	/**
	 * ***************************************************************
	 *
	 * Method name: FronteraPrioridad()
	 * 
	 * En este método buscaremos la inicialización de nuestra frontera y donde compararemos nodos cada vez que queramos introducirlos
	 * en la frontera, viendo sus valores F y sus ids
	 *
	 */
	
	public FronteraPrioridad() {
		colaNodoFrontera = new PriorityQueue<Nodo>(new Comparar());
		map = new HashMap<>();
		map.clear();
	}
	
	public FronteraPrioridad crearFrontera() {
		FronteraPrioridad frontera = new FronteraPrioridad();
		return frontera;
	}
	
	
	/**
	 * ***************************************************************
	 *
	 * Method name: insertarNodo
	 * 
	 * En este método se encargará de insertar los nodos en la frontera. Antes de dicha inserción, realizaremos una poda comprobando
	 * que no estuviese ese nodo ya en nuestro diccionario.
	 * 
	 * En caso de que no esté, lo añadiremos a la frontera y lo indexaremos a nuestro diccionario. Si está, comprobaremos su valorf y
	 * su valoración dependerá de la estrategia que utilicemos..
	 *
	 */
	
	public void insertarNodo(Nodo nodo, String estrategia) {
		//inicioInsercion = System.currentTimeMillis();
		boolean pasa = true;
		String estado= Estado.getMD5(Estado.obtenerID(nodo.getEstado()));
		if(map.containsKey(estado)) {
			double valorf = map.get(estado).doubleValue();
			if(nodo.getF() <= valorf && estrategia.equals("PROFUNDIDAD")) {
				pasa = false;
			}
			else if(nodo.getF() >= valorf && !estrategia.equals("PROFUNDIDAD")){
				pasa = false;
			}
		}
		
		if(pasa) {
			colaNodoFrontera.add(nodo);
			map.put(estado, nodo.getF());
		}
		//finInsercion = System.currentTimeMillis();
		//tiemposInsercion.add(finInsercion - inicioInsercion);
	}
	
	
	public void insertarNodos(List<Nodo> lista_nodos, String estrategia) {
		for(int i=0; i<lista_nodos.size(); i++) {
			insertarNodo(lista_nodos.get(i), estrategia);
		}
	}
	
	public Nodo eliminarNodo() {
		return colaNodoFrontera.poll();
	}
	
	public boolean estaVacia() {
		return colaNodoFrontera.isEmpty();
	}

	public void calcularTiempos() {
		for(Long tiempo: tiemposInsercion) {
			if (tiempo > tiempoMaximo) {
				tiempoMaximo = tiempo;
			}
			if (tiempo < tiempoMinimo) {
				tiempoMinimo = tiempo;
			}
			tiempoTotal += tiempo;
		}
	}
	
	public String toStringTiempo() {
		calcularTiempos();
		return "Tiempo minimo: "+tiempoMinimo+"\n Tiempo maximo: "+tiempoMaximo+"\n Tiempo medio: "+tiempoTotal/tiemposInsercion.size();
	}

	@Override
	public Nodo sacarNodo() {
		return colaNodoFrontera.poll();
	}
	
	/**
	 * ***************************************************************
	 *
	 * Method name: comprobacion()
	 * 
	 * En este método eliminará el nodo del diccionario que insertamos por primera vez
	 *
	 */
	
	@Override
	public void comprobacion(Nodo nodo_actual) {
		if (map.containsKey(Estado.getMD5(Estado.obtenerID(nodo_actual.getEstado()))) && nodo_actual.getId()==0) {
			map.remove(Estado.getMD5(nodo_actual.getEstado().getEstado()));
		}
	}



}
