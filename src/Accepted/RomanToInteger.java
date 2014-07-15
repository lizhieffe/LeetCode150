package Accepted;

import java.util.HashMap;

public class RomanToInteger {

	public int romanToInt(String s) {
        if (s == null)
            return 0;
            
        HashMap<Character, Integer> relation = new HashMap<Character, Integer>();
        relation.put('M', 1000);
        relation.put('D', 500);
        relation.put('C', 100);
        relation.put('L', 50);
        relation.put('X', 10);
        relation.put('V', 5);
        relation.put('I', 1);
        
        char[] chars = s.toCharArray();
        int length = chars.length;
        int result = 0;
        
        for (int i = 0; i < length; i ++) {
            if (i != length - 1) {
                if (relation.get(chars[i]) < relation.get(chars[i + 1])) {
                    result = result + relation.get(chars[i + 1]) - relation.get(chars[i]);
                    i ++;
                    continue;
                }
            }
            result = result + relation.get(chars[i]);
        }
        
        return result;
    }
}
