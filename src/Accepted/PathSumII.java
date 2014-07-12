package Accepted;

import java.util.ArrayList;
import java.util.List;

import Utils.TreeNode;

public class PathSumII {

	List<List<Integer>> result;
    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        result = new ArrayList<List<Integer>>();
        
        if (root == null)
            return result;
        
        List<Integer> solution = new ArrayList<Integer>();
        
        find(root, sum, solution);
        
        return result;
    }
    
    private void find(TreeNode cNode, int sum, List<Integer> solution) {
        if (cNode == null)
            return;
        
        List<Integer> tmpSolution = new ArrayList<Integer>(solution);
        tmpSolution.add(cNode.val);
        
        if (cNode.val == sum && cNode.left == null && cNode.right == null) {
            result.add(tmpSolution);
        }
        
        if (cNode.left != null)
            find(cNode.left, sum - cNode.val, tmpSolution);
            
        if (cNode.right != null)
            find(cNode.right, sum - cNode.val, tmpSolution);    
    }
}
