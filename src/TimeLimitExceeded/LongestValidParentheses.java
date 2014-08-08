package TimeLimitExceeded;

/*
 * http://leetcodenotes.wordpress.com/2013/10/19/leetcode-longest-valid-parentheses-%E8%BF%99%E7%A7%8D%E6%8B%AC%E5%8F%B7%E7%BB%84%E5%90%88%EF%BC%8C%E6%9C%80%E9%95%BF%E7%9A%84valid%E6%8B%AC%E5%8F%B7%E7%BB%84%E5%90%88%E6%9C%89%E5%A4%9A/
 */

public class LongestValidParentheses {

	private int start;
    char[] chars;
    
    public int longestValidParentheses(String s) {
        if (s == null || s.length() <= 1)
            return 0;
            
        chars = s.toCharArray();
        start = 0;
        int result = 0;
        
        while (start < s.length()) {
            result = Math.max(result, findValid(start));
        }
        
        return result;
    }
    
    private int findValid(int start) {
        int max = 0;
        int i = start;
        
        while (i < chars.length) {
            if (chars[i] == '(')
                break;
            else
                i ++;
        }
        
        int first = 1;
        int end = 0;
        i ++;
        
        while (i < chars.length) {
            if (chars[i] == '(')
                first ++;
            else
                end ++;
                
            if (first >= end)
                max = 2 * end;
            else if (first < end)
                break;
                
            i ++;
        }
        
        this.start = i;
        return max;
    }
    
    public static void main(String[] args) {
    	String s = "(()";
    	
    	LongestValidParentheses service = new LongestValidParentheses();
    	System.out.println(service.longestValidParentheses(s));
    }
}
