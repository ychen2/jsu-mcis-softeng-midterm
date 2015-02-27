package edu.jsu.mcis;

import java.io.*;

public class ConnectFour {
    public enum Location {EMPTY, RED, BLACK};
	private Location[][] board;
    private int ROWS = 6;
	private int COLUMNS = 7;
	private boolean redTurn;
	private int TOP = 5;
    public ConnectFour() {
        board = new Location[ROWS][COLUMNS];
		for (int i = 0; i < ROWS; i++){
			for(int j = 0; j < COLUMNS; j++){
				board[i][j] = Location.EMPTY;
			}
		}
		redTurn = true;
    }
    
    public Location getTopOfColumn(int column) {
		return board[TOP][column];
    }
    
    public int getHeightOfColumn(int column) {
		int j = 0;
        for(int i = 0; i < ROWS; i++ ){
			if(board[ROWS - i - 1][column] != Location.EMPTY){
				j++;
			}
		}
		return j;
    }
    
    public void dropToken(int column) throws ColumnFullException{
        for(int i = 0; i < ROWS; i++ ){
			if(board[ROWS - i - 1][column] == Location.EMPTY && redTurn == true)
			{
				board[ROWS - i - 1][column] = Location.RED;
				TOP = ROWS - 1 - i;
				redTurn = false;
				break;
			}
			else if (board[ROWS - i - 1][column] == Location.EMPTY && redTurn == false)
			{
				board[ROWS - i - 1][column] = Location.BLACK;
				TOP = ROWS - 1 - i;
				redTurn = true;
				break;
			}
			else if (board[0][column] != Location.EMPTY)
			{
				throw new ColumnFullException("Column Is Full!");
			}
		}
		
    }
} 