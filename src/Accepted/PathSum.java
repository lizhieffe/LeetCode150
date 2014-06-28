package Accepted;

import Utils.TreeNode;

public class PathSum {

	public boolean hasPathSum(TreeNode root, int sum) {
        if (root == null)
            return false;
            
        if (root.left == null && root.right == null)
            return sum == root.val;
            
        boolean result = false;
        if (root.right != null)
            result = result || hasPathSum(root.right, sum - root.val);
        if (root.left != null )
            result = result || hasPathSum(root.left, sum - root.val);
        
        return result;
    }
}
