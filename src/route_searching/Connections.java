package route_searching;

import java.util.*;
import java.util.Map.Entry;



public class Connections {
	
	private  LinkedList<String> visited = new LinkedList();
	private ArrayList<String> route = new ArrayList<String>();
	
	public int findRoutes(String start, String destination, HashMap<String, HashMap<String, Integer>> cities) {
		
		if (visited.size() > 3) {
			System.out.println("More than 2 stops");
			return 0;
		}
		
		if(visited.size() == 0) {
			visited.add(start);
		}
		
		
		//System.out.println("Start point: " + start + ", destination: " + destination);
		
		String currentStop = start;
		int distance = 0;
		
		//System.out.println(cities.get(start));

		if(cities.get(start).containsKey(destination)) {

			//System.out.println("Direct connection (" + start + " - " + destination +")"
			//		+ ", distance: " + cities.get(start).get(destination).intValue());
			
			return cities.get(start).get(destination);
			
		}
		
	
		    Iterator<Entry<String, Integer>> iter = cities.get(start).entrySet().iterator(); 
			Map.Entry<String, Integer> cityConnections;

				
				//tworzymy iterator po elementach hashmapy danego miasta
				//dla każdego miasta, z którym dane miasto ma połączenie, 
				//aby sprawdzić, które z nich ma połączenie z szukanym miastem.
				
			while(iter.hasNext()) {
				      
				cityConnections = (Map.Entry<String, Integer>)iter.next();
				
				if(visited.contains(cityConnections.getKey())){
					break;
				}else {
					visited.add(cityConnections.getKey());
				}
				currentStop = cityConnections.getKey();
				route.add(currentStop);
				System.out.println("current stop is: " + currentStop);

				distance = cityConnections.getValue() + findRoutes(currentStop, destination, cities); //dystans pomiędzy szukanymi miastami jest równy odległości pomiędzy obecnym miastem a początkowym i obecnym i docelowym
				
					
					System.out.println("");
					
					for(String city : route) {
						System.out.print(city + " ");
					}
					visited.remove(visited.size() - 1);
				
				System.out.println("Distance is: " + distance);
			}
			
			//System.out.println("The destination has been reached");
			return distance;
		
	}
	
	
	public void print(String start, String destination, HashMap<String, HashMap<String, Integer>> cities) {
		
		System.out.println("Start point: " + start);

		Iterator<Entry<String, Integer>> iter = cities.get(start).entrySet().iterator(); 
		Map.Entry<String, Integer> cityConnections = (Map.Entry<String, Integer>)iter.next();

		while(iter.hasNext()) {
			
			System.out.println("stop: " + cityConnections.getKey());
			System.out.println("cities of " + cityConnections.getKey() + ": " + cities.get(cityConnections.getKey()));
			
			
			Iterator<Entry<String, Integer>> iter2 = cities.get(cityConnections.getKey()).entrySet().iterator(); 
			Map.Entry<String, Integer> cityConnections2 = (Map.Entry<String, Integer>)iter2.next();

			
			while(iter2.hasNext()) {
				
				System.out.println("stop2: " + cityConnections2.getKey());
				System.out.println("cities of " + cityConnections2.getKey() + ": " + cities.get(cityConnections2.getKey()));
				
				cityConnections = (Map.Entry<String, Integer>)iter2.next();
				cityConnections = (Map.Entry<String, Integer>)iter2.next();

				
				if(!iter2.hasNext()) {
					System.out.println("Start point: " + cityConnections.getKey());

				}
			}
		
			cityConnections = (Map.Entry<String, Integer>)iter.next();
			
			if(!iter.hasNext()) {
				System.out.println("Start point: " + cityConnections.getKey());

			}
			break;
		}
		
	}
}

