package Accepted;

public class SearchInRotatedSortedArray {

	int[] A;
    int length;
    
    public int search(int[] A, int target) {
        
        length = A.length;
        if (length == 0)
            return -1;
        
        this.A = A;
        return search(0, length, target);
    }
    
    private int search(int start, int end, int target) {
        if (start == end - 1)
            return A[start] == target ? start : -1;
        
        if (start == end - 2) {
            if (A[start] == target)
                return start;
            else if (A[end - 1] == target)
                return end - 1;
            else
                return -1;
        }
        
        int mid = (end - start) / 2 + start;
        if (A[mid] == target)
            return mid;
        if (A[start] == target)
            return start;
        if (A[end - 1] == target)
            return end - 1;
            
        boolean rotated = A[end - 1] < A[start];
        
        if (rotated == false) {
            if (A[mid] < target)
                return search(mid + 1, end, target);
            else
                return search(start, mid, target);
        }
        else {
            if (A[mid] < A[end - 1]) {
                if (A[mid] < target && target < A[end - 1])
                    return search(mid + 1, end, target);
                else
                    return search(start, mid, target);
            }
            else {
                if (A[start] < target && target < A[mid])
                    return search(start, mid, target);
                else
                    return search(mid + 1, end, target);
            }
        }
    }
    
    public static void main(String[] args) {
    	int[] A = {1, 3, 5};
    	int target = 5;
    	
    	System.out.println( (new SearchInRotatedSortedArray().search(A, target)));
    }
}
