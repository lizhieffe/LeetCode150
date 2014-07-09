package Accepted;

public class RotateImage {

	public void rotate(int[][] matrix) {
        int n = matrix.length;
        if (n <= 1)
        	return;
        
        for (int i = 0; i < n / 2; i ++) {
        	for (int j = i; j < n - i - 1; j ++) {
        		int a1, a2, a3, a4;
        		a1 = matrix[i][j];
        		a2 = matrix[j][n - i - 1];
        		a3 = matrix[n - i - 1][n - j - 1];
        		a4 = matrix[n - j - 1][i];
        		
        		matrix[i][j] = a4;
        		matrix[j][n - i - 1] = a1;
        		matrix[n - i - 1][n - j - 1] = a2;
        		matrix[n - j - 1][i] = a3;
        	}
        }
    }

}
