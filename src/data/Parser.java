
package data;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.HashMap;
import java.util.HashSet;


public class Parser {
	
	
	private File file;
	private HashSet<HashMap> allCities;
	
	public Parser() {
		file = new File("zad4_data.txt");
		allCities = new HashSet<HashMap>();
		
	}
	
	public Parser(String fileName) {
		file = new File(fileName);
		allCities = new HashSet<HashMap>();
	
	}

	
	
	
	public HashSet<HashMap> getAllCities() {
		return allCities;
	}

	public void setAllCities(HashSet<HashMap> allCities) {
		this.allCities = allCities;
	}

	public void  read() {
		
		HashMap<String, HashMap<String, Integer>> connections;
		HashMap<String, Integer> distances;
		
		try{
			
            Scanner sc = new Scanner(file);
            
            String line = sc.nextLine();
            String cityName;
            int distance;
            String [] info = new String[100];
            int [] nums;
           

            while(sc.hasNext()) {

	                if (line.matches(".*H.*")) {
	                	
	                    System.out.println(line);
	                    line = sc.nextLine();
	
	                }

	                
	                while ((!line.matches(".*HZ.*") || !line.matches(".*HW.*") ||
	                		   !line.matches(".*HC.*")) && sc.hasNext()) {
	                		
	                		if (!line.contains("-")) {
		                    
	                			line = sc.nextLine();
	                			break;
	                		}
	                		
		                		info = line.split(" - | \\(|\\)");
		                    System.out.print(info[0]);
		                    
	                			info = line.split(" - | \\(|\\)");
		                    System.out.print(info[1]);
		                    
		                    
		                    info = line.split(" - | \\(|\\)");
		                    System.out.println(info[2]);
		                    
		                    connections = new HashMap<String, HashMap<String, Integer>>();
		                    distances = new HashMap<String, Integer>();
		                    
		                    distances.put(info[1], Integer.parseInt(info[2]));
		                    connections.put(info[0], distances);
		                    
		                    allCities.add(connections);
		                    
		                    
		                    line = sc.nextLine();
		                    
		                    if(!sc.hasNextLine()) {
		                    		info = line.split(" - | \\(|\\)");
			                    System.out.print(info[0]);
			                    
		                			info = line.split(" - | \\(|\\)");
			                    System.out.print(info[1]);
			                    
			                    
			                    info = line.split(" - | \\(|\\)");
			                    System.out.println(info[2]);
			                    
			                    connections = new HashMap<String, HashMap<String, Integer>>();
			                    distances = new HashMap<String, Integer>();
			                    
			                    distances.put(info[1], Integer.parseInt(info[2]));
			                    connections.put(info[0], distances);
			                    
			                    allCities.add(connections);
		                    }

	                }
                }
            
            sc.close(); 
            
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

		
	}
    
}

