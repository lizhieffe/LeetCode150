package TimeLimitExceeded;

/*
 * Solution:
 * http://www.cnblogs.com/lichen782/p/leetcode_Largest_Rectangle_in_Histogram.html
 */

public class LargestRectInHistogram {

	int[] height;
    int length;
    Integer[][] minHeight;
    
    public int largestRectangleArea(int[] height) {
        this.height = height;
        length = height.length;
        
        if (length < 1)
            return 0;
        
        if (length == 1)
            return height[0];
        
        minHeight = new Integer[length + 1][length + 1];
        
        int largestArea = 0;
        for (int i = 0; i < length; i ++) {
            for (int j = i + 1; j <= length; j++) {
                largestArea = Math.max(largestArea, minHeight(i, j) * (j - i));
            }
        }
        
        return largestArea;
    }
    
    private int minHeight(int start, int end) {
        if (minHeight[start][end] != null)
            return minHeight[start][end];
        
        int result;
        
        if (end - start == 1)
            result = height[start];
        else
            result = Math.min(height[end - 1], minHeight[start][end - 1]);
            
        minHeight[start][end] = result;
        
        return result;
    }
        
    public static void main(String[] args) {
//    	int[] a = {0,1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,17,18,19,20,21,22,23,24,25,26,27,28,29,30,31,32,33,34,35};
    	int[] a = {2, 1, 5, 6, 2, 3};
    	
    	LargestRectInHistogram service = new LargestRectInHistogram();
    	System.out.println(service.largestRectangleArea(a));
    }
}
