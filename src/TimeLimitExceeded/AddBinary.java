package TimeLimitExceeded;

public class AddBinary {

	public String addBinary(String a, String b) {
        if (a == null && b == null)
        return null;
        
        if (a == null)
        return b;
        if (b== null)
        return a;
        
        int lengthA = a.length();
        int lengthB = b.length();
        int length = Math.max(lengthA, lengthB);
        
        String result = "";
        
        int addition = 0;
        
        for (int i = 0; i < length; i ++) {
        int first = lengthA > i ? Character.getNumericValue(a.charAt(lengthA - i - 1)) : 0;
        int second = lengthB > i ? Character.getNumericValue(b.charAt(lengthB - i - 1)) : 0;

        int tmp = first + second + addition;
        if (tmp > 1) {
        result = tmp % 2 + result;
        addition = 1;
        } else {
        result = tmp + result;
        addition = 0;
        }
        }
        
        if (addition == 1)
        result = addition + result;
        
        return result;
    }
    
    public static void main(String[] args) {
    String a = "11";
    String b = "1";
    
    AddBinary service = new AddBinary();
    System.out.println(service.addBinary(a, b));
    }
}
