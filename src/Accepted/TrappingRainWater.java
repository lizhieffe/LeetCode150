package Accepted;

public class TrappingRainWater {

public int trap(int[] A) {
        
        int length = A.length;
        
        if (length <= 2)
            return 0;
        
        int[] leftMax = new int[length];
        int[] rightMax = new int[length];

        int totalWater = 0;
        
        leftMax[0] = 0;
        for (int i = 1; i < length; i ++)
            leftMax[i] = Math.max(leftMax[i - 1], A[i - 1]);
            
        rightMax[length - 1] = 0;
        for (int i = length - 2; i >= 0; i --) {
            rightMax[i] = Math.max(rightMax[i + 1], A[i + 1]);
            int boundary = Math.min(leftMax[i], rightMax[i]);
            if (boundary > A[i])
                totalWater = totalWater + boundary - A[i];
        }
        
        return totalWater;
    }
}
