package Accepted;

import Utils.TreeNode;

public class ConvertSortedArrayToBinarySearchTree {
	
	int[] num;
	int length;
	
	public TreeNode sortedArrayToBST(int[] num) {
		length = num.length;
		
		if (length == 0)
			return null;
		
		this.num = num;
		int mid = length / 2;
		
		TreeNode root = new TreeNode(num[mid]);
		add(root, 0, mid);
		add(root, mid + 1, length);
		
		return root;
    }
	
	private void add(TreeNode root, int start, int end) {
		if (start == end || start >= length)
			return;
		
		int mid = (end - start) / 2 + start;
		intert(root, num[mid]);
		
		add(root, start, mid);
		add(root, mid + 1, end);
		
	}
	
	private void intert(TreeNode root, int val) {
		TreeNode cNode = root;
		
		while (cNode != null) {
			if (val < cNode.val) {
				if (cNode.left == null) {
					cNode.left = new TreeNode(val);
					break;
				}
				else
					cNode = cNode.left;
			}
			else if (val >= cNode.val) {
				if (cNode.right == null) {
					cNode.right = new TreeNode(val);
					break;
				}
				else
					cNode = cNode.right;
			}
		}
	}
	
	public static void main(String[] args) {
		int[] num = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11};
		TreeNode root = new ConvertSortedArrayToBinarySearchTree().sortedArrayToBST(num);
		System.out.println(root);
	}
}
