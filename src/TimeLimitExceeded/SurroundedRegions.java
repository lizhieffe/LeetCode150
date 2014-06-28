package TimeLimitExceeded;

import java.util.ArrayList;

/*
 * based on the online solution, this one should be using the right strategy.
 * don't know why etl
 * http://fisherlei.blogspot.com/2013/03/leetcode-surrounded-regions-solution.html
 */

public class SurroundedRegions {

	char[][] board;
    int rows;
    int columns;
    
    public void solve(char[][] board) {
        
        this.rows = board.length;
        if (rows <= 2)
            return;
        
        this.columns = board[0].length;
        if (columns <= 2)
            return;
        
        this.board = board;


        for (int i = 0; i < columns; i ++) {
            if (board[0][i] == 'O')
                colorNeighboringO(0, i);
            if (board[rows - 1][i] == 'O')
                colorNeighboringO(rows - 1, i);
        }
        
        for (int i = 1; i < rows - 1; i ++) {
            if (board[i][0] == 'O')
                colorNeighboringO(i, 0);
            if (board[i][columns - 1] == 'O')
                colorNeighboringO(i, columns - 1);
        }
        
        for (int i = 0; i < rows; i ++) {
            for (int j = 0; j < columns; j ++)
                if (board[i][j] == 'O')
                    board[i][j] = 'X';
                else if (board[i][j] == 'T')
                    board[i][j] = 'O';
        }
    }
    
    private void colorNeighboringO(int row, int column) {
    	ArrayList<int[]> list = new ArrayList<int[]>();
        int[] start = {row, column};
    	list.add(start);
        
//    	int[]  tmp = {0, 0};
    	int[] cPosition = {-1 , -1};
        int cRow, cColumn;
        while (list.size() > 0) {
        	cPosition = list.get(0);
            cRow = cPosition[0];
            cColumn = cPosition[1];
            
            if (cRow > 0 && board[cRow - 1][cColumn] == 'O') {
            	int[] tmp = {cRow - 1, cColumn};
            	list.add(tmp);
            }
            if (cRow < rows - 1 && board[cRow + 1][cColumn] == 'O') {
            	int[] tmp = {cRow + 1, cColumn};
            	list.add(tmp);
            }
            if (cColumn > 0 && board[cRow][cColumn - 1] == 'O') {
            	int[] tmp = {cRow, cColumn - 1};
            	list.add(tmp);
            }
            if (cColumn < columns - 1 && board[cRow][cColumn + 1] == 'O') {
            	int[] tmp = {cRow, cColumn + 1};
            	list.add(tmp);
            }
                
            board[cRow][cColumn] = 'T';
            list.remove(0);
        }
    }
    
    class Position {
        int row, column;
        
        Position(int row, int column) {
            this.row = row;
            this.column = column;
        }
    }
    
    public static void main(String[] args) {
    	char[] a = {'O', 'X', 'X', 'O', 'X'};
    	char[] b = {'X', 'O', 'O', 'X', 'O'};
    	char[] c = {'X', 'O', 'X', 'O', 'X'};
    	char[] d = {'O', 'X', 'O', 'O', 'O'};
    	char[] e = {'X', 'X', 'O', 'X', 'O'};

    	
    	char[][] board = {a, b, c, d, e};
    	
    	SurroundedRegions service = new SurroundedRegions();
    	service.solve(board);
    	
    	System.out.println(board);
    }
}
