package apcsa;

import java.util.ArrayList;
import java.util.List;

public class Bot
{
	private char botID;
	private char playerID;
	

	public char getID()
	{
		return botID;
	}

	public void setID(char botID)
	{
		this.botID = botID;
		if (botID == 'X')
		{
			this.playerID = 'O';
		} else
		{
			this.playerID = 'X';
		}
	}

	public Move doMove(char[][] board, int turnCount) {
		// TODO: Write a rule-based AI!
		// TODO: Delete my random move code below!

		List<Move> validMoves = new ArrayList<Move>();
		for (int row = 0; row < 3; row++) {
			for (int col = 0; col < 3; col++) {
				if (board[row][col] == ' ') {
					validMoves.add(new Move(col, row));
				}
			}
		}
		List<Move> validCorner = new ArrayList<Move>();
		for (int row = 0; row < 3; row++) {
			for (int col = 0; col < 3; col++) {
				if (row != 1 && (row+col)%2==0 && board[row][col] == ' ' ) {
					validCorner.add(new Move(col, row));
				}
			}
		}
		
		
		Move move;
		if (board[1][1] == ' ') {
			return new Move(1, 1);
		} else if ((move = threeInARow(board, validMoves, botID)) != null) {
			return move;
		}else if((move = threeInARow(board, validMoves, playerID)) != null){
			return move;
		}else if((move = BlockDoubleWinSituation(board, turnCount)) != null){
			return move;
		}else if((move = CreateDoubleWinSituation(board, turnCount)) != null){
			return move;
		}
		
		move = validCorner.get((int) (Math.random() * validCorner.size()));
		return move;
	}
	
	private Move BlockDoubleWinSituation(char[][] board, int turnCount) 
	{
		List<Move> validSides = new ArrayList<Move>();
		List<Move> playerMoves = new ArrayList<Move>();
		for (int row = 0; row < 3; row++) {
			for (int col = 0; col < 3; col++) {
				if ((row+col)%2==1 && board[row][col] == ' ' ) {
					validSides.add(new Move(col, row));
				}else if(board[row][col] == playerID){
					playerMoves.add(new Move(col,row));
				}
			}
		}
		
		Move move;
		if(turnCount == 4 && doubleWinSituation1(board))
		{
			move = validSides.get((int) (Math.random() * validSides.size()));
			return move;
		}else if(turnCount == 4 && doubleWinSituation2(board))
		{
			int x =0;
			int y =0;
			for(Move player: playerMoves)
			{
				if(player.getX()%2==0) {
					x = player.getX();
				}else if(player.getY()%2==0) {
					y = player.getY();
				}
			}
			return new Move(x,y);
		}
		return null;
	}
	
	private boolean doubleWinSituation1(char[][] board)
	{
		boolean doubleWinSituation = false;

		if (board[1][1] == botID && board[0][2] == playerID && board[2][0] == playerID) {
			doubleWinSituation = true;
		}else if(board[1][1] == botID && board[0][0] == playerID && board[2][2] == playerID){
			doubleWinSituation = true;
		}

		return doubleWinSituation;
	}
	
	private boolean doubleWinSituation2(char[][] board)
	{
		boolean doubleWinSituation = false;

		if (board[1][1] == botID && board[1][2] == playerID && board[2][0] == playerID) {
			doubleWinSituation = true;
		}else if (board[1][1] == botID && board[1][2] == playerID && board[0][2] == playerID) {
				doubleWinSituation = true;
		}else if(board[1][1] == botID && board[1][0] == playerID && board[0][2] == playerID){
			doubleWinSituation = true;
		}else if(board[1][1] == botID && board[1][0] == playerID && board[2][2] == playerID){
			doubleWinSituation = true;
		}else if(board[1][1] == botID && board[0][1] == playerID && board[2][2] == playerID){
			doubleWinSituation = true;
		}else if(board[1][1] == botID && board[0][1] == playerID && board[2][0] == playerID){
			doubleWinSituation = true;
		}else if(board[1][1] == botID && board[2][1] == playerID && board[0][0] == playerID){
			doubleWinSituation = true;
		}else if(board[1][1] == botID && board[2][1] == playerID && board[0][2] == playerID){
			doubleWinSituation = true;
		}
		return doubleWinSituation;
	}
	
	private Move CreateDoubleWinSituation(char[][] board, int turnCount) 
	{
		List<Move> validCorner = new ArrayList<Move>();
		List<Move> unvalidSides = new ArrayList<Move>();
		for (int row = 0; row < 3; row++) {
			for (int col = 0; col < 3; col++) {
				if ((row+col)%2==1 && board[row][col] != ' ' ) {
					unvalidSides.add(new Move(col, row));
				}
				if (row != 1 && (row+col)%2==0 && board[row][col] == ' ') {
					validCorner.add(new Move(col, row));
				}
			}
		}
		
		Move move;
		if(turnCount==5 && board[0][0]!=' ' && unvalidSides.size()==1 && validCorner.size()==2)
		{
			int num = -1;
			if(unvalidSides.get(0).getX()%2==0)
			{
				num = unvalidSides.get(0).getX();
				for (Move corner : validCorner)
				{
					if(corner.getX()!=num)
					{
						move = corner;
						return move;
					}
				}
			}else if(unvalidSides.get(0).getY()%2==0)
			{
				num = unvalidSides.get(0).getY();
				for (Move corner : validCorner)
				{
					if(corner.getY()!=num)
					{
						move = corner;
						return move;
					}
				}
			}
		}
		return null;
	}

	private Move threeInARow(char[][] board, List<Move> moves, char ID) {
		for (Move move : moves) {
			if (horizontalThreeInARow(board, move, ID)) {
				return move;
			}

			if (verticalThreeInARow(board, move, ID)) {
				return move;
			}

			if ((move.getX() + move.getY()) % 2 == 0) { // center or corner
				if (diagonalThreeInARow(board, move, ID)) {
					return move;
				}
			}
		}
		return null;
	}

	private boolean horizontalThreeInARow(char[][] board, Move move, char ID) {
		boolean threeInARow = false;
		board[move.getY()][move.getX()] = ID;

		if (board[move.getY()][0] == ID && board[move.getY()][1] == ID && board[move.getY()][2] == ID) {
			threeInARow = true;
		}

		board[move.getY()][move.getX()] = ' ';
		return threeInARow;
	}

	private boolean verticalThreeInARow(char[][] board, Move move, char ID) {
		boolean threeInARow = false;
		board[move.getY()][move.getX()] = ID;

		if (board[0][move.getX()] == ID && board[1][move.getX()] == ID && board[2][move.getX()] == ID) {
			threeInARow = true;
		}

		board[move.getY()][move.getX()] = ' ';
		return threeInARow;
	}

	private boolean diagonalThreeInARow(char[][] board, Move move, char ID) {
		boolean threeInARow = false;
		board[move.getY()][move.getX()] = ID;

		if (move.getY() != move.getX() || (move.getY() == 1 && move.getX() == 1)) {
			if (board[0][2] == board[1][1] && board[1][1] == board[2][0]) {
				threeInARow = true;
			}
		} 
		if (move.getY() == move.getX()){
			if (board[0][0] == board[1][1] && board[1][1] == board[2][2]) {
				threeInARow = true;
			}
		}

		board[move.getY()][move.getX()] = ' ';
		return threeInARow;
	}
}