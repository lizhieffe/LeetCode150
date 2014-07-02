package Accepted;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class LetterCombinationsOfAPhoneNumber {

	HashMap<Character, List<Character>> relation;
    String digits;
    int length;
    List<String> result;
    
    public List<String> letterCombinations(String digits) {
        
        result = new ArrayList<String>();
        
        if (digits == null)
            return result;
        
        this.digits = digits;
        this.length = digits.length();
        if(length == 0) {
            result.add("");
            return result;
        }
            
        relation = new HashMap<Character, List<Character>>();
        
        Character[] a2 = {'a', 'b', 'c'};
        List<Character> l2 = new ArrayList<Character>(Arrays.asList(a2));
        
        Character[] a3 = {'d', 'e', 'f'};
        List<Character> l3 = new ArrayList<Character>(Arrays.asList(a3));
        
        Character[] a4 = {'g', 'h', 'i'};
        List<Character> l4 = new ArrayList<Character>(Arrays.asList(a4));
        
        Character[] a5 = {'j', 'k', 'l'};
        List<Character> l5 = new ArrayList<Character>(Arrays.asList(a5));
        
        Character[] a6 = {'m', 'n', 'o'};
        List<Character> l6 = new ArrayList<Character>(Arrays.asList(a6));
        
        Character[] a7 = {'p', 'q', 'r', 's'};
        List<Character> l7 = new ArrayList<Character>(Arrays.asList(a7));
        
        Character[] a8 = {'t', 'u', 'v'};
        List<Character> l8 = new ArrayList<Character>(Arrays.asList(a8));
        
        Character[] a9 = {'w', 'x', 'y', 'z'};
        List<Character> l9 = new ArrayList<Character>(Arrays.asList(a9));
        
        relation.put(new Character('2'), l2);
        relation.put(new Character('3'), l3);
        relation.put(new Character('4'), l4);
        relation.put(new Character('5'), l5);
        relation.put(new Character('6'), l6);
        relation.put(new Character('7'), l7);
        relation.put(new Character('8'), l8);
        relation.put(new Character('9'), l9);

        String solution = "";
        
        combine(0, solution);
        
        return result;
    }
    
    private void combine(int start, String solution) {
        
        Character c = digits.charAt(start);
        
        for (int i = 0; i < relation.get(c).size(); i ++) {
            Character represent = relation.get(c).get(i);
            if (start == length - 1)
                result.add(solution + represent);
            else
                combine(start + 1, solution + represent);
                
        }
    }
}
