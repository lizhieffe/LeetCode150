package Accepted;

public class PlusOne {
	
	public int[] plusOne(int[] digits) {
        int length = digits.length;
        
        if (length == 0)
            return digits;
            
        int modifier = 1;
        
        for (int i = 0; i < length; i ++) {
            int tmp = digits[length - i - 1] + modifier;
            digits[length - i - 1] = tmp % 10;
            modifier = tmp / 10;
        }
        
        if (modifier > 0) {
            int[] result = new int[length + 1];
            result[0] = modifier;
            for (int i = 1; i < length + 1; i ++)
                result[i] = digits[i - 1];
            return result;
        }
        else
            return digits;
    }
}
