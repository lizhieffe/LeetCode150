package Accepted;

public class SetMatrixZeros {

	public void setZeroes(int[][] matrix) {
        int rows = matrix.length;
        if (rows == 0)
            return;
            
        int columns = matrix[0].length;
        if (columns == 0)
            return;
            
        int recordRow = -1;
        int recordColumn = -1;
        
        for (int i = 0; i < rows; i ++) {
            for (int j = 0; j < columns; j ++) {
                if (matrix[i][j] == 0) {
                    if (recordRow == -1) {
                        recordRow = i;
                        recordColumn = j;
                    } 
                    else {
                        matrix[recordRow][j] = 0;
                        matrix[i][recordColumn] = 0;
                    }
                }
            }
        }
        
        if (recordRow == -1)
            return;
            
        for (int i = 0; i < rows; i ++) 
            if (matrix[i][recordColumn] == 0 && i != recordRow)
                for (int j = 0; j < columns; j ++)
                    matrix[i][j] = 0;
                
        for (int j = 0; j < columns; j ++) 
            if (matrix[recordRow][j] == 0 && j != recordColumn)
                for (int i = 0; i < rows; i ++)
                    matrix[i][j] = 0;
                    
        for (int i = 0; i < rows; i ++)
            matrix[i][recordColumn] = 0;
            
        for (int j = 0; j < columns; j ++)
            matrix[recordRow][j] = 0;
    }
}
