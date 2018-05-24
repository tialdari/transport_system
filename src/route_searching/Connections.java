package route_searching;

import java.util.*;
import java.util.Map.Entry;



public class Connections {
	
	private ArrayList<String> visitedCities;
	private Map<ArrayList<String>, Integer> possibleRoutes;
	
	public Connections() {
		possibleRoutes = new HashMap<ArrayList<String>, Integer>();
	}
	
	//a method that finds the possible connections between the cities passed as arguments
	public Map<ArrayList<String>, Integer> findRoutes(String start, String destination, Map<String, HashMap<String, Integer>> cities) {
		
		int distance = 0;
		String currentCity;
		
		//create an iterator to iterate through the connections of the start city
		Iterator<Entry<String, Integer>> iterator = cities.get(start).entrySet().iterator(); 
		Map.Entry<String, Integer> cityConnections;
		
		//list for saving names of the cities which are a complete route from the start to the destination city
		visitedCities = new ArrayList<String>();

		//if start has a direct connection to the destination city, return the connection and leave the method
		if(cities.get(start).containsKey(destination)) {
			distance += 	cities.get(start).get(destination).intValue();
			visitedCities.add(start);
			visitedCities.add(destination);
			possibleRoutes.put(new ArrayList<String>(visitedCities), distance);
			return possibleRoutes;
		}
		  
		//nested while loops for seraching all the possible connections
		while(iterator.hasNext()) {
			
				distance = 0;
			
				//we clean visitedCities every we go through the loop
				visitedCities = new ArrayList<String>();
				visitedCities.add(start);

				cityConnections = (Map.Entry<String,Integer>)iterator.next();
				currentCity = cityConnections.getKey();
			
				
				visitedCities.add(currentCity);
				distance += cityConnections.getValue();

				//if the second city contains the connection to the destination city, 
				//we add this option to the possibleRoutes array
				if(cities.get(currentCity).containsKey(destination) ) {
					distance += 	cities.get(currentCity).get(destination).intValue();
					visitedCities.add(destination);
					possibleRoutes.put(new ArrayList<String>(visitedCities), distance);
					
					//we decrease the saved distance and we remove the destination city, to find other possible routes;
					distance -= 	cities.get(currentCity).get(destination).intValue();
					removeCity();					
				}
				
				//create an iterator to iterate through the connections of the first stop city
				//at this moment we are looking for a 2 - stop route
				  Iterator<Entry<String, Integer>> innerIterator = cities.get(cityConnections.getKey()).entrySet().iterator(); 
				  Map.Entry<String, Integer> cityConnections2;
				  
				  while(innerIterator.hasNext()) {
						cityConnections2 = (Map.Entry<String, Integer>)innerIterator.next();
						currentCity = cityConnections2.getKey();
						
						//if we find a possible connection, we add it to possibleRoutes
						if(cities.get(currentCity).containsKey(destination)) {
							if(visitedCities.contains(currentCity)) {
								continue;
							}
							visitedCities.add(currentCity);
							visitedCities.add(destination);
							distance += cityConnections2.getValue();
							distance += 	cities.get(currentCity).get(destination).intValue();
							possibleRoutes.put(new ArrayList<String>(visitedCities), distance);
							
							//again, we decrease the counted distance and two last cities (the destination and the one before
							//to find other possibleRoutes
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
		//a comparator which enables comparing obtained routes by stops number
		public static class EntryKeyComparator implements Comparator<Map.Entry<ArrayList<String>, Integer>>{
			
			public int compare(Map.Entry<ArrayList<String>, Integer> left,
						Map.Entry<ArrayList<String>, Integer> right) {     
				
				int difference = Integer.compare(left.getKey().size(), right.getKey().size());

				if(difference != 0) return  difference;
				
				//if the stops number is the same, compare by distance
				else return Integer.compare(left.getValue(), right.getValue());
			}
		}
		
		//a comparator which enables comparing obtained routes by the distance to cross
		public static class EntryValueComparator implements Comparator<Map.Entry<ArrayList<String>, Integer>>{
			
			public int compare(Map.Entry<ArrayList<String>, Integer> left,
						Map.Entry<ArrayList<String>, Integer> right) {     
				
				 return Integer.compare(left.getValue(), right.getValue());
			}
		}
}