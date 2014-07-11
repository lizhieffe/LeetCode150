package Accepted;

public class UniquePathsII {

	int rows, columns;
    int[][] obstacleGrid;
    int[][] dp;
    
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        rows = obstacleGrid.length;
        if (rows == 0)
            return 0;
            
        columns = obstacleGrid[0].length;
        if (columns == 0)
            return 0;
            
        this.obstacleGrid = obstacleGrid;
        
        dp = new int[rows][columns];
        for (int i = 0; i < rows; i ++)
            for (int j = 0; j < columns; j ++)
                dp[i][j] = -1;
                
        return pathsNum(0, 0);
    }
    
    private int pathsNum(int row, int column) {
        if (row == rows - 1 && column == columns - 1)
            return 1;
        
        if (obstacleGrid[row][column] == 1)
            return 0;
            
        if (dp[row][column] != -1)
            return dp[row][column];
            
        int result = 0;
        if (row < rows - 1)
            result = result + pathsNum(row + 1, column);
        if (column < columns - 1)
            result = result + pathsNum(row, column + 1);
        
        dp[row][column] = result;
        return result;
        
    }
    
    public static void main(String[] args) {
    	int[] a1 = {0, 0};
    	int[][] obstacleGrid = {a1};
    	int result = new UniquePathsII().uniquePathsWithObstacles(obstacleGrid);
    	
    	System.out.println(result);
    	
    }
}
