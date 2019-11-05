import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

abstract class Frontera {
	
	/* 
	 * La clase Frontera será de tipo 'abstract' ya que deberemos implementarla de diferentes formas según el criterio de 
	 * ordenación de dicha frontera. Para ello, definirimos los métodos que vamos a implementar en dichas clases.
	 */
	public abstract Frontera crearFrontera();
	
	public abstract void insertarNodo(Nodo nodo);
	
	public abstract Nodo eliminarNodo(); 
	
	public abstract boolean estaVacia();
	
}
