package route_searching;

import java.util.*;
import java.util.Map.Entry;



public class Connections {
	
	private ArrayList<String> route = new ArrayList<String>();
	
	public int findRoutes(String start, String destination, HashMap<String, HashMap<String, Integer>> cities) {
		

		  Iterator<Entry<String, HashMap<String, Integer>>> iterator = cities.entrySet().iterator(); 
		  Map.Entry<String, HashMap<String, Integer>> cityConnections;
		  
		  while(iterator.hasNext()) {
				cityConnections = (Map.Entry<String, HashMap<String, Integer>>)iterator.next();
				System.out.println("\n\ncity: " +  cityConnections.getKey() + "\nsubcities: ");
				
				  Iterator<Entry<String, Integer>> innerIterator = cities.get(cityConnections.getKey()).entrySet().iterator(); 
				  Map.Entry<String, Integer> cityConnections2;
				  
				  while(innerIterator.hasNext()) {
						cityConnections2 = (Map.Entry<String, Integer>)innerIterator.next();
				        System.out.print("\n..." + cityConnections2.getKey() + "..., ");
				        
				        Iterator<Entry<String, Integer>> innerIterator2 = cities.get(cityConnections2.getKey()).entrySet().iterator(); 
						  Map.Entry<String, Integer> cityConnections3;
						  
						System.out.println("\nsubcities of the subcity: ");

						  while(innerIterator2.hasNext()) {
								cityConnections3 = (Map.Entry<String, Integer>)innerIterator2.next();
						        System.out.print(cityConnections3.getKey() + ", ");
						  }
				  }
		  }
		
		return 0;
	}
}	