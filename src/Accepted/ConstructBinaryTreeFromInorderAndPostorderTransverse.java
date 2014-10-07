package Accepted;

import Utils.TreeNode;

public class ConstructBinaryTreeFromInorderAndPostorderTransverse {

	public TreeNode buildTree(int[] inorder, int[] postorder) {
        if (inorder.length == 0 || inorder.length != postorder.length)
        	return null;

        return getRoot(inorder, 0, inorder.length, postorder, 0, postorder.length);
    }

    private TreeNode getRoot(int[] inorder, int beg1, int end1, int[] postorder, int beg2, int end2) {
    	if (beg1 >= end1)
    		return null;

    	if (beg1 == end1 - 1)
    		return new TreeNode(inorder[beg1]);

    	int rootVal = postorder[end2 - 1];
    	TreeNode root = new TreeNode(rootVal);
    	int index = findValue(inorder, beg1, end1, rootVal);

    	root.left = getRoot(inorder, beg1, index, postorder, beg2, beg2 + (index - beg1));
    	root.right = getRoot(inorder, index + 1, end1, postorder, beg2 + (index - beg1), end2 - 1);
    	
    	return root;
    }

    private int findValue(int[] array, int beg, int end, int val) {
    	for(int i = beg; i < end; i ++)
    		if (array[i] == val)
    			return i;

    	return -1;
    }
}
