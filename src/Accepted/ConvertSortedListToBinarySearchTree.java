package Accepted;

import Utils.ListNode;
import Utils.TreeNode;

/*
 * really good question
 * http://fisherlei.blogspot.com/2013/01/leetcode-convert-sorted-list-to-binary.html
 */
public class ConvertSortedListToBinarySearchTree {

	ListNode cNode;
	
	public TreeNode sortedListToBST(ListNode head) {
        if (head == null)
        	return null;
        if (head.next == null)
        	return new TreeNode(head.val);
        
        int length = 0;
        cNode = head;
        
        while (cNode != null) {
        	length ++;
        	cNode = cNode.next;
        }
        
        cNode = head;
        return sortedListToBST(length);
    }
	
	private TreeNode sortedListToBST(int size) {
		TreeNode result;
		
		if (size == 0)
			return null;
		
		if (size == 1) {
			result = new TreeNode(cNode.val);
			cNode = cNode.next;
			return result;
		}
		
		if (size == 2) {
			TreeNode left = new TreeNode(cNode.val);
			cNode = cNode.next;
			result = new TreeNode(cNode.val);
			cNode = cNode.next;
			result.left = left;
			return result;
		}
		
		TreeNode left = sortedListToBST(size / 2);
		result = new TreeNode(cNode.val);
		cNode = cNode.next;
		TreeNode right = sortedListToBST(size - size / 2 - 1);
		result.left = left;
		result.right = right;
		
		return result;
	}
}
