import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

abstract class Frontera {
	
	/* 
	 * La clase Frontera será de tipo 'abstract' ya que deberemos implementarla de diferentes formas según el criterio de 
	 * ordenación de dicha frontera. Para ello, definirimos los métodos que vamos a implementar en dichas clases.
	 */
	public abstract Frontera crearFrontera();
	
	public abstract void insertarNodo(Nodo nodo, String estrategia);
	
	public abstract void insertarNodos(List<Nodo> nodo, String estrategia);
	
	public abstract Nodo sacarNodo(); 
	
	
	public abstract boolean estaVacia();

	public abstract void comprobacion(Nodo nodo_actual);

	
}
