package Accepted;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import Utils.TreeNode;

public class BinaryTreePostorderTraversalIteratively {
	
	List<Integer> result;
	LinkedList<TreeNode> stack;
	
	public List<Integer> postorderTraversal(TreeNode root) {
		result = new ArrayList<Integer>();
		
		if (root == null)
			return result;
		
		stack = new LinkedList<TreeNode>();
		stack.add(root);
		
		while (stack.size() > 0) {
			TreeNode last = stack.get(stack.size() - 1);
			if (last.left == null && last.right == null) {
				result.add(last.val);
				stack.removeLast();
			}
			else {
				if (last.right != null) {
					stack.add(last.right);
					last.right = null;
				}
				
				if (last.left != null) {
					stack.add(last.left);
					last.left = null;
				}
			}
			
		}
		return result;
    }
}
