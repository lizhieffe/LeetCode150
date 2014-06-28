package TimeLimitExceeded;

import java.util.ArrayList;
import java.util.List;

public class Combinations {

	private List<List<Integer>> result = new ArrayList<List<Integer>>();
    
    public List<List<Integer>> combine(int n, int k) {
        if (n < k || n < 1)
            return result;
        
        List<Integer> solution = new ArrayList<Integer>();
        getCombined(1, n + 1, k, solution);
        
        return result;
    }
    
    private void getCombined(int start, int end, int k, List<Integer> solution) {
        if (k == 1) {
            for (int i = start; i < end; i ++) {
                ArrayList<Integer> tmp = new ArrayList<Integer>(solution);
                tmp.add(i);
                result.add(tmp);
            }
        } else {
            for (int i = start; i < end - k + 1; i ++) {
                ArrayList<Integer> tmp = new ArrayList<Integer>(solution);
                tmp.add(i);
                getCombined(i + 1, end, k - 1, tmp);
            }
        }
    }
    
    public static void main(String[] args) {
    	
    	int n = 4;
    	int k = 2;
    	
    	Combinations service = new Combinations();
    	System.out.println(service.combine(n, k));
    }
}
