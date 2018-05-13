package data;

import java.util.Scanner;


public class IO {
	
	public String input() {
		Scanner input = new Scanner(System.in);
		
		String text = input.nextLine();
		
		input.close();
		
		return text;
	}
}
