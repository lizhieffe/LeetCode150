package Accepted;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;


public class Anagrams {

    public List<String> anagrams(String[] strs) {
        ArrayList<String> list = new ArrayList<String>();
        
        int length = strs.length;
        
        if (length < 2)
        return list;
        
        ArrayList<String> result = new ArrayList<String>();
        HashMap<String, Integer> appeared = new HashMap<String, Integer>();
        
        for (int i = 0; i < length; i ++) {
        String sortedString = sortChars(strs[i]);
        if (!appeared.containsKey(sortedString))
        appeared.put(sortedString, i);
        else {
        int previousIndex = appeared.get(sortedString);
        
        if (previousIndex >= 0) {
        result.add(strs[previousIndex]);
        appeared.put(sortedString, -1);
        }
        
        result.add(strs[i]);
        }
        }
        
        return result;
    }
    
    private String sortChars(String input) {
    if (input == null)
   return null;
    
    if (input == "")
    return input;
    
    char[] chars = input.toCharArray();
    Arrays.sort(chars);
    
    return new String(chars);
    }

}