package Accepted;

public class ImplementStrStr {

	public String strStr(String haystack, String needle) {
        if (haystack == null || needle == null)
            return null;
            
        int lengthH = haystack.length();
        int lengthN = needle.length();
        if (lengthH < lengthN)
            return null;
        
        if (lengthH == 0)
            return lengthN == 0 ? haystack : null;
        
        if (lengthN == 0)
            return haystack;
            
        char[] a = haystack.toCharArray();
        char[] b = needle.toCharArray();
        
        long hashVal1 = getHashVal(haystack.substring(0, lengthN));
        long hashVal2 = getHashVal(needle);
        
        long modifier = 1;
        for (int i = 0; i < lengthN - 1; i ++)
            modifier = modifier * 10;
            
        for (int i = 0; i <= lengthH - lengthN; i ++) {
            if (hashVal1 == hashVal2) {
                if (isEqual(a, i, b) == true) {
                    return haystack.substring(i, lengthH);
                }
            }
            if (i != lengthH - lengthN)
                hashVal1 = (hashVal1 - modifier * a[i]) * 10 + a[lengthN + i];
        }
        
        return null;
    }
    
    private long getHashVal(String s) {
        char[] chars = s.toCharArray();
        long result = 0;
        long modifier = 1;
        for (int i = chars.length - 1; i >= 0; i --) {
            result = result + modifier * chars[i];
            modifier = modifier * 10;
        }
        return result;
    }
    
    private boolean isEqual(char[] a, int start, char[] b) {
        for (int i = 0; i < b.length; i ++) {
            if (a[start + i] != b[i])
                return false;
        }
        return true;
    }
}
