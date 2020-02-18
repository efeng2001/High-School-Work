

package apcsa;

public class Game
{
	private static char turn;
	private static int turnCount;

	private static Player player;
	private static Bot bot;

	private static char[][] board;

	public static void main(String[] args)
	{
		player = new Player();
		bot = new Bot();
		board = new char[3][3];

		String playAgain = "YES";
		while (playAgain.equals("YES"))
		{
			gameLoop();
			playAgain = player.playAgain();
		}
	}

	private static void gameLoop()
	{
		resetGame();
		printBoard();
		boolean invalidMove = false;
		while (!invalidMove && !gameOver())
		{
			changeTurn();
			Move move = requestMove();
			if (validateMove(move))
			{
				board[move.getY()][move.getX()] = turn;
				printBoard();
			} else
			{
				invalidMove = true;
				changeTurn();
				System.out.println(turn + " wins!");
			}
		}
	}

	private static void resetGame()
	{
		turn = 'X';
		turnCount = 0;

		if (((int) (Math.random() * 2)) == 0)
		{
			player.setID('X');
			bot.setID('O');
		} else
		{
			player.setID('O');
			bot.setID('X');
		}

		for (int row = 0; row < 3; row++)
		{
			for (int col = 0; col < 3; col++)
			{
				board[row][col] = ' ';
			}
		}
	}

	private static void changeTurn()
	{
		if (turnCount > 0)
		{
			if (turn == player.getID())
			{
				turn = bot.getID();
			} else
			{
				turn = player.getID();
			}
		}
		turnCount++;
	}

	private static Move requestMove()
	{
		if (turn == player.getID())
		{
			System.out.println("Player's turn (" + turn + ")!");
			return player.doMove(board);
		} else
		{
			System.out.println("Bot's turn (" + turn + ")!");
			return bot.doMove(board, turnCount);
		}
	}

	private static boolean validateMove(Move move)
	{
		String errorMsg = "Invalid move!";

		if (move.getY() < 0 || move.getY() >= 3)
		{
			System.out.println(errorMsg);
			return false;
		}

		if (move.getX() < 0 || move.getX() >= 3)
		{
			System.out.println(errorMsg);
			return false;
		}

		if (board[move.getY()][move.getX()] != ' ')
		{
			System.out.println(errorMsg);
			return false;
		}

		return true;
	}

	private static boolean gameOver()
	{
		String winMsg = turn + " wins!";

		if (horizontalWin())
		{
			System.out.println(winMsg);
			return true;
		}

		if (verticalWin())
		{
			System.out.println(winMsg);
			return true;
		}

		if (diagonalWin())
		{
			System.out.println(winMsg);
			return true;
		}

		if (boardFull())
		{
			System.out.println("Tie game!");
			return true;
		}

		return false;
	}

	private static boolean horizontalWin()
	{
		for (int row = 0; row < 3; row++)
		{
			if (board[row][0] == turn && board[row][1] == turn && board[row][2] == turn)
			{
				return true;
			}
		}
		return false;
	}

	private static boolean verticalWin()
	{
		for (int col = 0; col < 3; col++)
		{
			if (board[0][col] == turn && board[1][col] == turn && board[2][col] == turn)
			{
				return true;
			}
		}
		return false;
	}

	private static boolean diagonalWin()
	{
		if (board[1][1] == turn)
		{
			if (board[0][0] == turn && board[2][2] == turn)
			{
				return true;
			}

			if (board[0][2] == turn && board[2][0] == turn)
			{
				return true;
			}
		}
		return false;
	}

	private static boolean boardFull()
	{
		for (int row = 0; row < 3; row++)
		{
			for (int col = 0; col < 3; col++)
			{
				if (board[row][col] == ' ')
				{
					return false;
				}
			}
		}
		return true;
	}

	private static void printBoard()
	{
		System.out.println(" " + board[0][0] + " | " + board[0][1] + " | " + board[0][2]);
		System.out.println("---+---+---");
		System.out.println(" " + board[1][0] + " | " + board[1][1] + " | " + board[1][2]);
		System.out.println("---+---+---");
		System.out.println(" " + board[2][0] + " | " + board[2][1] + " | " + board[2][2]);
	}
}