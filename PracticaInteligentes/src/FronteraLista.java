import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public class FronteraLista extends Frontera{
	private List<Nodo> nodeListFrontera;
	private List<Long> tiemposInsercion = new ArrayList<Long>(); // tiempos de insercion
	private long inicioInsercion;
	private long finInsercion;
	long tiempoTotal;
	long tiempoMaximo;
	long tiempoMinimo;

	/*
	 * El funcionamiento de PriorityQueue tiene un funcionamiento similar a la
	 * prioridad Heap (explicada en el laboratorio).
	 * 
	 */
	public FronteraLista() {
		nodeListFrontera = new LinkedList<Nodo>();
	}

	public FronteraLista crearFrontera() {
		FronteraLista frontera = new FronteraLista();
		return frontera;
	}

	public void insertarNodo(Nodo nodo) {
		inicioInsercion = System.currentTimeMillis();
		//Añadimos poda
		if(nodeListFrontera.contains(nodo.getId())) {
			double f = nodo.getF();
		}
		nodeListFrontera.add(nodo);
		finInsercion = System.currentTimeMillis();
		tiemposInsercion.add(finInsercion - inicioInsercion);
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
	protected List<Nodo> getFrontera() {
		return nodeListFrontera;
	}
}
