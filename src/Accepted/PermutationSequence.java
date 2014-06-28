package Accepted;

import java.util.ArrayList;

public class PermutationSequence {

public String getPermutation(int n, int k) {
        
        ArrayList<String> list = new ArrayList<String>();
        for (Integer i = 1; i <= n; i ++) {
            list.add(i.toString());
        }
        
        String result = "";
        
        int i = n;
        int x = k - 1;
        
        while (i > 1) {
            int sectionSize = 1;
            for (int j = i - 1; j >= 1; j --)
                sectionSize = sectionSize * j;
            int tmp = x / sectionSize;
            result = result + list.remove(tmp);
            x = x % sectionSize;
            i --;
        }
        
        result = result + list.remove(0);
        return result;
    }
	
	public static void main(String[] args) {
		PermutationSequence service = new PermutationSequence();
		System.out.println(service.getPermutation(3, 5));
	}

}
