//https://www.geeksforgeeks.org/priorityqueue-comparator-method-in-java/
//https://stackoverflow.com/questions/39352302/confused-over-compareto-implementation-with-priorityqueue
import java.util.*; 
import java.util.PriorityQueue; 
  
class Comparar implements Comparator<Nodo> { 
	
    public int compare(Nodo nodo1, Nodo nodo2) { 
        Integer id1 = nodo1.getId(); 
        Integer id2 = nodo2.getId(); 
       
        
        return id1.compareTo(id2); 
    } 
}
