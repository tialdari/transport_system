package main;

import java.util.Map.Entry;
import java.util.*;
import data.*;
import route_searching.*;
import route_searching.Connections.*;



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
			
			
			//we put the intput to the char array to switch the first char to upper Case
			//in case users don't use upper case themselves
			char [] characters;
			while(true) {
				characters = startCity.toCharArray();
				characters[0] = Character.toUpperCase(characters[0]);
	
				//we convert the char array back into a string
				startCity = "";
				for(int i = 0; i < characters.length; i ++ ) {
					
					startCity += characters[i];
				}
					//the loop continues until the given name is spelled correctly
					if(!cities.containsKey(startCity)){
						System.out.println("No such city, please choose a city from the list above");
						System.out.println("\nStart point(type in the city): ");
						startCity = io.input();
					}else break;
			}
			
			System.out.println("");
			
			//we print all the cities again (minus the one that the user has just chosen)
			//to choose the destination city from
			
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
			
			
			//repeat the upper case security
			while(true) {
					characters = destinationCity.toCharArray();
					characters[0] = Character.toUpperCase(characters[0]);
		
					destinationCity = "";
					for(int i = 0; i < characters.length; i ++ ) {
						
						destinationCity += characters[i];
					}
			
					if(!cities.containsKey(destinationCity)){
						System.out.println("No such city, please choose a city from the list above");
						System.out.println("\nDestination(type in the city): ");
						destinationCity = io.input();
					}else break;
			}
			
			//finds possible connections and prints them
			Connections connectionsBrowser = new Connections();
			Map<ArrayList<String>, Integer> connections = connectionsBrowser.findRoutes(startCity, destinationCity, cities);
			List<Map.Entry<ArrayList<String>, Integer>>list = new ArrayList<>(connections.entrySet());
			   
			//user chooses how he wishes the data to be sorted
			System.out.println("Choose the type of sorting: stops number - 0; distance - 1");

			System.out.println("Sort by(type in the number):");
			
			String sorting = io.input();
			
			//program sorts accordingly
			while(true) {
				if(sorting.equals("0")) {
					Collections.sort(list, new EntryKeyComparator());
					break;
				}else if(sorting.equals("1")) {
					Collections.sort(list, new EntryValueComparator());
					break;
				}
				
				//in case the input was neither 0 or 1, the loop continues
				 System.out.println("No such option, please write 0 or 1");
				 sorting = io.input();
			}
			
			//print the possible connections
			System.out.println("\nPossible connections: ");
			  for (Map.Entry<ArrayList<String>, Integer> entry : list) {
			      System.out.println(entry.getKey() + "\n distance: " + entry.getValue() 
			      + "   changes no: " + (entry.getKey().size() - 2) + "\n");
			  }
		
			//the possibility of changing the sorting method
				while(true) {
					System.out.println("Do you want to change the sorting method?  yes/no");
					String answer = io.input();
					
					if(answer.equals("yes")) {
							if(sorting.equals("0")) {
								Collections.sort(list, new EntryValueComparator());
								sorting = "1";
							}else if(sorting.equals("1")) {
								Collections.sort(list, new EntryKeyComparator());
								sorting = "0";
							}
							
							for (Map.Entry<ArrayList<String>, Integer> entry : list) {
							      System.out.println(entry.getKey() + "\n distance: " + entry.getValue() 
							      + "   changes no: " + (entry.getKey().size() - 2) + "\n");
							}
							
					}else if(answer.equals("no")) { 
						break;
					}else {
						 System.out.println("No such option, please write 0 or 1");
						 sorting = io.input();
					}
				}
			
			//the programme asks whether to continue
			System.out.println("Do you want to continue?  yes/no");
			
			 if(io.input().equals("yes")) continue;
			 else break;
		}	
		
		
		System.out.println("End of the programme");
		
	}
	
		
	 
}
