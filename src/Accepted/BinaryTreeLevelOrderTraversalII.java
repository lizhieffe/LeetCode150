package Accepted;

import java.util.LinkedList;
import java.util.List;

import Utils.TreeNode;

public class BinaryTreeLevelOrderTraversalII {
	int depth;
    LinkedList<List<Integer>> result;
    
    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        result = new LinkedList<List<Integer>>();
        
        if (root == null)
            return result;
            
        depth = 0;
        
        level(root, 0);
        
        return result;
    }
    
    private void level(TreeNode cNode, int cDepth) {
        if (cNode == null)
            return;
            
        if (result.size() < cDepth + 1) {
            LinkedList<Integer> solution = new LinkedList<Integer>();
            solution.add(cNode.val);
            result.addFirst(solution);
        }
        else {
            result.get(result.size() - cDepth - 1).add(cNode.val);
        }
        
        level(cNode.left, cDepth + 1);
        level(cNode.right, cDepth + 1);

    }
}
