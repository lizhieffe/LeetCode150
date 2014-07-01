package Accepted;

import Utils.TreeNode;

public class SumRootToLeafNumbers {
	
	int sum;
    
    public int sumNumbers(TreeNode root) {
        if (root == null)
            return 0;
        
        String result = "";
        sum = 0;
        
        sum(root, result);
        return sum;
    }
    
    private void sum(TreeNode node, String inputString) {

        String tmp = inputString + node.val;
        
        if (node.left != null)
            sum(node.left, tmp);
        
        if (node.right != null)
           sum(node.right, tmp);
            
        if (node.left == null && node.right == null)
            sum = sum + Integer.parseInt(tmp);
    }
    
    public static void main(String[] args) {
    	TreeNode root = new TreeNode(1);
    	root.left = new TreeNode(0);
    	
    	SumRootToLeafNumbers service = new SumRootToLeafNumbers();
    	System.out.println(service.sumNumbers(root));
    }
}
