import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class FronteraLista extends Frontera{
	private List<Nodo> nodeListFrontera;
	private List<Long> tiemposInsercion = new ArrayList<Long>(); // tiempos de insercion
	private Map<String, Double> map;
	private long inicioInsercion;
	private long finInsercion;
	long tiempoTotal;
	long tiempoMaximo;
	long tiempoMinimo;

	public FronteraLista() {
		nodeListFrontera = new LinkedList<Nodo>();
		map = new HashMap<>();
	}

	public FronteraLista crearFrontera() {
		FronteraLista frontera = new FronteraLista();
		return frontera;
	}

	public void insertarNodo(Nodo nodo) {
		//inicioInsercion = System.currentTimeMillis();
		boolean pasa = true;
		if(map.containsKey(nodo.getEstado().getEstado())) {
			double valorf = map.get(nodo.getEstado().getEstado()).doubleValue();
			if(Math.abs(nodo.getF()) >= valorf) {
				pasa = false;
			}
		}
		if(pasa) {
			nodeListFrontera.add(nodo);
			Collections.sort(nodeListFrontera);
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
	public Nodo sacarNodo() {
		// ordenamos la frontera
		Collections.sort(nodeListFrontera);
		return nodeListFrontera.remove(0);
	}

	public boolean estaVacia() {
		return nodeListFrontera.isEmpty();
	}

	public void calcularTiempos() {
		for (Long tiempo : tiemposInsercion) {
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
		return "Tiempo minimo: " + tiempoMinimo + "\n Tiempo maximo: " + tiempoMaximo + "\n Tiempo medio: "
				+ tiempoTotal / tiemposInsercion.size();
	}

	@Override
	public void comprobacion(Nodo nodo_actual) {
		if (map.containsKey(nodo_actual.getEstado().getEstado())) {
			map.remove(nodo_actual.getEstado().getEstado());
		}
	}



}
