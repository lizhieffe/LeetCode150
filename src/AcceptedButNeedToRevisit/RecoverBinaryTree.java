package AcceptedButNeedToRevisit;

import Utils.TreeNode;

public class RecoverBinaryTree {
	TreeNode prev = null;
    TreeNode first = null;
    TreeNode second = null;

    public void recoverTree(TreeNode root) {
    	inorderTransverse(root);
    	recover();
    	System.out.println(root.val);
    }

    private void inorderTransverse(TreeNode cNode) {
    	if (cNode == null)
    		return;
    	if (prev == null && cNode.left == null) {
    		prev = cNode;
    	}
    	inorderTransverse(cNode.left);
    	if (prev != null && cNode.val < prev.val) {
    		if (first == null) {
    			first = prev;
    			second = cNode;
    		}
    		else {
    			second = cNode;
    			return;
    		}
    	}
    	prev = cNode;
    	inorderTransverse(cNode.right);

    }

    private void recover() {
    	if (first == null || second == null)
    		return;
    	int tmp = first.val;
    	first.val = second.val;
    	second.val = tmp;
    }
    
    public static void main(String[] args) {
    	TreeNode root = new TreeNode(3);
    	root.left = new TreeNode(1);
    	root.right = new TreeNode(2);
    	new RecoverBinaryTree().recoverTree(root);
    }
}
