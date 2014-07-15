package Accepted;

public class ValidPalindrome {

	public boolean isPalindrome(String s) {
        if (s == null)
            return false;
        if (s.length() <= 1)
            return true;
            
        int i = 0;
        int j = s.length() - 1;
        
        while (i < j) {
            char first = s.charAt(i);
            if (((first >= 'a' && first <= 'z') || (first >= 'A' && first <= 'Z')
            		|| (first >= '0' && first <= '9')) == false) {
                i ++;
                continue;
            }
            
            char second = s.charAt(j);
            if (((second >= 'a' && second <= 'z') || (second >= 'A' && second <= 'Z')
            		|| (second >= '0' && second <= '9')) == false) {
                j --;
                continue;
            }
            
            if ((first >= '0' && first <= '9') || (second >= '0' && second <= '9')) {
            	if (first != second)
            		return false;
            }
            else { 
	            if ((Math.abs(first - second) == 0 || 
	            		Math.abs(first - second) == Math.abs('A' - 'a')) == false)
	                return false;
            }
            
            i ++;
            j --;
        }
        
        return true;
    }
	
	public static void main(String[] args) {
		String s = "ab2a";
		ValidPalindrome service = new ValidPalindrome();
		boolean result = service.isPalindrome(s);
		
		System.out.println(result);
	}
}
