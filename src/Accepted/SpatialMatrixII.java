package Accepted;

public class SpatialMatrixII {

	public int[][] generateMatrix(int n) {
        if (n <= 0)
            return new int[0][];
            
        int[][] result = new int[n][];
        for (int i = 0; i < n; i ++)
            result[i] = new int[n];
        
        for (int i = 0; i < n; i ++)
            for (int j = 0; j < n; j ++)
                result[i][j] = -1;
        
        int j = 0;
        int k = 0;
        result[j][k] = 1;
        int direction = 3;
        for (int i = 2; i <= n * n; i ++) {
            if (direction == 0 && (j - 1 < 0 || result[j - 1][k] != -1))
                direction = 3;
            else if (direction == 1 && (j + 1 >= n || result[j + 1][k] != -1))
                direction = 2;
            else if (direction == 2 && (k - 1 < 0 || result[j][k - 1] != -1))
                direction = 0;
            else if (direction == 3 && (k + 1 >= n || result[j][k + 1] != -1))
                direction = 1;
                
            if (direction == 0)
                result[--j][k] = i;
            else if (direction == 1)
                result[++j][k] = i;
            else if (direction == 2)
                result[j][--k] = i;
            else
                result[j][++k] = i;   
        }
        
        return result;
    }
}
