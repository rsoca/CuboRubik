
import java.util.*; 
  
class Comparar implements Comparator<Nodo> { 
	
	public int compare(Nodo nodo1, Nodo nodo2) {
		int retorno = 0;
		if (nodo1.getF() < nodo2.getF()) {
			retorno = -1;
		}
		if (nodo1.getF() > nodo2.getF()) {
			retorno = 1;
		}
		if (nodo1.getF() == nodo2.getF()) {
			retorno = Integer.compare(nodo1.getId(), nodo2.getId());
		}
		return retorno;
	}
}
