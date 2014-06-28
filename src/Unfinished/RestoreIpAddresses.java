package Unfinished;

import java.util.ArrayList;
import java.util.List;

public class RestoreIpAddresses {
	String[] parts = {"", "", "", ""};
    
    ArrayList<String> ipAddresses = new ArrayList<String>();
    
    public List<String> restoreIpAddresses(String s) {
        getPart(s, 0);
        return this.ipAddresses;
    }
    
    private void getPart(String s, int index) {
        if (s == null)
            return;
            
        if (s.length() < 4 - index)
            return;
            
        int potentialLength = 3 > s.length() ? s.length() : 3;
        for (int i = 0; i < potentialLength; i ++) {
            String part1 = s.substring(0, i + 1);
            String part2 = s.substring(i + 1, s.length());
            
        }
    }
}
