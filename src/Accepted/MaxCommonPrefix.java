package Accepted;

public class MaxCommonPrefix {

public String longestCommonPrefix(String[] strs) {
        
        int length = strs.length;
        
        if (length == 0)
            return "";
        
        String longest = strs[0];
        
        for (int i = 1; i < length; i ++) {
            longest = longestCommonPrefixBetweenTwo(longest, strs[i]);
        }
        
        return longest;
    }
    
    private String longestCommonPrefixBetweenTwo(String s1, String s2) {
        if (s1 == null || s2 == null)
            return "";
        
        int length = Math.min(s1.length(), s2.length());
        if (length == 0)
            return "";
            
        int i;
        for (i = 0; i < length; i ++) {
            if (s1.charAt(i) != s2.charAt(i))
                break;
        }
        
        if (i == length)
            return s1.length() == length ? s1 : s2;
        else
            return s1.substring(0, i);

    }
}
