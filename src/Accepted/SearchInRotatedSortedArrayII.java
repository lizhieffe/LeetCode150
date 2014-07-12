package Accepted;

public class SearchInRotatedSortedArrayII {
	int length;
    int[] A;
    
    public boolean search(int[] A, int target) {
        length = A.length;
        if (length == 0)
            return false;
        
        this.A = A;
        return search(0, length, target);
    }
    
    private boolean search(int start, int end, int target) {
        if (start >= end)
            return false;
        
        if (start + 1 == end)
            return A[start] == target;
        
        int mid = (end - start) / 2 + start;
        if (A[start] == target || A[end - 1] == target || A[mid] == target)
            return true;
            
        if (A[start] > A[mid]) {
            if (A[mid] < target && A[end - 1] > target)
                return search(mid, end, target);
            else
                return search(start, mid, target);
        }
        else if (A[start] < A[mid]) {
            if (A[start] < target && A[mid] > target)
                return search(start, mid, target);
            else
                return search(mid, end, target);
        }
        else {
            return search(start, mid, target) || search(mid, end, target);
        }
        
    }
}
