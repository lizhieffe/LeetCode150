package Accepted;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import Utils.TreeNode;

public class BinaryTreeInorderTraversalIteratively {

    LinkedList<TreeNode> stack;
    public List<Integer> inorderTraversal(TreeNode root) {
    	List<Integer> result = new ArrayList<Integer>();
        if (root == null)
            return result;
            
        stack = new LinkedList<TreeNode>();
        
        TreeNode cNode = root;
        while (stack.size() > 0 || cNode != null) {
        	while (cNode != null) {
        		stack.add(cNode);
        		cNode = cNode.left;
        	}
        	cNode = stack.removeLast();
        	result.add(cNode.val);
        	cNode = cNode.right;
        }
                
        return result;
    }
    
}
