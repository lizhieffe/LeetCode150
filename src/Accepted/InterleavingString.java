package Accepted;


public class InterleavingString {
	
	private String s1, s2, s3;
    int length1, length2, length3;
    Boolean[][] dp;
    
    public boolean isInterleave(String s1, String s2, String s3) {
        if (s1 == null || s2 == null || s3 == null)
            return false;
        
        length1 = s1.length();
        length2 = s2.length();
        length3 = s3.length();
        
        if (length1 + length2 != length3)
            return false;
        
        if (length1 == 0)
            return true;
            
        this.s1 = s1;
        this.s2 = s2;
        this.s3 = s3;
        
        dp = new Boolean[length1][length2];
        
        return isInterleave(0, 0);
    }
    
    private boolean isInterleave(int i1, int i2) {
        
    	if (i1 == length1 && i2 == length2)
    		return true;
    	
    	if (i1 == length1)
    		return s2.substring(i2, length2).equals(s3.substring(i1 + i2, length3));
    	
    	if (i2 == length2)
    		return s1.substring(i1, length1).equals(s3.substring(i1 + i2, length3));

    	if (dp[i1][i2] != null)
    		return dp[i1][i2];
    	
    	boolean result;
    	
    	if (s1.charAt(i1) == s3.charAt(i1 + i2) 
    			&& s2.charAt(i2) == s3.charAt(i1 + i2))
    		result = isInterleave(i1 + 1, i2) || isInterleave(i1, i2 + 1);
    	else if (s1.charAt(i1) == s3.charAt(i1 + i2))
    		result = isInterleave(i1 + 1, i2);
    	else if (s2.charAt(i2) == s3.charAt(i1 + i2))
    		result =  isInterleave(i1, i2 + 1);
    	else
    		result = false;
    	
    	dp[i1][i2] = result;
    	
    	return result;
    }
    
    public static void main(String[] args) {
    	String a1 = "cacabcbaccbbcbb";
    	String a2 = "acaaccaacbbbabbacc";
    	String a3 = "accacaabcbacaccacacbbbbcbabbbbacc";
    	
    	InterleavingString service = new InterleavingString();
    	System.out.println(service.isInterleave(a1, a2, a3));
    }
}
