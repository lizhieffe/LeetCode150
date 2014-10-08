package AcceptedButNeedToRevisit;

/*
 * http://leetcodenotes.wordpress.com/2013/10/19/leetcode-longest-valid-parentheses-%E8%BF%99%E7%A7%8D%E6%8B%AC%E5%8F%B7%E7%BB%84%E5%90%88%EF%BC%8C%E6%9C%80%E9%95%BF%E7%9A%84valid%E6%8B%AC%E5%8F%B7%E7%BB%84%E5%90%88%E6%9C%89%E5%A4%9A/
 */

public class LongestValidParentheses {

	int beg, end;
	String s;

    public String longestPalindrome(String s) {
        if (s == null || s.length() < 2)
        	return s;
 		
 		this.s = s;
 		this.beg = 0;
 		this.end = -1;

        for (int i = 0; i < s.length(); i ++) {
        	findLongest(i, i);
        	findLongest(i, i + 1);
        }

        return s.substring(this.beg, this.end + 1);
    }

    private void findLongest(int i, int j) {
    	if (j >= s.length())
    		return;

    	while (i >= 0 && j < s.length() && s.charAt(i) == s.charAt(j)) {
    		i --;
    		j ++;
    	}

    	if (j - i - 2 > this.end - this.beg) {
    		this.beg = i + 1;
    		this.end = j - 1;
    	}
    }
    
    public static void main(String[] args) {
    	String s = "bb";
    	
    	LongestValidParentheses service = new LongestValidParentheses();
    	System.out.println(service.longestPalindrome(s));
    }
}
