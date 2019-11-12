import java.util.*;

public class FronteraMap {
	//HashMap -> no ordena, no permite repetir ides, 

	
	private Map<Integer, Nodo> nombreMap;
	
	public FronteraMap() {
		nombreMap=new TreeMap<Integer, Nodo>(); //usamos un treemap porque los orden por id
	}
}
