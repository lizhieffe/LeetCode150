package Accepted;

public class SortColor {
	public void sortColors(int[] A) {
        
        if (A.length == 0)
            return;
            
        int pRed = 0;
        int pWhite = 0;

        for (int i = 0; i < A.length; i ++) {
            if (A[i] == 0) {
                A[i] = 2;
                A[pWhite++] = 1;
                A[pRed++] = 0;
            } else if (A[i] == 1) {
                A[i] = 2;
                A[pWhite++] = 1;
            }
        }
    }
}
