package Accepted;

import java.util.ArrayList;
import java.util.List;

public class TextJustification {

	public List<String> fullJustify(String[] words, int L) {
        List<String> result = new ArrayList<String>();
        
        int num = words.length;
        
        if (L < 0 || num == 0)
        	return result;
        
        int index = 0;
        
        while (index < num) {
        	int i = 0;
        	int tmpLength = words[index].length();
        	
        	while (tmpLength <= L && index + i != num - 1) {
        		i ++;
        		tmpLength = tmpLength + words[index + i].length() + 1; 
        	}
        	
        	if (tmpLength > L) {
	        	tmpLength = tmpLength - words[index + i].length() - 1;
	        	i --;
        	}
        	
        	int numSpace = L - tmpLength + i;
        	
        	StringBuilder solution = new StringBuilder();
        	if (index + i == num - 1 || i == 0) {
        		for (int j = 0; j <= i; j ++) {
        			solution.append(words[index + j]);
        			if (j != i)
        				solution.append(' ');
        		}
//        		solution.substring(0, solution.length() - 1);
        		
        		for (int j = 0; j < numSpace - i; j ++)
        			solution.append(' ');
        		
        		result.add(solution.toString());
        	}
        	else {
        		for (int j = 0; j <= i; j ++) {
        			solution.append(words[index + j]);
        			if (j != i)
	        			for (int k = 0; k < numSpace / i; k ++)
	            			solution.append(' ');
        			
        			if (j < numSpace % i)
               			solution.append(' ');
        		}
        		
        		result.add(solution.toString());
        	}
        	
        	index = index + i + 1;
        }
        
        return result;
    }
	
	public static void main(String[] args) {
		String[] words = {"What","must","be","shall","be."};
//		String[] words = {""};
		
		int L = 12;
		List<String> result = new TextJustification().fullJustify(words, L);
		System.out.println(result);
	}
}
