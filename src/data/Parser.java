
package data;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.Map.Entry;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

//class which reads data from a file and puts it in a nested hashMap for the further processing
//key of the hashMap is a name of a city, value is another hashMap that contains all the possible connections from that city
//a key in a second hashMap is a name of a city, and the value is the distance between both cities

public class Parser {
	
	
	private File file;
	private HashMap<String, HashMap<String, Integer>> allCities;
	private Scanner sc; 
    private String line;
    private String [] info;
	
	public Parser() {
		file = new File("zad4_data.txt");
		allCities = new HashMap<String, HashMap<String, Integer>>();
		try{
			sc = new Scanner(file);
		}catch(FileNotFoundException ex) {
			System.out.println("File not found");
		}
          
        line = sc.nextLine(); 
        info = new String[3];
      
        
	}
	
	public Parser(String fileName) {
		file = new File(fileName);
		allCities = new HashMap<String, HashMap<String, Integer>>();
		try{
			sc = new Scanner(file);
		}catch(FileNotFoundException ex) {
			System.out.println("File not found");
		}
                    
        line = sc.nextLine(); 
        info = new String[3];
       
	}

	
	public HashMap<String, HashMap<String, Integer>> getAllCities() {
		return allCities;
	}

	public void setAllCities(HashMap<String, HashMap<String, Integer>> allCities) {
		this.allCities = allCities;
	}

	public void  read() {
		
            while(sc.hasNext()) {

            
            			//we omit all the lines that doesn't contain a connection 
	                while ((!line.matches(".*HZ.*") || !line.matches(".*HW.*") ||
	                		   !line.matches(".*HC.*")) && sc.hasNext()) {
	                		
	                		//we ommit all the blank lines
	                		if (!line.contains("-")) {
		                    line = sc.nextLine();
	                			break;
	                		}
	                		
	                		//we add a connection from the current line
		                	addConnection();
			 			line = sc.nextLine();	
			 			
			 			//if scanner doesn't have more lines, we have to add the connection from the last one now
		                 if(!sc.hasNextLine()) {	
		     				addConnection();
		                 }
		                 
	                }
                }
            
            sc.close(); 
            
	}
	
	
	
	public void addConnection() {
		
				//" - "  and parenthesis delimeters are used to split the line and read the data 
				info = line.split(" - | \\(|\\)");
				info = line.split(" - | \\(|\\)");
				info = line.split(" - | \\(|\\)");
		   
				//if the main hashMap contains a key of the current city, 
				//we just add a new connection to the hasMap of that city
				if(allCities.containsKey(info[0])) {
		    			allCities.get(info[0]).put(info[1], Integer.parseInt(info[2]));
				}else {
					//if not, we put a new key(the name of the city) first
		    			allCities.put(info[0], new HashMap<String, Integer>());
		    			allCities.get(info[0]).put(info[1], Integer.parseInt(info[2]));
				}
		    
		
				//since all the connections work both ways, we repeat the action for the second city
				if(allCities.containsKey(info[1])) {
					allCities.get(info[1]).put(info[0], Integer.parseInt(info[2]));
				}else {

		    			allCities.put(info[1], new HashMap<String, Integer>());
		    			allCities.get(info[1]).put(info[0], Integer.parseInt(info[2]));
				}
		    
		
	}
	
	//a method for printing the names of all cities
	public void print() {

		Iterator<Entry<String, HashMap<String, Integer>>> iter = getAllCities().entrySet().iterator();
		Map.Entry<String, HashMap<String, Integer>> cityConnections;
		
        System.out.println("");

        int number = 0;
        
		while(iter.hasNext()) {
			number++;
			if(number == 7) {
				System.out.println("");
			}
	        cityConnections = (Map.Entry<String, HashMap<String, Integer>>)iter.next();
			System.out.print(cityConnections.getKey() + " ");

		}
	}
	
	
}

