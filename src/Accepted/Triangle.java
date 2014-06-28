package Accepted;

import java.util.ArrayList;
import java.util.Arrays;

public class Triangle {
	public int minimumTotal(ArrayList<ArrayList<Integer>> triangle) {
        if (triangle == null)
            return 0;
            
        int column = triangle.size();
        if (column == 0)
            return 0;
        if (column == 1)
            return triangle.get(0).get(0);
            
        for (int i = column - 2; i >= 0; i --) {
            for (int j = 0; j < i + 1; j ++) {
                int min = triangle.get(i).get(j) 
                		+ Math.min(triangle.get(i + 1).get(j), triangle.get(i + 1).get(j + 1));
                triangle.get(i).set(j, min);
            }
        }
        
        return triangle.get(0).get(0);
    }
	
	public static void main(String[] args) {
		Integer[] a1 = {2};
		Integer[] a2 = {3, 4};
		Integer[] a3 = {5, 4, 2};
		ArrayList<Integer> l1 = new ArrayList<Integer>(Arrays.asList(a1));
		ArrayList<Integer> l2 = new ArrayList<Integer>(Arrays.asList(a2));
		ArrayList<Integer> l3 = new ArrayList<Integer>(Arrays.asList(a3));
		
		ArrayList<ArrayList<Integer>> f = new ArrayList<ArrayList<Integer>>();
		f.add(l1);
		f.add(l2);
		f.add(l3);

		Triangle service = new Triangle();
		System.out.println(service.minimumTotal(f));
	}
}
