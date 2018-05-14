package route_searching;

import java.util.*;
import java.util.Map.Entry;


public class Connections {
	
	
	public int findRoutes(String start, String destination, HashMap<String, HashMap<String, Integer>> cities) {
			
		int stops = 0;
		String currentStop = "";
		int distance = 0;

		
		if(cities.get(start).containsKey(destination)) {
			System.out.println("Direct connection (" + start + " - " + destination +")"
					+ ", distance: " + cities.get(start).get(destination).intValue());
			
			return cities.get(start).get(destination);
			
		}
				
			stops++;
			
			if(stops > 2) {
				stops = 0;
				return 0;
			}
			
			Iterator<Entry<String, Integer>> iter = cities.get(start).entrySet().iterator(); 
			Map.Entry<String, Integer> cityConnections = (Map.Entry<String, Integer>)iter.next();

				
				//tworzymy iterator po elementach hashmapy danego miasta
				//dla każdego miasta, z którym dane miasto ma połączenie, 
				//aby sprawdzić, które z nich ma połączenie z szukanym miastem.
				
			while(iter.hasNext()) {
				        
				cityConnections = (Map.Entry<String, Integer>)iter.next();
				currentStop = cityConnections.getKey();
				System.out.println("current stop is: " + currentStop);
				distance = cityConnections.getValue() + findRoutes(currentStop, destination, cities);
				break;

			}
			System.out.println("distance: " + distance);
			return distance;
		
	}
}

