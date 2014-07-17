package Accepted;

/*
 * Very good one
 * http://www.cnblogs.com/lichen782/p/leetcode_Median_of_Two_Sorted_Arrays.html
 */

public class MedianOfTwoSortedArrays {

	public double findMedianSortedArrays(int A[], int B[]) {
        int lengthA = A.length;
        int lengthB = B.length;
        
        if (lengthA == 0 && lengthB == 0)
        	return -1;
        
        if (lengthA == 0)
        	return lengthB % 2 == 0 ? ((double)(B[lengthB / 2 - 1] + B[lengthB / 2])) / 2 : B[lengthB / 2];
        
        if (lengthB == 0)
        	return lengthA % 2 == 0 ? ((double)(A[lengthA / 2 - 1] + A[lengthA / 2])) / 2 : A[lengthA / 2];
        	
        int left = (lengthA + lengthB - 1) / 2;
        
        int startA = 0;
        int startB = 0;
        
        while (left >= 0) {
        	if (startA >= lengthA)
            	return (lengthA + lengthB) % 2 == 0 ? ((double)(B[startB + left] + B[startB + left + 1])) / 2 : B[startB + left];
            if (startB >= lengthB)
               	return (lengthA + lengthB) % 2 == 0 ? ((double)(A[startA + left] + A[startA + left + 1])) / 2 : A[startA + left];
            
            int k;
            k = Math.min(left, Math.min(lengthA - startA, lengthB - startB));
            
            if (k == 0) {
            	if ((lengthA + lengthB) % 2 == 1)
            		return Math.min(A[startA], B[startB]);
            	else {
            		int min = Math.min(A[startA], B[startB]);
            		int second = Math.max(A[startA], B[startB]);
            		if (startA + 1 < lengthA)
            			second = Math.min(second, A[startA + 1]);
            		if (startB + 1 < lengthB)
            			second = Math.min(second, B[startB + 1]);
            		return ((double)(min + second)) / 2;
            	}	
            }
            
            if (k == 1) {
            	if (A[startA] > B[startB]) {
                	startB = startB + 1;
                	left = left - 1;
                }
            	else {
            		startA = startA + 1;
                	left = left - 1;
            	}	
            }
            else if (A[startA + k / 2] > B[startB + k / 2]) {
            	startB = startB + k / 2;
            	left = left - k / 2;
            }
            else if (A[startA + k / 2] < B[startB + k / 2]) {
            	startA = startA + k / 2;
            	left = left - k / 2;
            }
            else {
            	startA = startA + k / 2;
            	startB = startB + k / 2;
            	left = left - (k / 2) * 2;
            }
        }
        
        return -1;
    }
	
	public static void main(String[] args) {
		int[] B = {1};
		int[] A = {2, 3, 4, 5};
		MedianOfTwoSortedArrays service = new MedianOfTwoSortedArrays();
		double result = service.findMedianSortedArrays(A, B);
		System.out.println(result);
	}
}
