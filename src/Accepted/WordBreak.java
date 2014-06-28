package Accepted;

import java.util.Set;

public class WordBreak {

	Boolean[][] dpResult;
    String s;
    Set<String> dict;
    
    public boolean wordBreak(String s, Set<String> dict) {
        if (dict == null || s == null || dict.size() == 0)
            return false;
            
        this.s = s;
        int length = s.length();
        dpResult = new Boolean[length + 1][length + 1];
        this.dict = dict;
        
        return wordBreak(0, length);
    }
    
    private boolean wordBreak(int start, int end) {
        if (dpResult[start][end] != null)
            return dpResult[start][end];
        
        boolean result = false;
        String cString = s.substring(start, end);
        
        if (dict.contains(cString)) {
            result = true;
        } else {
            for (int i = start + 1; i < end; i ++) {
                if (wordBreak(start, i) == true && wordBreak(i, end) == true) {
                    result = true;
                    break;
                }
            }
        }
        
        dpResult[start][end] = result;
        return result;
    }
}
