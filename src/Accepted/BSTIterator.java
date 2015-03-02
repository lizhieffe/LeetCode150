package Accepted;

import java.util.Stack;

import Utils.TreeNode;

public class BSTIterator {

	Stack<TreeNode> stack = new Stack<TreeNode>();
    
    public BSTIterator(TreeNode root) {
        if (root != null)
            getAllLeftNodes(root);
    }

    /** @return whether we have a next smallest number */
    public boolean hasNext() {
        return stack.size() != 0;
    }

    /** @return the next smallest number */
    public int next() {
        TreeNode node = stack.pop();
        getAllLeftNodes(node.right);
        return node.val;
    }
    
    private void getAllLeftNodes(TreeNode node) {
        while (node != null) {
            stack.push(node);
            node = node.left;
        }
    }
}
