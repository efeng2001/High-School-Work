package apcsa;

import java.util.Scanner;

public class Player
{
	private char playerID;
	private char botID;

	private Scanner scan;

	public Player()
	{
		scan = new Scanner(System.in);
	}

	public char getID()
	{
		return playerID;
	}

	public void setID(char playerID)
	{
		this.playerID = playerID;
		if (playerID == 'X')
		{
			this.botID = 'O';
		} else
		{
			this.botID = 'X';
		}
	}

	public String playAgain()
	{
		System.out.println("Play again?");
		String answer = scan.next().toUpperCase();
		scan.nextLine();
		return answer;
	}

	public Move doMove(char[][] board)
	{
		Move move = null;
		while (move == null)
		{
			int row = inputIndex();
			if (row != -1)
			{
				int col = inputIndex();
				if (col != -1)
				{
					move = new Move(col, row);
					scan.nextLine();
				}
			}
		}
		return move;
	}

	private int inputIndex()
	{
		if (scan.hasNextInt())
		{
			int index = scan.nextInt();
			if (index >= 0 && index < 3)
			{
				return index;
			}
		}

		System.out.println("Invalid input. Please enter two integers [0, 3) that are separated by a space!");
		scan.nextLine();
		return -1;
	}
}