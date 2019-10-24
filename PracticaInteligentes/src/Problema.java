
public class Problema {
	public void Objetivo(){
		String estadoini;
		Nodo node;
		boolean encontrado=false;
		Frontera front = null;
		front.crearFrontera();	
		while(encontrado==false && !front.estaVacia()){
			node = front.eliminarNodo();
			if(esObjetivo(node,encontrado)){
				
			}else{
				
			}
		}
	}
	public boolean esObjetivo(Nodo node,boolean encontrado){
		Estado objetivo = null;
		Estado actual=node.getEstado();
		if(actual==objetivo){
			encontrado=true;
		}
		return encontrado;
	}
}
