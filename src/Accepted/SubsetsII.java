package Accepted;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SubsetsII {

	List<List<Integer>> result;
    int[] num;
    
    public List<List<Integer>> subsetsWithDup(int[] num) {
        result = new ArrayList<List<Integer>>();
        result.add(new ArrayList<Integer>());
        
        if (num.length == 0)
            return result;
            
        this.num = num;
        Arrays.sort(num);
        List<Integer> solution = new ArrayList<Integer>();
        
        find (0, solution);
        return result;
    }
    
    private void find(int start, List<Integer> solution) {
        if (start >= num.length)
            return;
        
        List<Integer> tmpSolution = new ArrayList<Integer>(solution);
        
        int tmp = num[start];
        int i = start + 1;
        while (i < num.length) {
            if (num[i] == tmp)
                i ++;
            else {
                find(i, tmpSolution);
                break;
            }
        }
        
        tmpSolution.add(num[start]);
        result.add(tmpSolution);
        
        List<Integer> tmpSolution1 = new ArrayList<Integer>(tmpSolution);
        find (start + 1, tmpSolution1);

    }
}
