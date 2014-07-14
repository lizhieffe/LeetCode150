package Accepted;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PermutationsII {

	List<List<Integer>> result = new ArrayList<List<Integer>>();
    int length;
    
    public List<List<Integer>> permuteUnique(int[] num) {
        length = num.length;
        
        if (length == 0)
            return result;
        
        Arrays.sort(num);
        
        ArrayList<Integer> candidates = new ArrayList<Integer>();
        for (int i = 0; i < length; i ++)
            candidates.add(num[i]);
            
        ArrayList<Integer> solution = new ArrayList<Integer>();
        
        permuteUnique(candidates, solution);
        
        return result;
    }
    
    private void permuteUnique(ArrayList<Integer> candidates, ArrayList<Integer> solution) {
        if (candidates.size() == 0)
            result.add(solution);
            
        Integer last = null; 
        for (int i = 0; i < candidates.size(); i ++) {
            if (candidates.get(i) != last) {
                ArrayList<Integer> tmpCandidates = new ArrayList<Integer>(candidates);
                ArrayList<Integer> tmpSolution = new ArrayList<Integer>(solution);
                tmpSolution.add(tmpCandidates.remove(i));
                permuteUnique(tmpCandidates, tmpSolution);
                last = candidates.get(i);
            }
        }
    }
}
