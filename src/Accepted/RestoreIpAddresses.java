package Accepted;

import java.util.ArrayList;
import java.util.List;

public class RestoreIpAddresses {
    
    ArrayList<String> result; 
    String s;
    
    public List<String> restoreIpAddresses(String s) {
    	
    	result = new ArrayList<String>();
    	
    	if (s == null || s.length() < 4)
    		return result;
    	
    	this.s = s;
    	List<String> solution = new ArrayList<String>();
    	
        getPart(0, solution);
        return result;
    }
    
    private void getPart(int start, List<String> solution) {
        if (s == null)
            return;
            
        int numToGet = 4 - solution.size();
        
        if (numToGet == 0 && start == s.length()) {
        	result.add(solution.get(0) + "." + solution.get(1) + "."
        			+ solution.get(2) + "." + solution.get(3));
        	return;
        }
        else if (numToGet == 0)
        	return;
        
        if (s.length() - start < numToGet)
            return;
        
        if (s.length() - start > numToGet * 3)
        	return;
        
        List<String> newSolution;
        for (int i = 0; i < Math.min(3, s.length() - start - numToGet + 1); i ++) {
        	newSolution = new ArrayList<String>(solution);
        	String tmpString = s.substring(start, start + i + 1);
        	Integer tmpInteger = Integer.parseInt(tmpString);
        	if (tmpInteger >= 0 && tmpInteger <= 255 && (tmpString.charAt(0) != '0' || tmpString.length() == 1)) {
        		newSolution.add(tmpString);
        		getPart(start + i + 1, newSolution);
        	}
        }
    }
    
    public static void main(String[] args) {
    	System.out.println(new RestoreIpAddresses().restoreIpAddresses("010010"));
    }
}
