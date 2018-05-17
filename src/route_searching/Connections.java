package route_searching;

import java.util.*;
import java.util.Map.Entry;



public class Connections {
	
	private ArrayList<String> route = new ArrayList<String>();
	
	public int findRoutes(String start, String destination, HashMap<String, HashMap<String, Integer>> cities) {
		

		String currentCity;
		
		Iterator<Entry<String, Integer>> iterator = cities.get(start).entrySet().iterator(); 
		Map.Entry<String, Integer> cityConnections;
		  
		while(iterator.hasNext()) {
			
			
				ArrayList<String> visitedCities = new ArrayList<String>();
				visitedCities.add(start);


				cityConnections = (Map.Entry<String,Integer>)iterator.next();
				//System.out.println("\n\ncity: " +  cityConnections.getKey() + "\nsubcities: ");
				currentCity = cityConnections.getKey();
				/*
				if(visitedCities.size() == 1 || (visitedCities.size() == 2 && cities.get(currentCity).containsKey(destination))) {
					visitedCities.add(currentCity);
					if(cities.get(currentCity).containsKey(destination)) {
						System.out.println(visitedCities + " " + destination);
						visitedCities.remove(visitedCities.size() - 1);
					}
				}
				*/
				if(currentCity.equals(destination)) {
					if(cities.get(start).containsKey(destination)) {
						System.out.println(start+ " - " + destination + ": " + cities.get(start).get(destination).intValue());
					}
					continue;
				}	
				 visitedCities.add(currentCity);

				
				if(cities.get(currentCity).containsKey(destination) ) {
					System.out.println(visitedCities + " " + destination);
					//continue;
				}
				

				  Iterator<Entry<String, Integer>> innerIterator = cities.get(cityConnections.getKey()).entrySet().iterator(); 
				  Map.Entry<String, Integer> cityConnections2;
				  
				  while(innerIterator.hasNext()) {
						cityConnections2 = (Map.Entry<String, Integer>)innerIterator.next();
				      //  System.out.print("\n..." + cityConnections2.getKey() + "..., ");
						currentCity = cityConnections2.getKey();
						
						if(cities.get(currentCity).containsKey(destination)) {
							if(visitedCities.contains(currentCity)) {
								continue;
							}
							visitedCities.add(currentCity);
							System.out.println(visitedCities + " " + destination);
							visitedCities.remove(visitedCities.size() - 1);
						
						}	
				  }
				  
					//visitedCities.remove(visitedCities.size() - 1);

				  
				 		
		  }
		
		return 0;
	}
}	