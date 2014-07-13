package Accepted;

import java.util.ArrayList;
import java.util.List;

import Utils.TreeNode;

public class BinaryTreePreorderTraversal {
	List<Integer> result;
    
    public List<Integer> preorderTraversal(TreeNode root) {
        result = new ArrayList<Integer>();
        
        if (root == null)
            return result;
            
        traverse(root);
        
        return result;
    }
    
    private void traverse(TreeNode cNode) {
        if (cNode == null)
            return;
        
        result.add(cNode.val);
        
        traverse(cNode.left);
        traverse(cNode.right);
    }
}
