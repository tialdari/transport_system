package main;

import data.Parser;
import java.util.regex.*;
import java.util.ArrayList;
import java.util.HashMap;

public class Main {
	
	public static void main (String [] args) {
		
		Parser parser = new Parser("zad4_data.txt");
		parser.read();
		
		for(HashMap city : parser.getAllCities()) {
			
			System.out.println(city);
		}
		
	}
}
