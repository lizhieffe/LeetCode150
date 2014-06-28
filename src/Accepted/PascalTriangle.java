package Accepted;

import java.util.LinkedList;
import java.util.List;

public class PascalTriangle {
	public List<List<Integer>> generate(int numRows) {
        LinkedList<List<Integer>> list = new LinkedList<List<Integer>>();
        return generate(numRows, list);
    }
    
    private LinkedList<List<Integer>> 
    	generate(int numRows, LinkedList<List<Integer>> list) {
        if (numRows <= 0)
            return list;
            
        if (numRows == 1) {
            LinkedList<Integer> tmp = new LinkedList<Integer>();
            tmp.add(1);
            list.add(tmp);
            return list;
        }
        else {
            generate(numRows - 1, list);
            LinkedList<Integer> tmp = new LinkedList<Integer>();
            
            for (int i = 0; i < numRows; i ++) {
                if (i == 0 || i == numRows - 1)
                    tmp.add(1);
                else
                    tmp.add(list.getLast().get(i-1) + list.getLast().get(i));
            }
            
            list.add(tmp);
            return list;
        }
    }
}
