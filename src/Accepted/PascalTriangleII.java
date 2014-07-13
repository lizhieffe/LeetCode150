package Accepted;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PascalTriangleII {

	public List<Integer> getRow(int rowIndex) {
        List<Integer> result = new ArrayList<Integer>();
        
        if (rowIndex < 0)
            return result;
        
        if (rowIndex == 0) {
            result.add(1);
            return result;
        }
        
        Integer[] row = new Integer[rowIndex + 1];
        row[0] = 1;
        for (int i = 1; i <= rowIndex; i ++) {
            for (int j = i; j >= 0; j --) {
                if (j == i || j == 0)
                    row[j] = 1;
                else
                    row[j] = row[j] + row[j - 1];
            }
        }
        
        return new ArrayList<Integer>(Arrays.asList(row));
    }
}
