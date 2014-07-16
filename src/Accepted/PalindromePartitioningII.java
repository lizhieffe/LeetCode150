package Accepted;

/*
 * very hard question
 * http://blog.csdn.net/kenden23/article/details/18569933
 */

public class PalindromePartitioningII {

	char[] chars;
    int[] dp;
    boolean[][] isPalindrome;
    
    public int minCut(String s) {
        if (s == null || s.length() <= 1)
            return 0;
        
        chars = s.toCharArray();
        
        dp = new int[s.length()];
        for (int i = 0; i < s.length(); i ++)
            dp[i] = -1;
                
        isPalindrome = new boolean[s.length() + 1][];
        for (int i = 0; i < s.length() + 1; i ++)
            isPalindrome[i] = new boolean[s.length() + 1];
        
        genPalindromeTable();
        
        return min(s.length() - 1);
    }
    
    private int min(int end) {
        if (end == 0)
            return 0;
        
        if (isPalindrome[0][end + 1] == true)
            return 0;
            
        if (dp[end] != -1)
            return dp[end];
            
        int result = min(end - 1) + 1;
        for (int j = 1; j < end; j ++) {
            if (isPalindrome[end - j][end + 1] == true)
                result = Math.min(result, 1 + min(end - j - 1));
        }
        
        dp[end] = result;
        return result;
    }
    
    private void genPalindromeTable() {
        
        for (int i = 0; i <= chars.length; i ++)
            for (int j = 0; j <= chars.length; j ++)
                isPalindrome[i][j] = false;
                
        for (int i = 0; i < chars.length; i ++) {
            for (int j = 0; j + i < chars.length && i - j >= 0; j ++) {
                if (chars[i + j] == chars[i - j])
                    isPalindrome[i - j][i + j + 1] = true;
                else {
                    break;
                }
            }
        }
        
        for (int i = 0; i < chars.length - 1; i ++) {
            for (int j = 0; j + i + 1 < chars.length && i - j >= 0; j ++) {
                if (chars[i + j + 1] == chars[i - j])
                    isPalindrome[i - j][i + j + 2] = true;
                else {
                    break;
                }
            }
        }
    }
    
    public static void main(String[] args) {
    	String s ="cdd";
    	PalindromePartitioningII service = new PalindromePartitioningII();
    	int result = service.minCut(s);
    	
    	System.out.println(result);
    }
}
