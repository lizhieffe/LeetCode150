package Accepted;



import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import Utils.TreeNode;

public class BinaryTreeLevelOrderTraversal {
	public List<List<Integer>> levelOrder(TreeNode root) {
        ArrayList<List<Integer>> result = new ArrayList<List<Integer>>();
        
        if (root == null)
        return result;
        
    LinkedList<TreeNode> list = new LinkedList<TreeNode>();
        list.add(root);
        
        while (list.size() > 0) {
        LinkedList<TreeNode> tmp = new LinkedList<TreeNode>();
        ArrayList<Integer> cLevel = new ArrayList<Integer>();
       
        while (list.size() > 0) {
           TreeNode node = list.get(0);
           
        if (node.left != null)
        tmp.add(node.left);
        if (node.right != null)
        tmp.add(node.right);
       
        cLevel.add(node.val);
        list.remove(node);
        }
       
        if (cLevel.size() > 0)
        result.add(cLevel);
        if (tmp.size() > 0)
        list.addAll(tmp);
        }
        
        return result;
    }

}