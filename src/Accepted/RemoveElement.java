package Accepted;

public class RemoveElement {

	public int removeElement(int[] A, int elem) {
        
		int length = A.length;
		
		if (length == 0)
			return 0;
		
		int end = length - 1;
		
		for (int i = 0; i <= end; i ++) {
			if (A[i] == elem) {
				int tmp = A[end];
				A[end] = A[i];
				A[i] = tmp;
				
				i--;
				end--;
			}
		}
		
		return end + 1;
    }
}
