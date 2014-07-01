package Accepted;

public class UniquePaths {

	int m, n;
    Integer[][] dp;
    
    public int uniquePaths(int m, int n) {
        if (m == 0 || n == 0)
            return 0;
        
        this.m = m;
        this.n = n;
        Boolean[][] occupied = new Boolean[m][n];
        dp = new Integer[m][n];
        
        return uniquePaths(0, 0, occupied);
    }
    
    private int uniquePaths(int x, int y, Boolean[][] occupied) {
        if (x == m - 1 && y == n - 1)
            return 1;
        
        if (dp[x][y] != null)
            return dp[x][y];
            
        int result = 0;
        Boolean[][] tmp = new Boolean[m][n];
        for (int i = 0; i < m; i ++)
        	for (int j = 0; j < n; j ++)
        		tmp[i][j] = occupied[i][j];
        
        tmp[x][y] = true;
        
//        if (x > 0 && occupied[x - 1][y] == null)
//            result = result + uniquePaths(x - 1, y, tmp);
        if (x < m - 1 && occupied[x + 1][y] == null)
            result = result + uniquePaths(x + 1, y, tmp);
//        if (y > 0 && occupied[x][y - 1] == null)
//            result = result + uniquePaths(x, y - 1, tmp);    
        if (y < n - 1 && occupied[x][y + 1] == null)
            result = result + uniquePaths(x, y + 1, tmp); 
        
        dp[x][y] = result;
        return result;
    }
    
    public static void main(String[] args) {
    	int m = 23;
    	int n = 5;
    	
    	System.out.println(new UniquePaths().uniquePaths(m, n));
    }
}
