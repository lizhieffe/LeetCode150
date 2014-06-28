package Accepted;

import java.util.LinkedList;

public class ValidParentheses {

	public boolean isValid(String s) {
        if (s == null)
            return false;
        
        int length = s.length();
        if (length == 0)
            return true;
        if (length % 2 == 1)
            return false;
            
        char[] chars = s.toCharArray();
        LinkedList<Character> charsList = new LinkedList<Character>();
        for (int i = 0; i < chars.length; i ++) {
            char cChar = chars[i];
            
            if (cChar == ')')
                if (charsList.size() > 0 && charsList.getLast().equals('('))
                    charsList.removeLast();
                else
                    return false;
            else if (cChar == ']')
                if (charsList.size() > 0 && charsList.getLast().equals('['))
                    charsList.removeLast();
                else
                    return false;
            else if (cChar == '}')
                if (charsList.size() > 0 && charsList.getLast().equals('{'))
                    charsList.removeLast();
                else
                    return false;
            else
                charsList.addLast(Character.valueOf(cChar));
        }
        
        return charsList.size() == 0 ? true : false;
    }
}
