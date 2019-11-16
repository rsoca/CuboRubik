import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Queue;

public class FronteraPrioridad extends Frontera{

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
		colaNodoFrontera = new PriorityQueue<Nodo>();
		map = new HashMap<>();
	}
	
	public Queue getFrontera() {
		return colaNodoFrontera;
	}
	
	public FronteraPrioridad crearFrontera() {
		FronteraPrioridad frontera = new FronteraPrioridad();
		return frontera;
	}
	
	public void insertarNodo(Nodo nodo) {
		//inicioInsercion = System.currentTimeMillis();
		boolean pasa = true;
		if(map.containsKey(nodo.getEstado().getEstado())) {
			double valorf = map.get(nodo.getEstado().getEstado()).doubleValue();
			if(Math.abs(nodo.getF()) > valorf) {
				pasa = false;
			}
		}
		if(pasa) {
			colaNodoFrontera.add(nodo);
			map.put(nodo.getEstado().getEstado(), Math.abs(nodo.getF()));
		}
		
		//finInsercion = System.currentTimeMillis();
		//tiemposInsercion.add(finInsercion - inicioInsercion);
	}
	
	public void insertarNodos(List<Nodo> lista_nodos) {
		for(int i=0; i<lista_nodos.size(); i++) {
			insertarNodo(lista_nodos.get(i));
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
		return colaNodoFrontera.remove();
	}

	@Override
	public void comprobacion(Nodo nodo_actual) {
		if (map.containsKey(nodo_actual.getEstado().getEstado())) {
			map.remove(nodo_actual.getEstado().getEstado());
		}
		
	}



}
