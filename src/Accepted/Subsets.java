package Accepted;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Subsets {
	
	ArrayList<List<Integer>> results = new ArrayList<List<Integer>>();
	int length;
	int[] S;
	
    public List<List<Integer>> subsets(int[] S) {
        this.length = S.length;
        
        if (length == 0)
        	return results;
        
        this.S = S;
        Arrays.sort(this.S);
        
        for (int i = 0; i <= length; i ++)
        	getSubsets(0, i, new ArrayList<Integer>());
        
        return results;
    }
    
    private void getSubsets(int start, int digits, List<Integer> solution) {
    	if (digits == 0) {
    		results.add(solution);
    		return;
    	}
    	
    	for (int i = start; i < length - digits + 1; i ++) {
    		List<Integer> tmpSolution = new ArrayList<Integer>(solution);
    		tmpSolution.add(S[i]);
    		getSubsets(i + 1, digits - 1, tmpSolution);
    	}
    }
    
    public static void main(String[] args) {
    	int[] S = {1, 2};
    	System.out.println(new Subsets().subsets(S));
    	
    }
}
