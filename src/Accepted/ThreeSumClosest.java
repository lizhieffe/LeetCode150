package Accepted;

import java.util.Arrays;

public class ThreeSumClosest {
	public int threeSumClosest(int[] num, int target) {
        if (num.length <= 2)
        	return Integer.MIN_VALUE;
        
        Arrays.sort(num);
        
        int minDiff = Integer.MAX_VALUE;
        for (int i = 0; i < num.length - 2; i ++) {
        	int lastDiff = Integer.MAX_VALUE;
        	
        	int j = i + 1;
        	int k = num.length - 1;
        	
        	int diff;
        	
        	while (j < k) {
        		diff = num[i] + num[j] + num[k] - target;
        		
        		if (diff == 0)
        			return target;
        		
        		if (Math.abs(diff) > Math.abs(lastDiff))
        			break;
        		
        		if (diff > 0)
        			k --;
        		else
        			j ++;
        		
        		lastDiff = diff;
        	}
        	
        	if (Math.abs(minDiff) > Math.abs(lastDiff))
        		minDiff = lastDiff;
        	
        }
        
        return minDiff + target;
    }
	
	public static void main(String[] args) {
		int[] num = {0, 1, 2};
		int target = 0;
		
		ThreeSumClosest service = new ThreeSumClosest();
		int result = service.threeSumClosest(num, target);
		
		System.out.println(result);
		
	}
}
