import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Queue;

public class FronteraPrioridad extends Frontera { //implements Comparable<Nodo>{

	private Queue<Nodo> colaNodoFrontera;
	private List<Long> tiemposInsercion = new ArrayList<Long>(); //tiempos de insercion
	private Map<String, Double> map;
	private long inicioInsercion;
	private long finInsercion;
	long tiempoTotal;
	long tiempoMaximo;
	long tiempoMinimo;
	
	
	 /* El funcionamiento de PriorityQueue tiene un funcionamiento similar a la prioridad Heap (explicada en el laboratorio).
	 */
	 
	public FronteraPrioridad() {
		colaNodoFrontera = new PriorityQueue<Nodo>(/*new Comparar()*/);
		map = new HashMap<>();
	}
	
	
	public FronteraPrioridad crearFrontera() {
		FronteraPrioridad frontera = new FronteraPrioridad();
		return frontera;
	}
	
	public void insertarNodo(Nodo nodo, String estrategia) {
		//inicioInsercion = System.currentTimeMillis();
		boolean pasa = true;//si el nodo pasa a la frontera o no
		
		String estado= Estado.obtenerID(nodo.getEstado());
		
		if(map.containsKey(estado)) {
			double valorf = map.get(estado).doubleValue();
			if(nodo.getF() <= valorf &&  estrategia.equals("PROFUNDIDAD")) {
				pasa = false;

			}
			else if(nodo.getF() >= valorf){
				pasa = false;
			}
		}
		if(pasa) {
			colaNodoFrontera.add(nodo);
			estado = Estado.obtenerID(nodo.getEstado());
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
	


	@Override
	public void comprobacion(Nodo nodo_actual) {
		String estado= Estado.obtenerID(nodo_actual.getEstado());
		double f = map.get(estado).doubleValue();
		double f_actual = nodo_actual.getF();
		if ((map.containsKey(nodo_actual.getEstado().getEstado()) && f_actual<f) || nodo_actual.getId()==0) {
			//map.replace(nodo_actual.getEstado().getEstado(), f, f_actual);
			map.remove(nodo_actual.getEstado().getEstado());
			//
		}
		
	}



}
