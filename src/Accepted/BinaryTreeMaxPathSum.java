package Accepted;

import Utils.TreeNode;

public class BinaryTreeMaxPathSum {

private int max;
    
    public int maxPathSum(TreeNode root) {
        if (root == null)
            return 0;
        
        max = Integer.MIN_VALUE;
        getMax(root);
        
        return max;
    }
    
    private int getMax(TreeNode node) {
        int tmpMax = node.val;
        int lMax = 0;
        int rMax = 0;
        
        if (node.left != null) {
            lMax = getMax(node.left);
            tmpMax = Math.max(tmpMax, node.val + lMax);
        }
        
        if (node.right != null) {
            rMax = getMax(node.right);
            tmpMax = Math.max(tmpMax, node.val + rMax);
        }
        
        max = Math.max(max, Math.max(tmpMax, node.val + lMax + rMax));
    
        return tmpMax;
    }
}
