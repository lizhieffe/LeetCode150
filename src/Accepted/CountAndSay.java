package Accepted;

public class CountAndSay {

	public String countAndSay(int n) {
                
        String tmp = "1";
        for (int i = 0; i < n - 1; i ++)
            tmp = generate(tmp);
            
        return tmp;
    }
    
    private String generate(String input) {
        char[] chars = input.toCharArray();
        String result = "";

        char last = chars[0];
        int count = 1;
        
        for (int i = 1; i < chars.length; i ++) {
            if (chars[i] != last) {
                result = result + count + last;
                last = chars[i];
                count = 1;
            } else {
                count ++;
            }
        }
        
        result = result + count + last;
        return result;
    }
    
    public static void main(String[] args) {
    	int n = 4;
    	
    	CountAndSay service = new CountAndSay();
    	System.out.print(service.countAndSay(n));
    }
}
