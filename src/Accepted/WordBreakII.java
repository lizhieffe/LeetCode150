package Accepted;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/*
 * see: http://stupidcodergoodluck.wordpress.com/2013/11/16/leetcode-word-break-ii/ 
 * the dp in this one is only to pre-check whether the s can have answer. if no, return directly
 */

public class WordBreakII {
	ArrayList<String> result;
	String s;
	Set<String> dict;
	int length;
	int maxStringLength;
	
	public List<String> wordBreak(String s, Set<String> dict) {
        result = new ArrayList<String>();
        
        if (s == null || s.length() == 0 || dict == null || dict.size() == 0)
        	return result;
        
        this.s = s;
        this.dict = dict;
        length = s.length();
        
        boolean[] dp = new boolean[length + 1];
        dp[0] = true;
        for (int i = 1; i <= length; i ++) {
        	if (dict.contains(s.substring(0, i))) {
        		dp[i] = true;
        		continue;
        	}
        	for (int j = 1; j < i; j ++) {
        		if (dp[j] == true && dict.contains(s.substring(j, i))) {
        			dp[i] = true;
        			break;
        		}
        	}
        }
        if (!dp[length])
        	return result;
        
        maxStringLength = 0;
        for (String string : dict) {
        	maxStringLength = Math.max(maxStringLength, string.length());
        }
        
        find(0, new StringBuilder());
        return result;
    }
	
	private void find(int start, StringBuilder solution) {
		if (start == length) {
			if (solution.charAt(solution.length() - 1) == ' ')
				result.add(solution.substring(0, solution.length() - 1));
			else
				result.add(solution.toString());
			
			return;
		}
		
		for (int i = start + 1; i <= Math.min(start + maxStringLength, length); i ++) {
			String tmp = s.substring(start, i);
			if (dict.contains(tmp)) {
				StringBuilder tmpSolution = new StringBuilder(solution);
				tmpSolution.append(tmp);
				tmpSolution.append(' ');
				find(i, tmpSolution);
			}
				
		}
	}
	
	public static void main(String[] args) {
		String s = "aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaab";
		String[] tmp = {"a","aa","aaa","aaaa","aaaaa","aaaaaa","aaaaaaa","aaaaaaaa","aaaaaaaaa","aaaaaaaaaa"};
		
//		String s = "aaaaa";
//		String[] tmp = {"a","aa"};
		
		Set<String> dict = new HashSet<String>(Arrays.asList(tmp));
		
		List<String> result = new WordBreakII().wordBreak(s, dict);
		System.out.println(result);
	}
}
