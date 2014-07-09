package Accepted;

public class WordSearch {

	char[][] board;
    String word;
    int rows;
    int columns;
    
    public boolean exist(char[][] board, String word) {
        if (board.length == 0)
            return false;
            
        if (word == null || word.length() == 0)
            return false;
        
        this.board = board;
        this.word = word;
        this.rows = board.length;
        this.columns = board[0].length;
        boolean[][] occupied = new boolean[rows][columns];
        
        boolean result = false;
        for (int i = 0; i < rows; i ++) {
            for (int j = 0; j < columns; j ++) {
            	if (board[i][j] == word.charAt(0)) {
            		boolean[][] newOccupied = copy(occupied);
            		result =  result || exist(i, j, 0, newOccupied);
            	}
            }
        }
        
        return result;
    }
    
    private boolean exist(int row, int column, int start, boolean[][] occupied) {
        if (start >= word.length())
            return true;
        
        if (board[row][column] != word.charAt(start))
            return false;
        
        if (occupied[row][column] == true)
            return false;
            
//        boolean[][] newOccupied = copy(occupied);
//        newOccupied[row][column] = true;
        
        occupied[row][column] = true;

        boolean result = false;
        
        if (start == word.length() - 1) {
            occupied[row][column] = false;
            return true;
        }
        
        if (row > 0)
            result = result || exist(row - 1, column, start + 1, occupied);
        if (row < rows - 1)
            result = result || exist(row + 1, column, start + 1, occupied);
        if (column > 0)
            result = result || exist(row, column - 1, start + 1, occupied);
        if (column < columns - 1)
            result = result || exist(row, column + 1, start + 1, occupied);
            
        occupied[row][column] = false;

        return result;
    }
    
    private boolean[][] copy(boolean[][] array) {
    	boolean[][] result = new boolean[rows][columns];
        for (int i = 0; i < rows; i ++) {
            boolean[] tmp = new boolean[columns];
            System.arraycopy(array[i], 0, tmp, 0, columns);
            result[i] = tmp;
        }
        
        return result;
    }
    
    public static void main(String[] args) {
    	char[] a = {'a'};
    	char[][] t = new char[1][2];
    	t[0] = a;
    	
    	String word = "a";
    	
    	WordSearch service = new WordSearch();
    	System.out.println(service.exist(t, word));
    }
}
