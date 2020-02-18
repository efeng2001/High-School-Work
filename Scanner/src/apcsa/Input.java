package apcsa;

import java.util.Scanner;

public class Input
{
	/**
	 * Ask for the user's name then give them a personalized good morning message.
	 */
	private static Scanner scan;
	
	public static void init()
	{
		scan = new Scanner(System.in);
	}
	
	public static void close()
	{
		scan.close();
	}
	
	public static void goodMorning()
	{
		System.out.println("What's your name?");
		String name = scan.next();
		System.out.println("Goodmorning " + name);
	}

	/**
	 * Copy a mad-take from www.madtakes.com or make your own!
	 */
	public static void madtake()
	{
		System.out.println("NOUN: ");
		String noun = scan.next();
		System.out.println("NOUN (PLURAL): ");
		String pluralNoun = scan.next();
		System.out.println("NOUN: ");
		String noun2 = scan.next();
		System.out.println("PLACE: ");
		String place = scan.next();
		System.out.println("ADJECTIVE: ");
		String adjective = scan.next();
		System.out.println("NOUN: ");
		String noun3 = scan.next();
		
		System.out.print("Be kind to your " + noun + "-footed " + pluralNoun +"\n" + 
						"For a duck may be somebody`s " + noun2+ ",\n" + 
						"Be kind to your " + noun2 + " in " + place + "\n" + 
						"Where the weather is always " + adjective + ".\n" + 
						"\n" + 
						"You may think that this is the " + noun3+ ",\n" + 
						"Well it is.	\n");
	}

	/**
	 * Ask the user if they want to play again, and again, and again . . . until
	 * they say they don't want to anymore.
	 */
	public static void gameLoop()
	{
		System.out.println("Do you want to play a game?");
		String answer = scan.next().toUpperCase();
		if(answer.equals("YES"))
		{
			gameLoop();
		}else {
			System.out.println("See you next again.");
		}
	}

	/**
	 * Decide how big your board is. Ask the user for two numbers (separated by a
	 * space) and let them know if their move was valid based on the dimensions of
	 * the board. Remember that the top-left corner of the board is at (0, 0). If
	 * their input was not valid, let them try again!
	 */
	public static void inputForGenericSquareBoardGame()
	{
		System.out.println("Give two positive numbers:");
		int rangeX = 10;
		int rangeY = 10;
		if(scan.hasNextInt())
		{	
			int x = scan.nextInt();
			if(scan.hasNextInt())
			{	
				int y = scan.nextInt();
				if(x<0 || y<0)
				{
					System.out.println("Negative Number");
					inputForGenericSquareBoardGame();
				}else if(x <= rangeX && y <= rangeY){
					System.out.println("Valid");
				}else {
				System.out.println("Unvalid");
				inputForGenericSquareBoardGame();
				}
			}else {
				System.out.println("Error");
				scan.nextLine();
				inputForGenericSquareBoardGame();
			}
		}else {
			System.out.println("Error");
			scan.nextLine();
			inputForGenericSquareBoardGame();
		}
	}

	/**
	 * Generate a random integer. Ask the user to guess what it is (give them the
	 * range). Let them know if they were correct or incorrect (make a fun message
	 * either way). Ask them if they'd like to play again!
	 */
	public static void reallyDifficultGuessingGame()
	{
		int range = (int)(Math.random()*100);
		int num = (int)(Math.random()*range);
		System.out.println(num);
		System.out.println("Guess the numbers (num < " + range + ")");
		while(!scan.hasNextInt())
		{
			System.out.println("Error");
			scan.nextLine();
			reallyDifficultGuessingGame();
		}
		int guess = scan.nextInt();
		if(guess == num)
		{
			System.out.println("Correct");
			System.out.println("Play Again?");
			String answer = scan.next().toUpperCase();
			if(answer.equals("YES"))
			{
				reallyDifficultGuessingGame();
			}else {
				System.out.println("See you next again.");
			}
		}else {
			System.out.println("Wrong");
			System.out.println("Play Again?");
			String answer = scan.next().toUpperCase();
			if(answer.equals("YES"))
			{
				reallyDifficultGuessingGame();
			}else {
				System.out.println("See you next again.");
			}
		}
	}
}