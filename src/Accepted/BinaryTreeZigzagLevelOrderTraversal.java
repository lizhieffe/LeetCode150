package Accepted;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import Utils.TreeNode;

public class BinaryTreeZigzagLevelOrderTraversal {

	List<List<Integer>> result;
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        result = new ArrayList<List<Integer>>();
        
        if (root == null)
            return result;
        
        List<TreeNode> stack = new LinkedList<TreeNode>();
        LinkedList<TreeNode> tmpStack = new LinkedList<TreeNode>();
        
        stack.add(root);
        boolean directionIsRight = true;
        
        while ((stack.size() == 0 && tmpStack.size() == 0) == false) {
            if (stack.size() != 0) {
                ArrayList<Integer> solution = new ArrayList<Integer>();
                for (TreeNode node : stack) {
                    solution.add(node.val);
                    
                    if (directionIsRight == true) {
                        if (node.left != null)
                            tmpStack.add(node.left);
                        if (node.right != null)
                            tmpStack.add(node.right);
                    }
                    else {
                        if (node.right != null)
                            tmpStack.add(node.right);
                        if (node.left != null)
                            tmpStack.add(node.left);
                    }
                }
                result.add(solution);
                stack.clear();
                directionIsRight = directionIsRight ? false : true;

            }
            else {
                while (tmpStack.size() != 0) {
                    stack.add(tmpStack.removeLast());
                }
                        
            }
        }
        
        return result;
    }
}
