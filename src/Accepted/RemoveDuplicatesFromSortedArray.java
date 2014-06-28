package Accepted;

import java.util.Arrays;


public class RemoveDuplicatesFromSortedArray {
	public int removeDuplicates(int[] A) {
	        
		int length = A.length;
		if (length <= 1)
			return length;
		int newIndex = 1;
		int lastNum = A[0];
		int result = 1;
		for (int cIndex = 1; cIndex < length; cIndex ++) {
			if (A[cIndex] == lastNum)
					continue;
			else {
				result ++;
				lastNum = A[cIndex];
				if (cIndex != newIndex)
					A[newIndex] = lastNum;
				newIndex++;
			}
		}
		return result;
	}
	
	public static void main(String[] args) {
		int[] A = {1, 2, 3 , 4, 4, 5, 5, 5};
		RemoveDuplicatesFromSortedArray service = new RemoveDuplicatesFromSortedArray();
		System.out.println(service.removeDuplicates(A));
		System.out.println();
	
	}
}
