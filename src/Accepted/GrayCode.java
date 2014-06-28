package Accepted;

import java.util.ArrayList;
import java.util.List;

public class GrayCode {
	
	public List<Integer> grayCode(int n) {
        ArrayList<String> strings = generateGrayCode(n);
        ArrayList<Integer> tmp = new ArrayList<Integer>();
        for (String string : strings) {
            tmp.add(Integer.parseInt(string, 2));
        }
        return tmp;
    }
    
    private ArrayList<String> generateGrayCode(int n) {
        if (n < 0)
            return null;
        
        ArrayList<String> tmp = new ArrayList<String>();

        if (n == 0) {
            tmp.add("0");
            return tmp;
        }
        
        if (n == 1) {
            tmp.add("0");
            tmp.add("1");
            return tmp;
        }
        
        ArrayList<String> grayCodeForNMinusOne = generateGrayCode(n-1);
        
        for (int i = 0; i < grayCodeForNMinusOne.size(); i ++)
            tmp.add("0" + grayCodeForNMinusOne.get(i));
        for (int i = grayCodeForNMinusOne.size() - 1; i >= 0; i --)
            tmp.add("1" + grayCodeForNMinusOne.get(i));
        return tmp;
    }
    
    public static void main(String[] args) {
    	GrayCode gc = new GrayCode();
    	System.out.println(gc.generateGrayCode(4));
    }
}
