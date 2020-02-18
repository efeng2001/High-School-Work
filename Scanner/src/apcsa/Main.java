package apcsa;
import java.util.Scanner;


public class Main
{
	// Scanner scan = new Scanner(System.in);
	// scan.next();
	// scan.nextInt();
	// scan.nextLine();
	// scan.hasNextInt();
	// String str = scan.next();
	// str.toUpperCase();

	/**
	 * Using input validation, make sure that your program NEVER crashes!
	 */
	public static void main(String[] args)
	{
		Input.init();
		Input.reallyDifficultGuessingGame();		
		Input.close();
	}
}