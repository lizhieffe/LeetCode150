package Accepted;

public class RemoveDuplicatesFromSortedArrayII {

	public int removeDuplicates(int[] A) {
        int length = A.length;
        if (length == 0)
            return 0;
            
        int m = 1;
        boolean alreadyTwice = false;
        int last = A[0];
        
        for (int n = 1; n < length; n ++) {
            if (A[n] == last) {
                if (alreadyTwice == false) {
                    alreadyTwice = true;
                    A[m] = A[n];
                    m ++;
                }
            }
            else {
                alreadyTwice = false;
                A[m] = A[n];
                last = A[n];
                m ++;
            }
        }
        
        return m;
    }
	
	public static void main(String[] args) {
		int[] A = {1, 2, 3 , 4, 4, 5, 5, 5};
		RemoveDuplicatesFromSortedArrayII service = new RemoveDuplicatesFromSortedArrayII();
		System.out.println(service.removeDuplicates(A));
		System.out.println();
	
	}
}
