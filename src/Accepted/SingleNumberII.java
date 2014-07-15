package Accepted;

public class SingleNumberII {

	public int singleNumber(int[] A) {
        int[] result = new int[32];
        for (int i = 0; i < result.length; i ++)
            result[i] = 0;
        
        for (int i = 0; i < A.length; i ++) {
            char[] chars = Integer.toBinaryString(A[i]).toCharArray();
            for (int j = 0; j < chars.length; j ++) {
                result[result.length - chars.length + j] 
                        = result[result.length - chars.length + j] + (chars[j] - '0');
                result[result.length - chars.length + j] = result[result.length - chars.length + j] % 3;
            }
        }
        
        double resultInt = 0;
        for (int i = 1; i < result.length; i ++)
            resultInt = resultInt + result[i] * Math.pow(2, result.length - i - 1);
        return result[0] == 1 ? (int)resultInt - Integer.MAX_VALUE - 1 : (int)resultInt;
    }
	
	public static void main(String[] args) {
		int[] A = {1,1,1,4, 4,-3,4,3,3,3};
		SingleNumberII service = new SingleNumberII();
		int result = service.singleNumber(A);
		System.out.println(result);
	}
}
