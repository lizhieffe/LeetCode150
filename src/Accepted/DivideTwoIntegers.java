package Accepted;

/*
 * Passed.
 * But this is a good question. One need to take care of the stack overflow of int
 * The solution is to use long in the middle steps
 * http://fisherlei.blogspot.com/2012/12/leetcode-divide-two-integers.html
 */

public class DivideTwoIntegers {

	public int divide(int dividend, int divisor) {
        
        if (divisor == 1)
            return dividend;
        
        int count = 0;
        
        long tmpDividend = dividend;
        tmpDividend = Math.abs(tmpDividend);
        
        long tmpDivisor = divisor;
        tmpDivisor = Math.abs(tmpDivisor);

        
        while (tmpDividend >= tmpDivisor) {
        	long bitDivisor = tmpDivisor;
            
            int i = 1;
            while (tmpDividend >= bitDivisor) {
            	if ((bitDivisor << 1) < bitDivisor)
                	break;
            	
                bitDivisor = tmpDivisor << i;
                i ++;
            }
            
            count = count + (1 << (i - 2));
            tmpDividend = (bitDivisor == tmpDivisor ) 
                    ? tmpDividend - tmpDivisor : tmpDividend - (bitDivisor >> 1);
        }
        
        return (dividend > 0 && divisor > 0) || (dividend < 0 && divisor < 0) ? count : (-1) * count;
    }
	
	public static void main(String[] args) {
		if(-2147483648 < 0)
			System.out.println("111");
		DivideTwoIntegers service = new DivideTwoIntegers();
		System.out.println(service.divide(-1010369383, -2147483648));
	}
}
