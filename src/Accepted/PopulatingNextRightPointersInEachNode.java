package Accepted;

import Utils.TreeLinkNode;

public class PopulatingNextRightPointersInEachNode {

	public void connect(TreeLinkNode root) {
        if (root == null)
            return;
        
        root.next = null;
        connectThis(root);
    }
    
    private void connectThis(TreeLinkNode cNode) {
        if (cNode == null)
            return;
            
        if (cNode.left == null)
            return;
            
        cNode.left.next = cNode.right;
        cNode.right.next = cNode.next != null ? cNode.next.left : null;
        
        connectThis(cNode.left);
        connectThis(cNode.right);
    }
}
