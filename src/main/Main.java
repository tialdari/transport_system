package main;

import data.Parser;
import data.IO;


public class Main {
	
	public static void main (String [] args) {
		
		Parser parser = new Parser("zad4_data.txt");
		parser.read();
		
		IO io = new IO();
		System.out.println(io.input());
		
		/*
		Iterator<Entry<String, HashMap<String, Integer>>> iter = parser.getAllCities().entrySet().iterator();
		Map.Entry<String, HashMap<String, Integer>> cityConnections;
		
		while(iter.hasNext()) {
	        cityConnections = (Map.Entry<String, HashMap<String, Integer>>)iter.next();

			System.out.println("Connections of " + cityConnections.getKey() + ": " + cityConnections.getValue());
		}
		*/
		
	

	}
}
