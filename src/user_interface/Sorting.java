package user_interface;

import java.util.HashMap;
import java.util.Map;
import java.util.ArrayList;
import java.util.TreeMap;

public class Sorting {
	
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
}
