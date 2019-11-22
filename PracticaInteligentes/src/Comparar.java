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
   /* public int compare(Nodo nodo1, Nodo nodo2) { 
        Double id1 = nodo1.getF(); 
        Double id2 = nodo2.getF(); 
        Integer int1 = nodo1.getId(); 
        Integer int2 = nodo2.getId();
        int devolver = 0;
        
        int comparadord= Double.compare(id2, id1);
        int comparadori = int1.compareTo(int2);
        if( comparadord == -1 ) {
        	devolver = -1;
        }else if ( comparadord == 0 && comparadori == 0) {
        	devolver = -1;
    	}else if ( comparadord == 1) {
    		devolver = 1;
    	}
        
        return comparadord;   
    } */
}
