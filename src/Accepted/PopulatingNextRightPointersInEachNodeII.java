package Accepted;

import Utils.TreeLinkNode;

public class PopulatingNextRightPointersInEachNodeII {
	public void connect(TreeLinkNode root) {
        if (root == null)
            return;
            
        root.next = null;
        
        connectNext(root);
    }
    
    private void connectNext(TreeLinkNode cNode) {
        if (cNode == null)
            return;
            
        if (cNode.left != null)
            if (cNode.right != null)
                cNode.left.next = cNode.right;
            else
                cNode.left.next = findNextChild(cNode.next);
                
        if (cNode.right != null)
            cNode.right.next = findNextChild(cNode.next);
            
        connectNext(cNode.right);
        connectNext(cNode.left);
    }
    
    private TreeLinkNode findNextChild(TreeLinkNode cNode) {
        if (cNode == null)
            return null;
            
        if (cNode.left != null)
            return cNode.left;
        
        if (cNode.right != null)
            return cNode.right;
        
        return findNextChild(cNode.next);
    }
    
    public static void main(String[] args) {
    	TreeLinkNode root = new TreeLinkNode(1);
    	root.left = new TreeLinkNode(2);
    	root.right = new TreeLinkNode(3);
    	root.left.left = new TreeLinkNode(4);
    	root.left.right = new TreeLinkNode(5);
    	root.right.right = new TreeLinkNode(7);
    	
    	PopulatingNextRightPointersInEachNodeII service 
    			= new PopulatingNextRightPointersInEachNodeII();
    	service.connect(root);
    	
    	System.out.println();
    }
}
