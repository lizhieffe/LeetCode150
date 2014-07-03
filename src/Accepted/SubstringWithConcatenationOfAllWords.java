package Accepted;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class SubstringWithConcatenationOfAllWords {

	public List<Integer> findSubstring(String S, String[] L) {
        if (S == null || S.length() == 0 || L.length == 0 || L[0].length() == 0)
            return new ArrayList<Integer>();
            
        int start = 0;
        int length = S.length();
        int wordLength = L[0].length();
        
        HashMap<String, Integer> relation = new HashMap<String, Integer>();
        for (String word : L) {
            if (relation.containsKey(word))
                relation.put(word, relation.get(word) + 1);
            else
                relation.put(word, 1);
        }
        
        List<Integer> result = new ArrayList<Integer>();
        
        while (start <= length - wordLength * L.length) {
            HashMap<String, Integer> tmpRelation = new HashMap<String, Integer>(relation);
            
            for (int i = 0; i < L.length; i ++) {
                String tmp = S.substring(start + i * wordLength, start + (i + 1) * wordLength);
                if (tmpRelation.containsKey(tmp) == false) {
//                    start = start + i * wordLength + 1;
                    break;
                } else {
                    if (tmpRelation.get(tmp) > 1)
                        tmpRelation.put(tmp, tmpRelation.get(tmp) - 1);
                    else
                        tmpRelation.remove(tmp);
                }
            }
            
            if (tmpRelation.size() == 0) {
                result.add(start);
                
//                int i = 0;
//                while (start + L.length * wordLength + wordLength <= length)
//                	if (S.substring(start, start + wordLength)
//                        .equals(S.substring(start + L.length * wordLength, start + L.length * wordLength + wordLength))) {
//	                    i ++;
//	                    start = start + wordLength;
//	                    result.add(start);
//                	} else
//                		break;
//                
//                start = start + (L.length + i) * wordLength;
            }
            start ++;
        }
        
        return result;
    }
	
	public static void main(String[] args) {
		String S = "abababab";
		String[] L = {"a","b","a"};
		System.out.println(new SubstringWithConcatenationOfAllWords().findSubstring(S, L));
	}
}
