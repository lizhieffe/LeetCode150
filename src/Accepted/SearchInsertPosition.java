package Accepted;


public class SearchInsertPosition {
	public int searchInsert(int[] A, int target) {
        int length = A.length;
        
        if (length == 0)
        return 0;
        
        int i;
        for (i = 0; i < length; i ++) {
        if (A[i] >= target)
        return i;
        }
        
        return i;
    }
}
