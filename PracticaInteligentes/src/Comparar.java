//https://www.geeksforgeeks.org/priorityqueue-comparator-method-in-java/
//https://stackoverflow.com/questions/39352302/confused-over-compareto-implementation-with-priorityqueue
import java.util.Comparator; 
  
class Comparar implements Comparator<Nodo> { 
	
    public int compare(Nodo nodo1, Nodo nodo2) { 
    	int retorno = 0;
    	if(nodo1.getF() < nodo2.getF()) {
    		retorno = -1;
    	}
    	else if(nodo1.getF() > nodo2.getF()) {
    		retorno = 1;
    	}
    	if(nodo1.getF() == nodo2.getF() && nodo1.getId() < nodo2.getId()) {
    		retorno = -1;
    	}
    	else if(nodo1.getF() == nodo2.getF() && nodo1.getId() > nodo2.getId())
    		retorno = 1;
    	return retorno;
    } 
}
