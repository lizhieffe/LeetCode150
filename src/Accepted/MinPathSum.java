package Accepted;

public class MinPathSum {

	int m, n;
    int[][] grid;
    int[][] dp;
    
    public int minPathSum(int[][] grid) {
        
        this.m = grid.length;
        if (m == 0)
            return 0;
            
        this.n = grid[0].length;
        if (n == 0)
            return 0;
            
        this.grid = grid;
        
        dp = new int[m][n];
        for (int i = 0; i < m; i ++)
            for (int j = 0; j < n; j ++)
                dp[i][j] = -1;
                
        return minPathSum(0, 0);
    }
    
    private int minPathSum(int row, int column) {
        if (row == m - 1 && column == n - 1)
            return grid[row][column];
        
        if (dp[row][column] != -1)
            return dp[row][column];
            
        int result;
        if (row == m - 1)
            result = grid[row][column] + minPathSum(row, column + 1);
        else if (column == n - 1)
            result = grid[row][column] + minPathSum(row + 1, column);
        else
            result = grid[row][column] + Math.min(minPathSum(row + 1, column), minPathSum(row, column + 1));
            
        dp[row][column] = result;
        return result;
    }
}
