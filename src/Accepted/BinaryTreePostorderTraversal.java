package Accepted;

import java.util.ArrayList;
import java.util.List;

import Utils.TreeNode;

public class BinaryTreePostorderTraversal {
	
	List<Integer> result;
	
	public List<Integer> postorderTraversal(TreeNode root) {
		result = new ArrayList<Integer>();
		
		if (root == null)
			return result;
		
		traverse(root);
		
		return result;
    }
	
	private void traverse(TreeNode root) {
		if (root == null)
			return;
		
		if (root.right != null)
			traverse(root.right);
		
		if (root.left != null)
			traverse(root.left);
		
		result.add(root.val);
	}
}
