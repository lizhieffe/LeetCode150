package Accepted;

public class DistinctSubsequences {

	int start;
    String S;
    String T;
    int lengthS;
    int lengthT;
    
    Integer[][] dp;
    
    public int numDistinct(String S, String T) {
        
        if (S == null || T == null || S.length() < T. length())
            return 0;
            
        if (T == "")
            return 0;
            
        start = 0;
        this.S = S;
        this.T = T;
        lengthS = S.length();
        lengthT = T.length();
        
        dp = new Integer[lengthS][lengthT];
        
        return numDistinct(0, 0);
    }
    
    private int numDistinct(int indexS, int indexT) {
        
        if (lengthS - indexS < lengthT - indexT)
            return 0;
            
        if (indexT == lengthT)
            return 1;
            
        if (dp[indexS][indexT] != null)
            return dp[indexS][indexT];
            
        int result = 0;
        char lookFor = T.charAt(indexT);
        
        if (lookFor == S.charAt(indexS))
            result = numDistinct(indexS + 1, indexT + 1) + numDistinct(indexS + 1, indexT);
        else
            result = numDistinct(indexS + 1, indexT);

        dp[indexS][indexT] = result;
        return result;
    }
    
	public static void main(String[] args) {
		String s = "rabbbit";
		String t = "rabbit";
		
		DistinctSubsequences service = new DistinctSubsequences();
		System.out.println(service.numDistinct(s, t));
	}

}
