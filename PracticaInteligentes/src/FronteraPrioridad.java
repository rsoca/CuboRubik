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
	long tiempoTotal;
	long tiempoMaximo;
	long tiempoMinimo;
	
	public FronteraPrioridad() {
		colaNodoFrontera = new PriorityQueue<Nodo>(new Comparar());
		map = new HashMap<>();
		map.clear();
	}
	
	public FronteraPrioridad crearFrontera() {
		FronteraPrioridad frontera = new FronteraPrioridad();
		return frontera;
	}
	
	public void insertarNodo(Nodo nodo, String estrategia) {
		//inicioInsercion = System.currentTimeMillis();
		boolean pasa = true;
		String estado= Estado.obtenerID(nodo.getEstado());
		
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
		
		if (map.containsKey(nodo_actual.getEstado().getEstado()) && nodo_actual.getId()==0) {
			map.remove(nodo_actual.getEstado().getEstado());
		}
	}



}
