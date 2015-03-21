package Accepted;

import java.util.Stack;

import org.junit.Test;

public class MaxRectangular {

	public int maximalRectangle(char[][] matrix) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0)
            return 0;
        int[][] verticalHeight = new int[matrix.length][matrix[0].length];
        for (int j = 0; j < matrix[0].length; ++j) {
            for (int i = 0; i < matrix.length; ++i) {
                if (matrix[i][j] == '0')
                    verticalHeight[i][j] = 0;
                else {
                    if (i == 0)
                        verticalHeight[i][j] = 1;
                    else
                        verticalHeight[i][j] = verticalHeight[i - 1][j] + 1;
                }
            }
        }
        int result = 0;
        for (int i = 0; i < matrix.length; ++i)
            result = Math.max(result, maximalRectangle(verticalHeight[i]));
        return result;
    }
    
    private int maximalRectangle(int[] array) {
        int result = 0;
        int[] ar = new int[array.length + 1];
        System.arraycopy(array, 0, ar, 0, array.length);
        ar[ar.length - 1] = 0;
        Stack<Integer> height = new Stack<Integer>();
        Stack<Integer> pos = new Stack<Integer>();
        for (int i = 0; i < ar.length; ++i) {
            int currHeight = ar[i];
            if (height.size() == 0) {
                if (currHeight > 0) {
                    height.push(currHeight);
                    pos.push(i);
                }
            }
            else {
                if (currHeight > height.peek()) {
                    height.push(currHeight);
                    pos.push(i);
                }
                else if (currHeight < height.peek()) {
                	int tmpPos = 0;
                    while (height.size() > 0) {
                        if (currHeight < height.peek()) {
                            int tmpHeight = height.pop();
                            tmpPos = pos.pop();
                            result = Math.max(result, tmpHeight * (i - tmpPos));
                        }
                        else
                        	break;
                    }
                    if (currHeight != 0) {
                        height.push(currHeight);
                        pos.push(tmpPos);
                    }
                }
            }
        }
        return result;
    }
    
    @Test
    public void test01() {
    	char[][] matrix = {{'1', '0', '1', '0'}, {'1', '0', '1', '1'}, {'1', '0', '1', '1'}, {'1', '1', '1', '1'}};
    	System.out.println(new MaxRectangular().maximalRectangle(matrix));
    }
}
