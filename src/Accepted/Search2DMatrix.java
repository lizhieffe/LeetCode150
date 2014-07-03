package Accepted;

public class Search2DMatrix {

	public boolean searchMatrix(int[][] matrix, int target) {
        
        int rows = matrix.length;
        if (rows == 0)
            return false;
            
        int columns = matrix[0].length;
        if (columns == 0)
            return false;
            
        int row = -1;
        
        for (int i = 0; i < rows; i ++)
            if (matrix[i][0] == target)
                return true;
            else if (matrix[i][0] > target) {
                row = i;
                break;
            }
        
        if (row == 0)
            return false;
        else if (row == -1)
            row = rows;
        
        for (int i = 0; i < columns; i ++) {
            if (matrix[row - 1][i] == target)
                return true;
        }
        
        return false;
    }
}
