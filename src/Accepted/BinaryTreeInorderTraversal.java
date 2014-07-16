package Accepted;

import java.util.ArrayList;
import java.util.List;

import Utils.TreeNode;

public class BinaryTreeInorderTraversal {

	List<Integer> result;
    
    public List<Integer> inorderTraversal(TreeNode root) {
        result = new ArrayList<Integer>();
        if (root == null)
            return result;
            
        travel(root);
        
        return result;
    }
    
    private void travel(TreeNode cNode) {
        if (cNode == null)
            return;
        
        travel(cNode.left);
        result.add(cNode.val);
        travel(cNode.right);
    }
}
