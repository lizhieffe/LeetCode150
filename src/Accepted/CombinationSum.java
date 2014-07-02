package Accepted;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CombinationSum {

	List<List<Integer>> results;
    int[] candidates;
    int length;
    
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        
        results = new ArrayList<List<Integer>>();
        this.length = candidates.length;
        
        if (length == 0)
            return results;
            
        Arrays.sort(candidates);
        this.candidates = candidates;
        
        List<Integer> solution = new ArrayList<Integer>();
        find(0, target, solution);
        
        return results;
    }
    
    private void find(int startId, int target, List<Integer> solution) {
        if (startId >= length)
            return;
        
        if (candidates[startId] > target)
            return;
        
        int tmp = 0;
        int i = 0;
        while (tmp <= target) {
            List<Integer> tmpSolution = new ArrayList<Integer>(solution);
            
            for (int j = 0; j < i; j ++)
                tmpSolution.add(candidates[startId]);
            
            if (tmp == target) {
                results.add(tmpSolution);
                break;
            }
            
            find(startId + 1, target - tmp, tmpSolution);
            tmp = tmp + candidates[startId];
            i ++;
        }
    }
}
