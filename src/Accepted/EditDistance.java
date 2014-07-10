package Accepted;

public class EditDistance {

	int[][] dp;
    int length1, length2;
    String word1, word2;
    
    public int minDistance(String word1, String word2) {
        
        if (word1 == null || word2 == null)
            return -1;
        
        length1 = word1.length();
        length2 = word2.length();
        
        if (length1 == 0)
            return length2;
        
        if (length2 == 0)
            return length1;
            
        dp = new int[length1][length2];
        for (int i = 0; i < length1; i ++)
            for (int j = 0; j < length2; j ++)
                dp[i][j] = -1;
        
        this.word1 = word1;
        this.word2 = word2;
        
        return minDistance(0, 0);
    }
    
    private int minDistance(int start1, int start2) {
        if (start1 == length1)
            return length2 - start2;
        
        if (start2 == length2)
            return length1 - start1;
            
        if (dp[start1][start2] != -1)
            return dp[start1][start2];
            
        int result;
        
        if (word1.charAt(start1) == word2.charAt(start2))
            result = minDistance(start1 + 1, start2 + 1);
        else
            result = Math.min(Math.min(minDistance(start1, start2 + 1) + 1, minDistance(start1 + 1, start2) + 1),                            minDistance(start1 + 1, start2 + 1) + 1);
            
        dp[start1][start2] = result;
        return result;
    }
}
