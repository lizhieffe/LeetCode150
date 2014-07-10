package Accepted;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CombinationSumII {

	List<List<Integer>> result = new ArrayList<List<Integer>>();
	int length;
	int[] num;
	
	public List<List<Integer>> combinationSum2(int[] num, int target) {

		length = num.length;
		
		if (target <= 0 || length == 0)
			return result;
		
		Arrays.sort(num);
		this.num = num;
		
		List<Integer> solution = new ArrayList<Integer>();
		find(0, target, solution);
		
		return result;
    }
	
	private void find(int start, int target, List<Integer> solution) {
		if (start < 0 || start >= length || target <= 0)
			return;
		
		if (num[start] > target)
			return;
		
		List<Integer> tmpSolution = new ArrayList<Integer>(solution);
		if (num[start] == target) {
			tmpSolution.add(target);
			result.add(tmpSolution);
		}
		else if (num[start] < target) {
			tmpSolution.add(num[start]);
			find(start + 1, target - num[start], tmpSolution);
			
			find(findEndOfTheSameValue(start) + 1, target, new ArrayList<Integer>(solution));
		}
	}
	
	private int findEndOfTheSameValue(int start) {
		if (start >= length)
			return -1;
		
		int index = start;
		
		while (index < length) {
			if (num[index] == num[start])
				index ++;
			else
				return index - 1;
		}
		
		return index;
	}
	
	public static void main(String[] args) {
		int[] num = {10,1,2,7,6,1,5};
		int target = 8;
		
		List<List<Integer>> result = new CombinationSumII().combinationSum2(num, target);
		System.out.println(result);
	}
}
