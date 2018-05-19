package main;

import data.Parser;

import java.util.Map.Entry;
import data.IO;
import route_searching.Connections.*;
import java.util.*;
import route_searching.Connections;





public class Main {
	
	public static void main (String [] args) {
		
		//reads data from the text file
		Parser parser = new Parser("zad4_data.txt");
		parser.read();
		Map<String, HashMap<String, Integer>> cities = parser.getAllCities();
		
		System.out.println("Connection browser");
		IO io = new IO();
		boolean ifContinue = true;
			
		//collects the start and destination city from the user
		while(ifContinue) {
			System.out.println("\nChoose from: ");
			parser.print();
			System.out.println("\n\nStart point(type in the city): ");
			String startCity = io.input();
			char [] characters = startCity.toCharArray();
			characters[0] = Character.toUpperCase(characters[0]);

			startCity = "";
			for(int i = 0; i < characters.length; i ++ ) {
				
				startCity += characters[i];
			}
						
				while(!cities.containsKey(startCity)){
					System.out.println("No such city, please choose a city from the list above");
					System.out.println("\nStart point(type in the city): ");
					startCity = io.input();
				}
			
			System.out.println("");
			
			Iterator<Entry<String, HashMap<String, Integer>>> iter = cities.entrySet().iterator();
			Map.Entry<String, HashMap<String, Integer>> cityConnections = iter.next();
			        
			int number = 0;
			
			while(iter.hasNext()) {
				number++;
				if(number == 7)  System.out.println("");
		        cityConnections = (Map.Entry<String, HashMap<String, Integer>>)iter.next();
				if(cityConnections.getKey().equals(startCity)) continue;
				System.out.print(cityConnections.getKey() + "  ");
			}
			  
			  
			System.out.println("\n\nDestination(type in the city): ");
			String destinationCity = io.input();
			
			 characters = startCity.toCharArray();
			characters[0] = Character.toUpperCase(characters[0]);

			destinationCity = "";
			for(int i = 0; i < characters.length; i ++ ) {
				
				destinationCity += characters[i];
			}
	
			while(!cities.containsKey(destinationCity)){
				System.out.println("No such city, please choose a city from the list above");
				System.out.println("\nDestination(type in the city): ");
				destinationCity = io.input();
			}
	
			//finds possible connections prints them
			Connections connectionsBrowser = new Connections();
			Map<ArrayList<String>, Integer> connections = connectionsBrowser.findRoutes(startCity, destinationCity, cities);
			List<Map.Entry<ArrayList<String>, Integer>>list = new ArrayList<>(connections.entrySet());
			   
			//sort the results according to their length
			Collections.sort(list, new EntryKeyComparator());

			  
			System.out.println("\nPossible connections: ");
			  for (Map.Entry<ArrayList<String>, Integer> entry : list) {
			      System.out.println(entry.getKey() + "\n distance: " + entry.getValue() 
			      + "   changes no: " + (entry.getKey().size() - 2) + "\n");
			  }
	
			System.out.println("Do you want to continue?  yes/no");
			
			 if(io.input() == "yes") continue;
			 else break;
		}	
		
		
		System.out.println("End of programme");
	}
	
		
	 
}
