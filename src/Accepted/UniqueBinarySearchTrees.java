package Accepted;


public class UniqueBinarySearchTrees {

	private Integer[] dp;
	public int numTrees(int n) {
	        
		if (n <= 2)
			return n;
		dp = new Integer[n];
		return findNumTrees(n);
	   	}
	public int findNumTrees(int n) {
		if (n <= 2)
			return n;
		if (dp[n - 1] != null)
			return dp[n - 1];
		int result = 0;
		for (int i = 0; i < n; i ++) {
			if (i == 0 || i == n - 1)
				result = result + findNumTrees(n - 1);
			else
				result = result + findNumTrees(n - i - 1) * findNumTrees(i);
		}
		dp[n - 1] = result;
			return result;
		}
	
	public static void main(String[] args) {
		UniqueBinarySearchTrees service = new UniqueBinarySearchTrees();
		System.out.println(service.numTrees(3));
	}
}
