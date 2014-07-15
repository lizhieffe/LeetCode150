package Accepted;

public class ContainerWithMostWater {

	public int maxArea(int[] height) {
        if (height.length <= 1)
            return 0;
            
        int i = 0;
        int j = height.length - 1;
        
        int max = 0;
        while (i < j) {
            if (height[i] < height[j]) {
                max = Math.max(max, (j - i) * height[i]);
                i ++;
            }
            else if (height[i] > height[j]) {
                max = Math.max(max, (j - i) * height[j]);
                j --;
            }
            else {
                max = Math.max(max, (j - i) * height[i]);
                i ++;
                j --;
            }
        }
        
        return max;
    }
}
