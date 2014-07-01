package Accepted;

/*
 * note that neighbors can have different # of candies: https://oj.leetcode.com/discuss/4768/neighbers-can-have-equal-rating-or-not
 */
public class Candy {

	public int candy(int[] ratings) {
        
		int length = ratings.length;
		if (length < 2)
			return length;
		
		Integer[] keepIncreasing = new Integer[length];
		Integer[] keepDecreasing = new Integer[length];

		keepIncreasing[0] = 0;
		for (int i = 1; i < length; i ++) {
			if (ratings[i] <= ratings[i - 1])
				keepIncreasing[i] = 0;
			else
				keepIncreasing[i] = keepIncreasing[i - 1] + 1;
		}
		
		keepDecreasing[length - 1] = 0;
		for (int i = length -2; i >= 0; i --) {
			if (ratings[i] <= ratings[i + 1])
				keepDecreasing[i] = 0;
			else
				keepDecreasing[i] = keepDecreasing[i + 1] + 1;
		}
		
		int result = 0;
		
		for (int i = 0; i < length; i ++)
			result = result + 1 + Math.max(keepIncreasing[i], keepDecreasing[i]);
		
		return result;
    }
}
