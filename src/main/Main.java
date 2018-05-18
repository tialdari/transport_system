package main;

import data.Parser;

import java.util.Map.Entry;

import data.IO;
import route_searching.Connections;
import java.util.*;



public class Main {
	
	public static void main (String [] args) {
		
		Parser parser = new Parser("zad4_data.txt");
		parser.read();

		
		//IO io = new IO();
	//	System.out.println(io.input());
		
		Connections connectionsBrowser = new Connections();
		//System.out.println(connectionsBrowser.findRoutes("Lusitania", "Angmar", parser.getAllCities()));
		
		for(ArrayList<String> routes : connectionsBrowser.findRoutes("Gondolin", "Trondheim", parser.getAllCities())) {
			//System.out.println(routes);
		}

		
		Iterator<Entry<String, HashMap<String, Integer>>> iter = parser.getAllCities().entrySet().iterator();
		Map.Entry<String, HashMap<String, Integer>> cityConnections;
		
        System.out.println("");

		while(iter.hasNext()) {
	        cityConnections = (Map.Entry<String, HashMap<String, Integer>>)iter.next();
			System.out.println("Connections of " + cityConnections.getKey() + ": " + cityConnections.getValue());

		}
		
		
		
	

	}
}
