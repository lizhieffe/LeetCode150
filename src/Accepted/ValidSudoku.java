package Accepted;

import java.util.ArrayList;

public class ValidSudoku {

char[][] board;
    
    public boolean isValidSudoku(char[][] board) {
        if (board.length != 9 || board[0].length != 9)
            return false;
        
        this.board = board;
        
        boolean tmp;
        for (int i = 0; i < 9; i ++) {
            tmp = checkRow(i);
            if (tmp == false)
                return false;
        }
        
        for (int i = 0; i < 9; i ++) {
            tmp = checkColumn(i);
            if (tmp == false)
                return false;
        }
        
        for (int i = 0; i < 3; i ++)
            for (int j = 0; j < 3; j ++) {
                tmp = checkSquare(i, j);
                if (tmp == false)
                    return false;
            }
        
        return true;   
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
}
