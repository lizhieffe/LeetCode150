package Accepted;


public class PalindromeNumber {

	public boolean isPalindrome(int x) {
        if (x < 0)
        return false;
        
        int digits = 1;
        long div = 10;
        while (x / div > 0) {
        div = div * 10;
        digits ++;
        }
        
        div = div / 10;
        for (int i = 0; i < digits / 2; i ++) {
        if (x / div != x % 10)
        return false;
        x = (int) ((x - (x / div) * div) / 10); 
        div = div / 100;
        }
        
        return true;
    }
	public static void main(String[] args) {
		int x = 1000000001;
		PalindromeNumber service = new PalindromeNumber();
		System.out.println(service.isPalindrome(x));
	}
}

