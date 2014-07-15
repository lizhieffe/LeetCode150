package Accepted;

import java.util.Arrays;

public class NextPermutation {

	public void nextPermutation(int[] num) {
        if (num.length <= 1)
        	return;
        
        int max = Integer.MIN_VALUE;
        int index = -1;
        for (int i = num.length - 1; i >= 0; i --) {
        	if (num[i] < max) {
        		index = i;
        		break;
        	}
        	max = Math.max(max, num[i]);
        }
        
        if (index == -1) {
        	Arrays.sort(num);
        	return;
        }
        
        int index2 = index;
        int min = Integer.MAX_VALUE;
        for (int i = index + 1; i < num.length; i ++) {
        	if (num[i] < min && num[i] > num[index]) {
        		index2 = i;
        		min = num[i];
        	}
        }
        
        int tmp = num[index];
        num[index] = num[index2];
        num[index2] = tmp;
        
        for (int i = index + 1; i < num.length - 1; i ++) {
        	for (int j = i + 1; j < num.length; j ++) {
        		if (num[i] > num[j]) {
        			int tmp1 = num[i];
        	        num[i] = num[j];
        	        num[j] = tmp1;
        		}
        	}
        }
    }
	
	public static void main(String[] args) {
		int[] num = {2, 3, 1};
		
		NextPermutation service = new NextPermutation();
		service.nextPermutation(num);
		
		System.out.println(num);
	}
}
