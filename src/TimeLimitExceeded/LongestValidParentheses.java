package TimeLimitExceeded;

import java.util.LinkedList;

public class LongestValidParentheses {

	private int start, length;
    String s;
    
    public int longestValidParentheses(String s) {
        if (s == null || s.length() <= 1)
            return 0;
        this.s = s;
        
        start = 0;

        int longest = 0;
        length = s.length();
        while (start < length) {
            longest = Math.max(longest, longestValidParentheses());
        }
        
        return longest;
    }
    
    private int longestValidParentheses() {
        int i = start;
        int longest = 0;
        int frontId = 0;
        int endNum = 0;
        
        LinkedList<Integer> list = new LinkedList<Integer>();
        while (i < length) {
            if (s.charAt(i) == '(') {
                list.add(frontId ++);
            }
            else {
                if (list.size() <= 0)
                	break;
                else {
                    list.removeLast();
                    endNum ++;
                }
            }
            i ++;
        }
        start = i + 1;
        
        if (endNum <= 1)
        	return endNum * 2;
        
        if (list.size() == 0)
        	return (frontId) * 2;
        for (int j = list.size() - 1; j >= 0; j --) {
            int tmp = list.get(j);
            longest = Math.max(longest, (frontId - list.get(j) - 1) * 2);
            frontId = tmp;
        }
        
        return longest;
    }
    
    public static void main(String[] args) {
    	String s = ")()(((())))(";
    	
    	LongestValidParentheses service = new LongestValidParentheses();
    	System.out.println(service.longestValidParentheses(s));
    }
}
