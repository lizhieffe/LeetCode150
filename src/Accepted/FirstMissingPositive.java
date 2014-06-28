package Accepted;

public class FirstMissingPositive {

	public int firstMissingPositive(int[] A) {
        int length = A.length;
        
        if (length == 0)
            return 1;
            
        int index = 0;
        while (index < length) {
            int last = Integer.MIN_VALUE;
            
            while (A[index] != index + 1 && A[index] != last) {
                if (A[index] <= 0)
                    break;
                else if (A[index] > length)
                    break;
                else {
                    int tmp = A[index];
                    A[index] = A[A[index] - 1];
                    A[tmp - 1] = tmp;
                    last = tmp;
                }
            }
            index ++;
        }
        
        for (int i = 0; i < length; i ++) {
            if (A[i] != i + 1)
                return i + 1;
        }
        return length + 1;
    }
	
	public static void main(String[] args) {
		int[] a = {0, 1, 2};
		FirstMissingPositive service = new FirstMissingPositive();
		System.out.println(service.firstMissingPositive(a));
	}
}
