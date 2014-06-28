package Accepted;

import java.util.LinkedList;

public class EvaluateReversePolishNotation {

	public int evalRPN(String[] tokens) {
        if (tokens == null || tokens.length == 0)
            return 0;
        
        LinkedList<Integer> remains = new LinkedList<Integer>();
        
        int length = tokens.length;
        for (int i = 0; i < length; i ++) {

            if (tokens[i].length() == 1 
                    && ( tokens[i].charAt(0) == '+' 
                    || tokens[i].charAt(0) == '-' 
                    || tokens[i].charAt(0) == '*'
                    || tokens[i].charAt(0) == '/' ) ) {
                int b = remains.removeLast();
                int a = remains.removeLast();
                Integer tmp;
                if (tokens[i].charAt(0) == '+')
                    tmp = a + b;
                else if (tokens[i].charAt(0) == '-')
                    tmp = a - b;
                else if (tokens[i].charAt(0) == '*')
                    tmp = a * b;
                else
                    tmp = a / b;
                remains.add(tmp);
            } else 
                remains.add(Integer.parseInt(tokens[i]));
            
        }
        
        return remains.removeLast();
    }
}
