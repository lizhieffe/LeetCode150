package Accepted;


public class MaxSubarray {
    public int maxSubArray(int[] A) {
        int length = A.length;
        
        if (length == 0)
        return 0;
        
        int max = A[0];
        int tmp = A[0];
        int index = 1;
        
        while (index < length) {
        	if (A[index] <= 0) {
        		max = Math.max(tmp, max);
        		if (tmp <= -A[index])
        			tmp = A[index];
        		else 
        			tmp = tmp + A[index];
        	} else {
        		if (tmp < 0)
        			tmp = A[index];
        		else
        			tmp = tmp + A[index];
        	}
        
        	index ++;
        }
        max = Math.max(tmp, max);
        return max;
    }
    
    public static void main(String[] args) {
    int[] A = {-3, 0, 1, -2};
    
    MaxSubarray service = new MaxSubarray();
    System.out.println(service.maxSubArray(A));
    }
}
