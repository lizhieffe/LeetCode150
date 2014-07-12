package Accepted;

import Utils.TreeNode;

public class FlattenBinaryTreeToLinkedList {
	TreeNode last;
    
    public void flatten(TreeNode root) {
        if (root == null)
            return;
            
        last = root;
        TreeNode tmpLeft = root.left;
        TreeNode tmpRight = root.right;
        attach(tmpLeft);
        attach(tmpRight);
    }
    
    private void attach(TreeNode cNode) {
        if (cNode == null)
            return;
        
        last.right = cNode;
        last.left = null;
        last = cNode;
        
        TreeNode tmpLeft = cNode.left;
        TreeNode tmpRight = cNode.right;
        
        if (tmpLeft != null)
            attach(tmpLeft);
            
        if (tmpRight != null)
            attach(tmpRight);
    }
}
