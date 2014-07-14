package Accepted;

import java.util.ArrayList;
import java.util.List;

import Utils.TreeNode;

public class UniqueBinarySearchTreeII {

	List<TreeNode> result;
    public List<TreeNode> generateTrees(int n) {
        if (n <= 0)
            return 0;
        if (n == 1)
            return 1;
            
        List<Integer> candidates = new ArrayList<Integer>();
        for (int i = 0; i < n; i ++) 
            candidates.add(i + 1);
        
        List<TreeNode> result = new ArrayList<TreeNode>();
        
        for (int i = 0; i < n; i ++) {
            List<Integer> tmpCandidates = new ArrayList<Integer>(candidates);
            tmpCandidates.remove(new Integer(i + 1));
            add(generate(i, tmpCandidates));
        }
        
        return result;
    }
    
    private void generate(int i, List<Integer> candidates) {
        
    }
}
