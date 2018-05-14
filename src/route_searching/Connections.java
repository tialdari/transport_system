package route_searching;

import java.util.*;

public class Connections {
	
	
	public void findRoutes(String start, String destination, HashMap<String, HashMap<String, Integer>> cities) {
			
		
		if(cities.get(start).containsKey(destination)) {
			System.out.println("Direct connection, distance: " + cities.get(start).get(destination).intValue());
		}else {
			System.out.println("No indirect connection");

		}
	
		
	}
}

