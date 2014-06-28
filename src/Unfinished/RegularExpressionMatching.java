package Unfinished;

public class RegularExpressionMatching {

	Boolean[][] dp;
    int length1;
    int length2;
    String s, p;
    
    public boolean isMatch(String s, String p) {
        if (s == null || p == null)
            return false;
            
        length1 = s.length();
        length2 = p.length();
        
        this.s = s;
        this.p = p;
        
        dp = new Boolean[length1][length2];
        
        return isMatch(0, 0);
    }
    
    private boolean isMatch(int i, int j) {
        if (i >= length1 && j >= length2)
            return true;
        else if (i >= length1) {
            if (j == length2 - 1) {
                if (p.charAt(j) == '.')
                    return true;
                else
                    return false;
            } else {
                if (p.charAt(j) == '.' && p.charAt(j + 1) == '*')
                    return isMatch(i, j + 2);
                else if (p.charAt(j) == '.')
                    return isMatch(i, j + 1);
                else
                    return false;
            }
        } else if (j >= length2) {
                return false;
        } else {
            if (dp[i][j] != null)
                return dp[i][j];
            if (p.charAt(j) == '.') {
                if (j == length2 - 1) {
                    if (i == length1 - 1) {
                        dp[i][j] = true;
                        return true;
                    } else {
                        dp[i][j] = false;
                        return false;
                    }
                        
                } else {
                    if (p.charAt(j + 1) == '*') {
                        Boolean tmp;
                        
                        for (int k = 0; k <= length1 - i; k ++) {
                            tmp = isMatch(i + k, j + 2);
                            if (i + k < length1 && j + 2 < length2)
                            	dp[i + k][j + 2] = tmp;
                            if (tmp == true)
                                return true;
                        }
                    } else {
                        Boolean tmp = isMatch(i + 1, j + 1);
                        if (i + 1 < length1 && j + 1 < length2)
                            dp[i + 1][j + 1] = tmp;
                        return tmp;
                    }
                }
            } else if (s.charAt(i) == p.charAt(j)) {
                if (j == length2 - 1) {
                    if (i == length1 - 1) {
                        dp[i][j] = true;
                        return true;
                    } else {
                        dp[i][j] = false;
                        return false;
                    }
                        
                } else {
                    if (p.charAt(j + 1) == '*') {
                        Boolean tmp;
                        
                        for (int k = 0; k <= length1 - i; k ++) {
                            if (k == length1 - i) {
                                dp[i][j] = true;
                                return true;
                            }
                            if (s.charAt(i + k) != s.charAt(i))
                                if (i + k < length1) {
                                	tmp = isMatch(i + k, j);
                                	dp[i + k][j] = tmp;
                                	return tmp;
                                } else
                                	break;
                                	
                            tmp = isMatch(i + k, j + 2);
                            if (i + k < length1 && j + 2 < length2)
                            	dp[i + k][j + 2] = tmp;
                            if (tmp == true) {
                                dp[i][j] = true;
                                return true;
                            }
                        }
                    } else {
                        Boolean tmp = isMatch(i + 1, j + 1);
                        if (i + 1 < length1 && j + 1 < length2)
                            dp[i + 1][j + 1] = tmp;
                        dp[i][j] = tmp;
                        return tmp;
                    }
                }
            } else if (j != length2 -1) {
            	if (p.charAt(j + 1) == '*') {
            		Boolean tmp = isMatch(i, j + 2);
            		dp[i][j] = tmp;
            		return tmp;
            	}
            }
            
            dp[i][j] = false;
            return false;
        }
    }
    
    public static void main(String[] args) {
    	String a = "aab";
    	String b = "c*a*b";
    	
    	RegularExpressionMatching service = new RegularExpressionMatching();
    	System.out.println(service.isMatch(a, b));
    }
}
