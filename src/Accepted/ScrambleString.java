package Accepted;

public class ScrambleString {

	private Boolean[][][] dpResult;
	private String s1;
	private String s2;
    
    public boolean isScramble(String s1, String s2) {
        if (s1 == null || s2 == null)
            return false;
        
        if (s1.length() != s2.length())
        	return false;
        
        this.s1 = s1;
        this.s2 = s2;
		dpResult = new Boolean[s1.length()][s1.length()][s1.length()];

        return isScramble(s1.length(), 0, 0);
    }
    
    private boolean isScramble(int length, int start1, int start2) {
		if (dpResult[length - 1][start1][start2] != null)
			return dpResult[length - 1][start1][start2];
		
		if (length == 1) {
			boolean tmp = s1.substring(start1, start1 + 1).equals(s2.substring(start2, start2 + 1));
			dpResult[0][start1][start2] = tmp;
			return tmp;
		}
		
		for (int tmpSize = 1; tmpSize < length; tmpSize ++) {
			dpResult[tmpSize - 1][start1][start2] = isScramble(tmpSize, start1, start2);
			dpResult[length - tmpSize - 1][start1 + tmpSize][start2 + tmpSize]
					= isScramble(length - tmpSize, start1 + tmpSize, start2 + tmpSize);
			dpResult[length - 1][start1][start2] = (dpResult[tmpSize - 1][start1][start2] 
					== true && dpResult[length - tmpSize - 1][start1 + tmpSize][start2 + tmpSize] == true);
			if (dpResult[length - 1][start1][start2] == true)
				return true;
				
			
			dpResult[tmpSize - 1][start1][start2 + length - tmpSize] 
					= isScramble(tmpSize, start1, start2 + length - tmpSize);
			dpResult[length - tmpSize - 1][start1 + tmpSize][start2] 
					= isScramble(length - tmpSize, start1 + tmpSize, start2);
			dpResult[length - 1][start1][start2] = (dpResult[tmpSize - 1][start1][start2 + length - tmpSize]
					== true && dpResult[length - tmpSize - 1][start1 + tmpSize][start2] == true);
			if (dpResult[length - 1][start1][start2] == true)
				return true;
		}
		
		return false;
	}

    public static void main(String[] args) {
    	String s1 = "abcd";
    	String s2 = "bdac";
    	
    	ScrambleString ss = new ScrambleString();
    	
    	System.out.println(ss.isScramble(s1, s2));
    	System.exit(0);
    }
}
