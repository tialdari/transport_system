
package data;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.HashMap;


public class Parser {
	
	
	private File file;
	private ArrayList<HashMap> allCities;
	private HashMap<String, String> connections;
	private HashMap<String, Integer> distances;
	
	public Parser() {
		file = new File("zad4_data.txt");
		allCities = new ArrayList<HashMap>();
		connections = new HashMap<String, String>(12);
		distances = new HashMap<String, Integer>(12);
	}
	
	public Parser(String fileName) {
		file = new File(fileName);
		allCities = new ArrayList<HashMap>();
		connections = new HashMap<String, String>(12);
		distances = new HashMap<String, Integer>(12);
	}


	public void  read() {
		
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
		                    
	                			System.out.println("blank line");
	                			line = sc.nextLine();
	                			break;
	                		}
	                	
	                	                		
		                		info = line.split("-|\\(|\\)");
		                    System.out.print(info[0] + ".");
		                    
	                			info = line.split("-|\\(|\\)");
		                    System.out.print(info[1] + ".");
		                    
		                    info = line.split("-|\\(|\\)");
		                    System.out.println(info[2] + ".loop ended");

		                    line = sc.nextLine();

	                }
                }
            
            sc.close(); 
            
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

		
	}
    
}

