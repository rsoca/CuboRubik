import java.util.*;

public class FronteraMap {
	//HashMap -> no ordena, no permite repetir ides, 
	//TreeMap -> ordena por la clave
	//Map < clave, valor>
	/*nombreMap.size(); // Devuelve el numero de elementos del Map
	nombreMap.isEmpty(); // Devuelve true si no hay elementos en el Map y false si si los hay
	nombreMap.put(K clave, V valor); // A�ade un elemento al Map
	nombreMap.get(K clave); // Devuelve el valor de la clave que se le pasa como par�metro o 'null' si la clave no existe
	nombreMap.clear(); // Borra todos los componentes del Map
	nombreMap.remove(K clave); // Borra el par clave/valor de la clave que se le pasa como par�metro
	nombreMap.containsKey(K clave); // Devuelve true si en el map hay una clave que coincide con K
	nombreMap.containsValue(V valor); // Devuelve true si en el map hay un Valor que coincide con V
	nombreMap.values(); // Devuelve una "Collection" con los valores del Map*/

	
	private Map<Integer, Nodo> nombreMap;
	
	public FronteraMap() {
		nombreMap=new TreeMap<Integer, Nodo>(); //usamos un treemap porque los orden por id
	}
	//insertar nodo, eliminar nodo, esta vacio
	public void insertarNodo(Nodo nodo) {
		nombreMap.put(nodo.getId(), nodo);
	}
	
	public Nodo sacarNodo(int ID) {//por ver si funciona asi
		return nombreMap.get(ID);
	}
	
	public Nodo eliminarNodo(int ID) {//por ver si funciona asi
		return nombreMap.remove(ID);
	}
	
	public boolean estaVacia() {
		return nombreMap.isEmpty();
	}
}
