package Accepted;

/*
 * Note the multiplanation stack overflow http://fisherlei.blogspot.com/2013/01/leetcode-sqrtx.html
 */

public class sqrt {

	public int sqrt(int x) {
        if (x < 0)
        	return -1;
        
        if (x < 1)
        	return 0;
        
        int tmp = x;
        while (tmp >= Math.sqrt(Integer.MAX_VALUE) || tmp * tmp > x) {
        	tmp = tmp / 2;
        }
        
        if (tmp * tmp == x)
        	return tmp;
        
        int upper = tmp;
        while (upper < Math.sqrt(Integer.MAX_VALUE) && upper * upper < x)
        	upper = upper * 2;
        if (upper > Math.sqrt(Integer.MAX_VALUE))
        	upper = (int) Math.sqrt(Integer.MAX_VALUE);
        
        int lower = tmp;
        tmp = (upper + lower) / 2;
        
        while (1 > 0) {
        	if (tmp * tmp < x)
        		lower = tmp;
        	else if (tmp * tmp > x)
        		upper = tmp;
        	else
        		return tmp;
        	
        	if (upper - lower <= 1) {
        		int tmp1 = upper * upper;
        		if (tmp1 <= x)
        			return upper;
        		else
        			return lower;
        	}
        	
        	tmp = (upper + lower) / 2;
        }
    }
	
	public static void main(String[] args) {
		int x = 2147395599;
		
		System.out.println(new sqrt().sqrt(x));
	}
}
