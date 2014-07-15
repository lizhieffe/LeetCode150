package Accepted;

import java.util.ArrayList;
import java.util.List;

import Utils.TreeNode;

public class UniqueBinarySearchTreeII {

	List<TreeNode> result;
    public List<TreeNode> generateTrees(int n) {
    	
    	result = new ArrayList<TreeNode>();
    	
        if (n <= 0) {
        	List<TreeNode> tmpResult = new ArrayList<TreeNode>();
        	tmpResult.add(null);
        	return tmpResult;
        }
        if (n == 1) {
        	List<TreeNode> tmpResult = new ArrayList<TreeNode>();
        	tmpResult.add(new TreeNode(1));
        	return tmpResult;
        }
            
        List<Integer> candidates = new ArrayList<Integer>();
        for (int i = 0; i < n; i ++) 
            candidates.add(i + 1);
        
        List<TreeNode> result = new ArrayList<TreeNode>();
        
        for (int i = 0; i < n; i ++) {
            List<Integer> tmpCandidates = new ArrayList<Integer>(candidates);
            tmpCandidates.remove(new Integer(i + 1));
            result.addAll(generate(i + 1, tmpCandidates));
        }
        
        return result;
    }
    
    private List<TreeNode> generate(int val, List<Integer> candidates) {
    	List<TreeNode> tmpResult = new ArrayList<TreeNode>();
    	
        if (candidates.size() == 0) {
        	tmpResult.add(new TreeNode(val));
        	return tmpResult;
        }
        
        List<Integer> leftCandidates = new ArrayList<Integer>();;
        List<Integer> rightCandidates = new ArrayList<Integer>();;
        
        for (Integer integer : candidates) {
        	if (integer < val)
        		leftCandidates.add(integer);
        	else
        		rightCandidates.add(integer);
        }
        
        List<TreeNode> leftChildren = new ArrayList<TreeNode>();
        List<TreeNode> rightChildren = new ArrayList<TreeNode>();
        
        for (Integer integer : leftCandidates) {
        	List<Integer> tmpCandidates = new ArrayList<Integer>(leftCandidates);
        	tmpCandidates.remove(integer);
        	leftChildren.addAll(generate(integer, tmpCandidates));
        }

        for (Integer integer : rightCandidates) {
        	List<Integer> tmpCandidates = new ArrayList<Integer>(rightCandidates);
        	tmpCandidates.remove(integer);
        	rightChildren.addAll(generate(integer, tmpCandidates));
        }
        
        if (leftChildren.size() == 0) {
        	for (TreeNode rightChild : rightChildren) {
        		TreeNode tmpNode = new TreeNode(val);
        		tmpNode.left = null;
        		tmpNode.right = rightChild;
        		tmpResult.add(tmpNode);
        	}
        } else if (rightChildren.size() == 0) {
        	for (TreeNode leftChild : leftChildren) {
        		TreeNode tmpNode = new TreeNode(val);
        		tmpNode.left = leftChild;
        		tmpNode.right = null;
        		tmpResult.add(tmpNode);
        	}
        } else {
	        for (TreeNode leftChild : leftChildren) {
	        	for (TreeNode rightChild : rightChildren) {
	        		TreeNode tmpNode = new TreeNode(val);
	        		tmpNode.left = leftChild;
	        		tmpNode.right = rightChild;
	        		tmpResult.add(tmpNode);
	        	}
	        }
        }
        
        return tmpResult;
    }
    
    public static void main(String[] args) {
    	int n = 3;
    	UniqueBinarySearchTreeII service = new UniqueBinarySearchTreeII();
    	List<TreeNode> results = service.generateTrees(n);
    	
    	System.out.println(results);
    }
}
