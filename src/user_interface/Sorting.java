package user_interface;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.TreeMap;
import java.util.List;
import java.util.Comparator;

public class Sorting {
	
	private List<List<String>> list;

	
	private HashMap<ArrayList<String>, Integer> connections;
	
	public Sorting() {
		connections = new HashMap<ArrayList<String>, Integer>();
	}
	
	public Sorting(HashMap<ArrayList<String>, Integer> connections) {
		this.connections = connections;
	}
	
	public  Map<ArrayList<String>, Integer> sortByKey() {
		
        Map<ArrayList<String>, Integer> map = new TreeMap<ArrayList<String>, Integer>(connections); 
        return map;
	}
	
	
	  
	  public int compare(List<String> list1, List<String> list2) {
	    return list1.get(1).compareTo(list2.get(2));
	  
	}
}





