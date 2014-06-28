package Accepted;

import java.util.HashMap;

public class DecodeWays {

	private HashMap<Integer, Integer> dpResult = new HashMap<Integer, Integer>();
    private String s;
    
    public int numDecodings(String s) {
        if (s == null)
            return 0;
        if (s.length() == 0)
            return 0;
        
        this.s = s;
        numDecoding(0);
        
        return dpResult.get(0) >= 0 ? dpResult.get(0) + 1 : 0;
    }
    
    private int numDecoding(int i) {
        
        if (dpResult.containsKey(i))
            return dpResult.get(i);
            
        String cString = getSubstring(s, i);
        int result;
        
        if (cString == null)
            result = -1;
        else if (cString.length() == 0)
            result = 0;
        else if (cString.charAt(0) == '0')
            result = -1;
        else if (Integer.parseInt(getSubstring(cString, 0, 2)) > 26)
            result = numDecoding(i + 1);
        else if (Integer.parseInt(getSubstring(cString, 0, 2)) == 10 || Integer.parseInt(getSubstring(cString, 0, 2)) == 20)
            result = numDecoding(i + 2);
        else if (Integer.parseInt(getSubstring(cString, 0, 2)) > 10)
            result = 1 + numDecoding(i + 1) + numDecoding(i + 2);
        else
            result = 0;
            
        dpResult.put(i, result);
        return result;
    }
    
    private String getSubstring(String s, int startIndex) {
        if (s == null)
            return null;
        return getSubstring(s, startIndex, s.length());
    }
    
    private String getSubstring(String s, int startIndex, int endIndex) {
        if (s == null)
            return null;
        
        if (startIndex > endIndex)
            return "";
            
        int length = s.length(); 
        if (length <= startIndex)
            return "";
        else if (length < endIndex)
            endIndex = length;
            
        return s.substring(startIndex, endIndex);
    }
}
