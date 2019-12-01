import java.util.*;

public class FronteraMap {
	
	private Map<Integer, Nodo> nombreMap;
	
	public FronteraMap() {
		nombreMap=new TreeMap<Integer, Nodo>(); 
	}
	
	public void insertarNodo(Nodo nodo) {
		nombreMap.put(nodo.getId(), nodo);
	}
	
	public Nodo sacarNodo(int ID) {
		return nombreMap.get(ID);
	}
	
	public Nodo eliminarNodo(int ID) {
		return nombreMap.remove(ID);
	}
	
	public boolean estaVacia() {
		return nombreMap.isEmpty();
	}
}
