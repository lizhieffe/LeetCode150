package Accepted;

public class ClimbingStairs {

	int[] dp;

    public int climbStairs(int n) {
        if (n <= 0)
            return 0;
            
        dp = new int[n + 1];
        for (int i = 0; i < n + 1; i ++)
            dp[i] = -1;
        
        return climb(n);
    }
    
    private int climb(int m) {
        if (m <= 3)
            return m;
            
        if (dp[m] != -1)
            return dp[m];
            
        int result;
        result = climb(m - 1) + climb(m - 2);
        
        dp[m] = result;
        return result;
    } 
}
