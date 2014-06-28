package Accepted;

import java.util.ArrayList;
import java.util.List;

public class SpiralMatrix {

	public List<Integer> spiralOrder(int[][] matrix) {
        ArrayList<Integer> result = new ArrayList<Integer>();
        
        if (matrix.length == 0)
            return result; 
        if (matrix[0].length == 0)
            return result;
            
        int rows = matrix.length;
        int columns = matrix[0].length;
        int topBoundary = 0;
        int bottomBoundary = rows;
        int leftBoundary = 0;
        int rightBoundary = columns;
        
        int count = 0;
        while (bottomBoundary > topBoundary && rightBoundary > leftBoundary) {
            if (count % 4 == 0) {
                for (int i = leftBoundary; i < rightBoundary; i ++)
                    result.add(matrix[topBoundary][i]);
                topBoundary ++;

            } else if (count % 4 == 1) {
                for (int i = topBoundary; i < bottomBoundary; i ++)
                    result.add(matrix[i][rightBoundary - 1]);
                rightBoundary --;

            } else if (count % 4 == 2) {
                for (int i = rightBoundary - 1; i >= leftBoundary; i --)
                    result.add(matrix[bottomBoundary - 1][i]);
                bottomBoundary --;

            } else {
                for (int i = bottomBoundary - 1; i >= topBoundary; i --)
                    result.add(matrix[i][leftBoundary]);
                leftBoundary ++;
            }
            count ++;
        }
        
        return result;
    }
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
