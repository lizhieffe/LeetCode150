package Accepted;

import java.util.ArrayList;

public class SudokuSolver {

	char[][] board;
    
    public void solveSudoku(char[][] board) {
        if (board.length == 0 || board[0].length == 0)
            return;
        
        this.board = board;
        solve();
    }
    
    private boolean solve() {
        Position pos = findFirstAvailablePosition();
        for (int i = 1; i <= 9; i ++) {
            board[pos.x][pos.y] = Character.forDigit(i, 10);

            if (checkPosition(i, pos) == true) {
                
                if (findFirstAvailablePosition().x == -1)
                    return true;
                else {
                    boolean tmp = solve();
                    if (tmp == true)
                        return true;
                }
            } else {
                board[pos.x][pos.y] = '.';
            }
        }
        
        board[pos.x][pos.y] = '.';
        return false;
    }
    
    private boolean checkPosition(int val, Position position) {
        if (checkRow(position.x) == false || checkColumn(position.y) == false
                || checkSquare(position.x / 3, position.y / 3) == false)
            return false;
        else
            return true;
    }
    
    private Position findFirstAvailablePosition() {
        for (int i = 0; i < 9; i ++) 
            for (int j = 0; j < 9; j ++)
                if (board[i][j] == '.')
                    return new Position(i, j);
                    
        return new Position(-1, -1);
    }
    
    private boolean checkRow(int n) {
        ArrayList<Character> tmp = new ArrayList<Character>();
        for (int i = 0; i < 9; i ++) {
            if (checkSlot(n, i) == false)
                return false;
            
            if (board[n][i] != '.')
                if (tmp.contains(board[n][i]))
                    return false;
                else
                    tmp.add(board[n][i]);
        }
        
        return true;
    }
    
    private boolean checkColumn(int n) {
        ArrayList<Character> tmp = new ArrayList<Character>();
        for (int i = 0; i < 9; i ++) {
            // if (checkSlot(i, n) == false)
            //     return false;
            
            if (board[i][n] != '.')
                if (tmp.contains(board[i][n]))
                    return false;
                else
                    tmp.add(board[i][n]);
        }
        
        return true;
    }
    
    private boolean checkSquare(int m, int n) {
        ArrayList<Character> tmp = new ArrayList<Character>();
        for (int i = m * 3; i < m * 3 + 3; i ++) {
            for (int j = n * 3; j < n * 3 + 3; j ++) {
            
                if (board[i][j] != '.')
                    if (tmp.contains(board[i][j]))
                        return false;
                    else
                        tmp.add(board[i][j]);
            }
        }
        
        return true;
    }
    
    private boolean checkSlot(int m, int n) {
        char tmp = board[m][n];
        int tmpNum = Character.getNumericValue(tmp);
        if (tmp != '.' && (tmpNum <= 0 || tmpNum >= 10))
            return false;
        else
            return true;
    }
    
    class Position {
        int x, y;
        Position(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
    
    public static void main(String[] args) {
    	String[] strings = {"..9748...","7........",".2.1.9...",
    			"..7...24.",".64.1.59.",".98...3..","...8.3.2.","........6","...2759.."};
    	
    	char[][] board = new char[9][9];
    	
    	for (int i = 0; i < 9; i ++)
    		board[i] = strings[i].toCharArray();
    	
    	new SudokuSolver().solveSudoku(board);
    }
}
