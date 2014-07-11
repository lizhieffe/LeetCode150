package Accepted;

import java.util.Arrays;

public class TwoSum {

	public int[] twoSum(int[] numbers, int target) {
        int[] result = {-1, -1};
        
        int length = numbers.length;
        if (length == 0)
            return result;
            
        int[] tmp = new int[length];
        System.arraycopy(numbers, 0, tmp, 0, length);
        Arrays.sort(tmp);
        int i = 0; 
        int j = length - 1;
        
        while (i < j) {
            if (tmp[i] + tmp[j] == target) {
                result[0] = i;
                result[1] = j;
                break;
            }
            else if (tmp[i] + tmp[j] < target) {
                i ++;
            }
            else
                j --;
        }
        
        if (result[0] != -1) {
            boolean firstFound = false;
            boolean secondFound = false;
            for (i = 0; i < length; i ++) {
                if (numbers[i] == tmp[result[0]] && firstFound == false) {
                    result[0] = i + 1;
                    firstFound = true;
                }
                else if (numbers[i] == tmp[result[1]] && secondFound == false) {
                    result[1] = i + 1;
                    secondFound = true;
                }
                
                if (firstFound == true && secondFound == true)
                    break;
            }
            
            if (result[0] > result[1]) {
                int tmp1 = result[0];
                result[0] = result[1];
                result[1] = tmp1;
            }
        }
        
        return result;
        
    }
	
	public static void main(String[] args) {
		int[] numbers = {3, 2, 4};
		int target = 6;
		int[] result = new TwoSum().twoSum(numbers, target);
		
		System.out.println(result[0]);
		System.out.println(result[1]);

	}
}
