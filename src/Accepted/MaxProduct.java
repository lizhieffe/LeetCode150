package Accepted;

public class MaxProduct {
	public int maxProduct(int[] A) {
      	return find (A, 0, A.length);
    }
    
    private int find (int[] A, int beg, int end) {
		if (A == null || beg < 0 || beg >= A.length || end <=0 || end > A.length || beg >= end)
			return 0;

		if (beg == end - 1)
			return A[beg];
			
		int product = A[beg];
		for (int i = beg + 1; i < end; i ++)
			product *= A[i];

		if (product > 0)
			return product;

		if (product == 0) {
			int tmp = indexOfZero(A, beg);
			int tmp1 = Math.max(find(A, beg, tmp), find(A, tmp + 1, end));
			return tmp1 > 0 ? tmp1 : 0;
		}

		int left = indexOfNegativeFromLeft(A, beg);
		int right = indexOfNegativeFromRight(A, end);
		int tmp1 = Math.max(find(A, beg, left), find(A, left + 1, end));
		int tmp2 = Math.max(find(A, beg, right), find(A, right + 1, end));
		return Math.max(tmp1, tmp2);
	}

	private int indexOfZero(int[] A, int beg) {
		for (int i = beg; i < A.length; i ++)
			if (A[i] == 0)
				return i;

		return -1;
	}

	private int indexOfNegativeFromLeft(int[] A, int beg) {
		for (int i = beg; i < A.length; i ++)
			if (A[i] < 0)
				return i;

		return -1;
	}

	private int indexOfNegativeFromRight(int[] A, int end) {
		for (int i = end - 1; i >= 0; i --)
			if (A[i] < 0)
				return i;

		return -1;
	}
	
	public static void main(String[] args) {
		int[] A = {-3, 0, 1, -2};
		System.out.println(new MaxProduct().maxProduct(A));
	}
}
