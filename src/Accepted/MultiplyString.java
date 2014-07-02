package Accepted;

/*
 * the algorithm should be right
 * O(n2)
 * there can be better solution http://www.cnblogs.com/TenosDoIt/p/3735309.html
 */
public class MultiplyString {
	
	public String multiply(String num1, String num2) {

		int length1 = num1.length();
        int length2 = num2.length();
        
        if (length1 == 0 || length2 == 0)
        	return "";
        
        boolean isNegative = false;
        if (num1.charAt(0) == '-' && num2.charAt(0) != '-' || num1.charAt(0) != '-' && num2.charAt(0) == '-')
        	isNegative = true;
        
		num1 = num1.charAt(0) == '-' ? num1.substring(1, num1.length()) : num1;
		num2 = num2.charAt(0) == '-' ? num2.substring(1, num2.length()) : num2;
		
		length1 = num1.length();
        length2 = num2.length();
	
		char[] c1 = num1.toCharArray();
		char[] c2 = num2.toCharArray();
		char[] result = new char[length1 + length2];
		for (int i = 0; i < length1 + length2; i ++)
			result[i] = Character.forDigit(0, 10);
		
		for (int i = length1 - 1; i >= 0 ; i --) {
			char[] midResult = new char[length2 + 1];
			for (int k = 0; k < 1 + length2; k ++)
				midResult[k] = Character.forDigit(0, 10);
			
			for (int j = length2 - 1; j >= 0; j --) {
				Integer tmp = Character.getNumericValue(c1[i]) * Character.getNumericValue(c2[j]);
				int digits = tmp.toString().length();
				char[] tmpChar = new char[digits + length1 - 1 - i + length2 -1 -j];
				if (digits == 1)
					tmpChar[0] = Character.forDigit(tmp, 10);
				else {
					tmpChar[0] = Character.forDigit(tmp / 10, 10);
					tmpChar[1] = Character.forDigit(tmp % 10, 10);
				}
				for (int k = 0; k < length1 - 1 - i + length2 -1 -j; k ++)
					tmpChar[digits + k] = '0';
				
				midResult = combineChars(midResult, tmpChar);
			}
			result = combineChars(midResult, result);
		}
		
		int zeroDigits = 0;
		for (int i = 0; i < result.length; i ++) {
			if (result[i] == '0')
				zeroDigits ++;
			else
				break;
		}
		
		char[] newResult = new char[result.length - zeroDigits + (isNegative == true ? 1 : 0)];
		if (isNegative == true)
			newResult[0] = '-';
		for (int i = 0; i < newResult.length - 1; i ++)
			newResult[i + (isNegative == true ? 1 : 0)] = result[zeroDigits + i];
			
		return new String(newResult);
    }
	
	private char[] combineChars(char[] c1, char[] c2) {
		int length1 = c1.length;
		int length2 = c2.length;
		int length = Math.max(length1, length2) + 1;
		
		if (length1 == 0 && length2 == 0)
			return c1;
		
		if (length1 == 0)
			return c2;
		
		if (length2 == 0)
			return c1;
		
		char[] result = new char[length];
		
		int modifier = 0;
		for (int i = 0; i < length; i ++) {
			int tmpResult = modifier;
			
			if (i < length1)
				tmpResult = Character.getNumericValue(c1[length1 - i - 1]) + tmpResult;
			
			if (i < length2)
				tmpResult = Character.getNumericValue(c2[length2 - i - 1]) + tmpResult;
			
			result[length - i - 1] = Character.forDigit(tmpResult % 10, 10);
			modifier = tmpResult >= 10 ? 1 : 0;
		}
		
		return result;
	}
	
	public static void main(String[] args) {
		String num1 = "-66";
		String num2 = "55";
		
		System.out.println(new MultiplyString().multiply(num1, num2));
	}
}
