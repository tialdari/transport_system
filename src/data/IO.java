package data;

import java.util.Scanner; 

//class which gets the input from a user

public class IO {
	
	public String input() {
		Scanner input = new Scanner(System.in);
		String text = input.nextLine();
		return text;
	}
}
