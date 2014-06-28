package Accepted;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ThreeSum {
	
    public List<List<Integer>> threeSum(int[] num) {
        
        ArrayList<List<Integer>> list = new ArrayList<List<Integer>>();
        int lastA = Integer.MIN_VALUE;
        int lastB = Integer.MIN_VALUE;
        Arrays.sort(num);
        
        for (int i = 0; i < num.length - 2; i ++) {
        	int a = num[i];
        	if (a == lastA)
        		continue;
        	lastA = a;
        	
            for (int j = i + 1; j < num.length - 1; j ++) {
            	int b = num[j];
                
                if (b > 0 && a + b > 0)
                	break;
                
                if (b == lastB)
                	continue;
                lastB = b;
                
                int indexOfC = Arrays.binarySearch(num, j+1, num.length, - (a+b));
                if (indexOfC >= 0) {
                	Integer[] tmp = {a, b, num[indexOfC]};
                    list.add(new ArrayList<Integer>(Arrays.asList(tmp)));
                    

                }
            }
            
            lastB = Integer.MIN_VALUE;
        }
        
        return list;
    }

	public static void main(String[] args) {
		ThreeSum ts = new ThreeSum();
//		int[] array = {-4,-5,-6,3,11,-13,3,14,1,-10,11,6,8,9,-6,-9,6,3,-15,-8,0,5,6,-8,14,-11,0,2,14,-15,14,-13,-5,-15,5,13,-13,-6,13,-4,-1,1,-13,14,-13,-12,-10,9,6,12,8,14,-5,-8,-9,-6,-4,-2,3,-5,-2,-6,-2,1,-5,-12,-1,-11,-11,-11,0,-4,-2,-5,-5,0,-2,-7,-14,-10,-10,10,-11,-8,-13,-13,1,-2,-7,11,8,6,-9,-9,14,1,-13,-9,-3,-9,-5,13,2,8,-7,13,-14,6,-9,-13,3,-12};
//		int[] array = {-15, 1, 14};
		int[] array = {3,0,3,2,-4,0,-3,2,2,0,-1,-5};
		List<List<Integer>> tmp = ts.threeSum(array);
		System.out.println(tmp);
	}
}
