package data;

import java.util.Scanner;


public class IO {
	
	public String input() {
		Scanner input = new Scanner(System.in);
		if(input.hasNext("yes")) return "yes";
		
		String text = input.next();
		
		
		return text;
	}
}
