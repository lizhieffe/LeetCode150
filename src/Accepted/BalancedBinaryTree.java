package Accepted;

import Utils.TreeNode;

public class BalancedBinaryTree {

    public boolean isBalanced(TreeNode root) {
        if (root == null)
            return true;
                    
        return check(root) == -1 ? false : true;
    }
    
    private int check(TreeNode cNode) {
        if (cNode == null)
            return 0;
        
        int left = check(cNode.left);
        int right = check(cNode.right);
        
        if (left == -1 || right == -1)
            return -1;
        else if (Math.abs(left - right) > 1)
            return -1;
        else
            return Math.max(left, right) + 1;
    }
}
