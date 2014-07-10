package Accepted;

import java.util.HashMap;

import Utils.TreeNode;

public class ValidateBinarySearchTree {
	
	HashMap<TreeNode, Integer> minValue, maxValue;
	
	public boolean isValidBST(TreeNode root) {
        if (root == null)
        	return true;
        
        if (root.left == null && root.right == null)
        	return true;
        
        minValue = new HashMap<TreeNode, Integer>();
        maxValue = new HashMap<TreeNode, Integer>();
        
        if (root.left != null)
        	if (getMax(root.left) >= root.val)
        		return false;
        
        if (root.right != null)
        	if (getMin(root.right) <= root.val)
        		return false;
        
        if (root.left != null)
        	if (isValidBST(root.left) == false)
        		return false;
        
        if (root.right != null)
        	if (isValidBST(root.right) == false)
        		return false;
        
        return true;
    }
	
	private int getMin(TreeNode root) {
		if (root == null)
			return Integer.MIN_VALUE;
		
		if (minValue.containsKey(root))
			return minValue.get(root);
		
		int result = root.val;
		
		if (root.left != null)
			result = Math.min(result, getMin(root.left));
		
		if (root.right != null)
			result = Math.min(result, getMin(root.right));
		
		minValue.put(root, result);
		return result;
	}
	
	private int getMax(TreeNode root) {
		if (root == null)
			return Integer.MAX_VALUE;
		
		if (maxValue.containsKey(root))
			return maxValue.get(root);
		
		int result = root.val;
		
		if (root.left != null)
			result = Math.max(result, getMax(root.left));
		
		if (root.right != null)
			result = Math.max(result, getMax(root.right));
		
		maxValue.put(root, result);
		return result;
	}
}
