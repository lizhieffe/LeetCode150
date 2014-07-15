package TimeLimitExceeded;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/*
 * need to rewrite
 * check http://blog.segmentfault.com/code/1190000000458960 to see how to record char not using hashmap 
 */

public class MinWindowSubstring {
	public String minWindow(String S, String T) {
        if (S == null || T == null || S == "" || T == "")
        	return "";
        
        char[] TChars = T.toCharArray();
        HashMap<Character, List<Integer>> record = new HashMap<Character, List<Integer>>();
        for (int i = 0; i < TChars.length; i ++) {
        	if (record.containsKey(TChars[i]) == false)
        		record.put(TChars[i], new ArrayList<Integer>());
        }
        
        char[] SChars = S.toCharArray();
        for (int i = 0; i < SChars.length; i ++) {
        	if (record.containsKey(SChars[i]) == true)
        		record.get(SChars[i]).add(i);
        }
        
        Iterator it = record.entrySet().iterator();
        while (it.hasNext()) {
            Map.Entry pairs = (Map.Entry)it.next();
            if (((List<Integer>)pairs.getValue()).size() == 0)
            	return "";
        }
        
        int[] result = {0, Integer.MAX_VALUE};
        boolean off = false;
        
        while (off != true) {
        	int start = Integer.MAX_VALUE;
        	int end = Integer.MIN_VALUE;
        	Character startChar = ' ', endChar;
        	
        	it = record.entrySet().iterator();
        	
        	while (it.hasNext()) {
                Map.Entry pairs = (Map.Entry)it.next();
                if (((List<Integer>)pairs.getValue()).size() == 0) {
                	off = true;
                	break;
                }
                
                if (((List<Integer>)pairs.getValue()).get(0) < start) {
                	start = ((List<Integer>)pairs.getValue()).get(0);
                	startChar = (Character)pairs.getKey();
                }
                
                if (((List<Integer>)pairs.getValue()).get(0) > end) {
                	end = ((List<Integer>)pairs.getValue()).get(0);
                	endChar = (Character)pairs.getKey();
                }   	
            }
        	
        	if (off == false) {
	        	((List<Integer>)record.get(startChar)).remove(0);
	        	
	        	if (result[1] - result[0] > end - start) {
	            	result[0] = start;
	            	result[1] = end;
	            }
        	}
        }
        
        return S.substring(result[0], result[1] + 1);
    }
	
	public static void main(String[] args) {
		MinWindowSubstring service = new MinWindowSubstring();
		String S = "abdyeo[ermdnsi";
		String T = "ni";
		String result = service.minWindow(S, T);
		System.out.println(result);
	}
}
