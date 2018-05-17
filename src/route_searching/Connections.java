package route_searching;

import java.util.*;
import java.util.Map.Entry;



public class Connections {
	
	private ArrayList<ArrayList<String>> possibleRoutes = new ArrayList<ArrayList<String>>();
	
	public ArrayList<ArrayList<String>> findRoutes(String start, String destination, HashMap<String, HashMap<String, Integer>> cities) {
		

		String currentCity;
		
		Iterator<Entry<String, Integer>> iterator = cities.get(start).entrySet().iterator(); 
		Map.Entry<String, Integer> cityConnections;
		
		ArrayList<String> visitedCities;
		  
		while(iterator.hasNext()) {
			
				visitedCities = new ArrayList<String>();
				visitedCities.add(start);

				cityConnections = (Map.Entry<String,Integer>)iterator.next();
				currentCity = cityConnections.getKey();
				
				if(currentCity.equals(destination)) {
					if(cities.get(start).containsKey(destination)) {
						visitedCities.add(destination);
						possibleRoutes.add(visitedCities);
						System.out.println(visitedCities);
					}
					break;
				}	
				 visitedCities.add(currentCity);

				
				if(cities.get(currentCity).containsKey(destination) ) {
					visitedCities.add(destination);
					possibleRoutes.add(visitedCities);
					System.out.println(visitedCities);

					visitedCities.remove(visitedCities.size() - 1);
				}
				

				  Iterator<Entry<String, Integer>> innerIterator = cities.get(cityConnections.getKey()).entrySet().iterator(); 
				  Map.Entry<String, Integer> cityConnections2;
				  
				  while(innerIterator.hasNext()) {
						cityConnections2 = (Map.Entry<String, Integer>)innerIterator.next();
						currentCity = cityConnections2.getKey();
						
						if(cities.get(currentCity).containsKey(destination)) {
							if(visitedCities.contains(currentCity)) {
								continue;
							}
							visitedCities.add(currentCity);
							visitedCities.add(destination);
							possibleRoutes.add(visitedCities);
							System.out.println(visitedCities);
							visitedCities.remove(visitedCities.size() - 1);
							visitedCities.remove(visitedCities.size() - 1);						
						}	
				  }
				  
		  }
		
		return possibleRoutes;
	}
}