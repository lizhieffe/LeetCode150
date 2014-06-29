package Accepted;

import java.util.LinkedList;

import Utils.TreeNode;

public class SameTree {

	public boolean isSameTree(TreeNode p, TreeNode q) {
		if (p == null && q == null)
            return true;
		
        if (p == null || q == null)
            return false;
        
        LinkedList<NodeNColor> list1 = new LinkedList<NodeNColor>();
        list1.add(new NodeNColor(p, 0));
        LinkedList<TreeNode> list2 = new LinkedList<TreeNode>();
        list2.add(q);

        TreeNode cNode1;
        TreeNode cNode2;
        int cColor;
        
        while (list1.size() > 0) {
            cNode1 = list1.getLast().node;
            cColor = list1.getLast().color;
            cNode2 = list2.getLast();
            
            if (cNode2 == null || cNode1.val != cNode2.val)
                return false;
                
            if (cNode1 != null) {
                if (cColor == 0) {
                	list1.getLast().color = 1;
                    if (cNode1.left != null) {
                        list1.add(new NodeNColor(cNode1.left, 0));
                        list2.add(cNode2.left);
                    }
                    else {
                        if (cNode2.left != null)
                            return false;
                    }
                }
                else if (cColor == 1) {
                	list1.getLast().color =2;
                    if (cNode1.right != null) {
                        list1.add(new NodeNColor(cNode1.right, 0));
                        list2.add(cNode2.right);
                    }
                    else {
                        if (cNode2.right != null)
                            return false;
                    }
                }
                else {
                    list1.removeLast();
                    list2.removeLast();
                }
            }
        }
        
        return list2.size() == 0;
    }
    
    class NodeNColor {
        TreeNode node;
        int color;
        
        NodeNColor(TreeNode node, int color) {
            this.node = node;
            this.color = color;
        }
    }
    
    public static void main(String[] args) {
    	TreeNode node1 = new TreeNode(1);
    	TreeNode node2 = new TreeNode(1);

    	SameTree service = new SameTree();
    	System.out.println(service.isSameTree(node1, node2));
    }
}
