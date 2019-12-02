import java.util.*;

/** 
 * 
 * Class Name: Frontera
 * 
 * Main Author/s name: Ricardo Rodríguez Mateos-Aparicio, Razvan Dan Socaciu, Juan Manuel Palacios Navas
 * 
 * La clase Frontera será de tipo 'abstract' ya que deberemos implementarla de diferentes formas según el criterio de 
 * ordenación de dicha frontera. Para ello, definirimos los métodos que vamos a implementar en dichas clases.
 * 
 */

abstract class Frontera {
	
	public abstract Frontera crearFrontera();
	
	public abstract void insertarNodo(Nodo nodo, String estrategia);
	
	public abstract void insertarNodos(List<Nodo> nodo, String estrategia);
	
	public abstract Nodo sacarNodo(); 
	
	public abstract boolean estaVacia();

	public abstract void comprobacion(Nodo nodo_actual);

	
}
