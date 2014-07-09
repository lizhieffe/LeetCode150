package Accepted;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Permutations {

	List<List<Integer>> result;
    
    public List<List<Integer>> permute(int[] num) {
        result = new ArrayList<List<Integer>>();
        
        if (num.length == 0)
            return result;
            
        List<Integer> candidates = new LinkedList<Integer>();
        for (int i = 0; i < num.length; i ++)
        	candidates.add(num[i]);
        
        List<Integer> solution = new LinkedList<Integer>();
        
        permute(candidates, solution);
        
        return result;
    }
    
    private void permute(List<Integer> candidates, List<Integer> solution) {
    	
    	List<Integer> newCandidates;
    	List<Integer> newSolution;
    	
    	for (int i = 0; i < candidates.size(); i ++) {
    		newCandidates = new LinkedList<Integer>(candidates);
    		newSolution = new LinkedList<Integer>(solution);
    		
    		newSolution.add(newCandidates.remove(i));
    		
    		if (newCandidates.size() == 0)
    			result.add(newSolution);
    		else
    			permute(newCandidates, newSolution);
    	}
    }
    
    public static void main(String[] args) {
    	int[] num = {0, 1};
    	System.out.println(new Permutations().permute(num));
    }
}
