package Accepted;

public class MergeSortedList {

	public void merge(int A[], int m, int B[], int n) {
        
        int p1 = m - 1;
        int p2 = n - 1;
        
        while (p1 + p2 > -2) {
            if (p1 < 0) {
                A[p2] = B[p2];
                p2 --;
            }
            else if (p2 < 0)
                break;
            else {
                if (A[p1] < B[p2]) {
                    A[p1 + p2 + 1] = B[p2];
                    p2 --;
                } else {
                    A[p1 + p2 + 1] = A[p1];
                    p1 --;
                }
            }
        }
    }
}
