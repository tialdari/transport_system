package route_searching;

import java.util.*;
import java.util.Map.Entry;



public class Connections {
	
	private ArrayList<String> visitedCities;
	private HashMap<ArrayList<String>, Integer> possibleRoutes;
	
	public Connections() {
		possibleRoutes = new HashMap<ArrayList<String>, Integer>();
	}
	
	
	public HashMap<ArrayList<String>, Integer> findRoutes(String start, String destination, HashMap<String, HashMap<String, Integer>> cities) {
		
		int distance = 0;
		String currentCity;
		
		Iterator<Entry<String, Integer>> iterator = cities.get(start).entrySet().iterator(); 
		Map.Entry<String, Integer> cityConnections;
		
		visitedCities = new ArrayList<String>();

		
		if(cities.get(start).containsKey(destination)) {
			distance += 	cities.get(start).get(destination).intValue();
			visitedCities.add(start);
			visitedCities.add(destination);
			possibleRoutes.put(new ArrayList<String>(visitedCities), distance);
			return possibleRoutes;
		}
		  
		while(iterator.hasNext()) {
			
				distance = 0;
			
				visitedCities = new ArrayList<String>();
				visitedCities.add(start);

				cityConnections = (Map.Entry<String,Integer>)iterator.next();
				currentCity = cityConnections.getKey();
			
				 visitedCities.add(currentCity);
				distance += cityConnections.getValue();



				
				if(cities.get(currentCity).containsKey(destination) ) {
					distance += 	cities.get(currentCity).get(destination).intValue();
					visitedCities.add(destination);
					possibleRoutes.put(new ArrayList<String>(visitedCities), distance);
					distance -= 	cities.get(currentCity).get(destination).intValue();
					removeCity();					
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
							distance += cityConnections2.getValue();
							distance += 	cities.get(currentCity).get(destination).intValue();
							possibleRoutes.put(new ArrayList<String>(visitedCities), distance);
							distance -= cityConnections2.getValue();
							distance -= 	cities.get(currentCity).get(destination).intValue();
							
							removeCity();	
							removeCity();					

						}	
				  }
				  
		  }
		
		return possibleRoutes;
	}
	
	public void removeCity() {
		visitedCities.remove(visitedCities.size() - 1);						
	}
	
	/*
	public void increaseDistance(String city, String destination) {
		distance += 	cities.get(city).get(destination).intValue();
		
	}
	*/
	
		public static class EntryComparator implements Comparator<Map.Entry<ArrayList<String>, Integer>>{
			
			public int compare(Map.Entry<ArrayList<String>, Integer> left,
						Map.Entry<ArrayList<String>, Integer> right) {     
				// Right then left to get a descending order
				return Integer.compare(right.getKey().size(), left.getKey().size());
			}
		}
}