
package data;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.HashMap;


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

	                if (line.matches(".*H.*")) {
	                	
	                    line = sc.nextLine();
	                }

	                while ((!line.matches(".*HZ.*") || !line.matches(".*HW.*") ||
	                		   !line.matches(".*HC.*")) && sc.hasNext()) {
	                		
	                		if (!line.contains("-")) {
		                    line = sc.nextLine();
	                			break;
	                		}
	                		
		                	addConnection();
			 			line = sc.nextLine();	

		                 if(!sc.hasNextLine()) {	
		     				addConnection();
		                 }
		                 
	                }
                }
            
            sc.close(); 
            
	}
	
	
	
	public void addConnection() {
		
		
				info = line.split(" - | \\(|\\)");
				info = line.split(" - | \\(|\\)");
				info = line.split(" - | \\(|\\)");
		   
				if(allCities.containsKey(info[0])) {
		    			allCities.get(info[0]).put(info[1], Integer.parseInt(info[2]));
				}else {
		    			allCities.put(info[0], new HashMap<String, Integer>());
		    			allCities.get(info[0]).put(info[1], Integer.parseInt(info[2]));
				}
		    
		
		    
				if(allCities.containsKey(info[1])) {
					allCities.get(info[1]).put(info[0], Integer.parseInt(info[2]));
				}else {
					
		    			allCities.put(info[1], new HashMap<String, Integer>());
		    			allCities.get(info[1]).put(info[0], Integer.parseInt(info[2]));
				}
		    
		
	}
	
	
}

