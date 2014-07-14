package Accepted;

import java.util.ArrayList;
import java.util.List;

public class PalindromePartitioning {

	List<List<String>> result;
    String s;
    char[] chars;
    Boolean[][] dp;
    
    public List<List<String>> partition(String s) {
        result = new ArrayList<List<String>>();
        
        if (s == null)
            return result;
        
        if (s == "") {
            List<List<String>> tmpResult = new ArrayList<List<String>>();
            List<String> solution = new ArrayList<String>();
            solution.add("");
            tmpResult.add(solution);
            return tmpResult;
        }
            
        this.s = s;
        chars = s.toCharArray();
        dp = new Boolean[chars.length + 1][chars.length + 1];
        
        ArrayList<String> solution = new ArrayList<String>();
        
        partition(0, s.length(), solution);
        
        return result;
    }
    
    private void partition(int start, int end, List<String> solution) {
        if (start == chars.length)
            result.add(solution);
            
        for (int i = start + 1; i <= end; i ++) {
            if (isPalindrome(start, i) == true) {
                List<String> tmpSolution = new ArrayList<String>(solution);
                StringBuilder tmpBuilder = new StringBuilder();
                for (int j = start; j < i; j ++)
                    tmpBuilder.append(chars[j]);
                    
                tmpSolution.add(tmpBuilder.toString());
                
                partition(i, end, tmpSolution);
            }
        }
    }
    
    private boolean isPalindrome(int start, int end) {
        if (start >= end)
            return false;
            
        if (start > chars.length - 1)
            return false;
            
        if (dp[start][end] != null)
            return dp[start][end];
        else {
            if (start == end - 1) {
                Boolean tmp = true;
                dp[start][end] = tmp;
                return tmp;
            }
            else {
                while (start < end) {
                    if (chars[start] != chars[end - 1]) {
                        Boolean tmp = false;
                        dp[start][end] = tmp;
                        return tmp;
                    }
                    
                    start ++;
                    end --;
                }
            }
        }
        
        Boolean tmp = true;
        dp[start][end] = tmp;
        return tmp;
            
    }
}
