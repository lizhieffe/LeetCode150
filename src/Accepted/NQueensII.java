package Accepted;

import java.util.ArrayList;
import java.util.List;

public class NQueensII {

int result;
    
    public int totalNQueens(int n) {
        if (n <= 0)
            return 0;
        
        if (n == 1)
            return 1;
            
        result = 0;
        
        List<Integer> solution = new ArrayList<Integer>();
        find(0, n, solution);
        
        return result;
    }
    
    private void find(int row, int n, List<Integer> solution) {
        
        for (int i = 0; i < n; i ++) {
            if (isValid(i, solution) == true) {
                if (row == n - 1)
                    result ++;
                else {
                    List<Integer> tmpSolution = new ArrayList<Integer>(solution);
                    tmpSolution.add(i);
                    find(row + 1, n, tmpSolution);
                }
            }
                
        }
    }
    
    private boolean isValid(int i, List<Integer> solution) {
        int row = solution.size();
        
        for (int j = 0; j < solution.size(); j ++) {
            if (i == solution.get(j) || Math.abs(row - j) == Math.abs(i - solution.get(j)))
                return false;
        }
        
        return true;
    }
}
