import java.util.Scanner;

public class Driver {
	
	public static void main(String[] args) {
	
		Scanner input = new Scanner(System.in);
		System.out.println("Welcome to QuickFlix!\n What would you like to do today?\n");
		System.out.println("(Type: Add, Rate, Edit, Delete, or Exit\n");
		
		if (input.nextLine().equals("Add")) {
			//call add method
			
		}
		else if (input.nextLine().equals("Rate")) {
			//call rate method
		}
		else if (input.nextLine().equals("Edit")) {
			//call edit method
		}
		else if (input.nextLine().equals("Delete")) {
			//call delete method
		}
		else if (input.nextLine().equals("Exit")) {
			//terminate program
		}
		else {
			System.out.println("Sorry, please try entering in one of the given options!");
			//restart loop
		}
	}
}