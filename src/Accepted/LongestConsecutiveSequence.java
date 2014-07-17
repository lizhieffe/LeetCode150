package Accepted;

import java.util.HashSet;

public class LongestConsecutiveSequence {

	public int longestConsecutive(int[] num) {
        int length = num.length;
        
		if (length <= 1)
			return length;
		
		HashSet<Integer> all = new HashSet<Integer>();
		for (int i = 0; i < length; i ++)
			all.add(num[i]);
		
		int result = 0;
		for (int i = 0; i < length; i ++) {
			if (all.contains(new Integer(num[i]))) {
				int tmpResult = 1;
				
				int j = 1;
				while (all.contains(new Integer(num[i] - j))) {
					all.remove(new Integer(num[i] - j));
					tmpResult ++;
					j ++;
				}
				
				j = 1;
				while (all.contains(new Integer(num[i] + j))) {
					all.remove(new Integer(num[i] + j));
					tmpResult ++;
					j ++;
				}
				
				all.remove(new Integer(num[i]));
				result = Math.max(result, tmpResult);
			}
		}
		
		return result;
    }
}
