package Accepted;

public class ReverseInteger {
	public int reverse(int x) {
        
        int tmp = Math.abs(x);
        int result = 0;
        while (tmp > 0) {
            result = tmp % 10 + result * 10;
            tmp = tmp / 10;
        }
        
        if (tmp < 0)
            return -1;
        else
            return x > 0 ? result : (-1) * result;
    }
}
