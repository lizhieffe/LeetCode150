package Accepted;

public class SingleNumber {

	public int singleNumber(int[] A) {
        if (A.length == 0)
        	return 0;
        
        int result = A[0];
        for (int i = 1; i < A.length; i ++)
        	result = A[i] ^ result;
        
        return result;
    }
}
