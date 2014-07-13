package Accepted;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import Utils.TreeNode;

public class BinaryTreePreorderTraversalIteratively {

	List<Integer> result;
    
    public List<Integer> preorderTraversal(TreeNode root) {
        result = new ArrayList<Integer>();
        
        if (root == null)
            return result;
            
        LinkedList<TreeNode> record = new LinkedList<TreeNode>();
        record.add(root);
        
        while (record.size() > 0) {
            TreeNode tmp = record.removeLast();
            result.add(tmp.val);
            if (tmp.right != null)
                record.add(tmp.right);
            if (tmp.left != null)
                record.add(tmp.left);
        }
        
        return result;
    }
}
