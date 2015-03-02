package TimeLimitExceeded;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import org.junit.Test;

public class RepeatedDNASequences {
	public List<String> findRepeatedDnaSequences(String s) {
        List<String> result = new ArrayList<String>();
        if (s == null || s.length() <= 10)
            return result;
        List<Byte> last = getByteRep(s.substring(0, 10));
        Map<List<Byte>, Boolean> map = new HashMap<List<Byte>, Boolean>();
        map.put(last, false);
        for (int i = 10; i < s.length(); ++i) {
        	List<Byte> curr = addChar(last, s.charAt(i));
            if (map.containsKey(curr))
                map.put(curr, true);
            else
                map.put(curr, false);
            last = curr;
        }
        Iterator<Entry<List<Byte>, Boolean>> it = map.entrySet().iterator();
        while (it.hasNext()) {
            Entry<List<Byte>, Boolean> pair = it.next();
            if (pair.getValue())
                result.add(getStringRep(pair.getKey()));
        }
        return result;
    }
    
    private List<Byte> getByteRep(String s) {
    	List<Byte> result = new ArrayList<Byte>();
    	Byte b = null;
        for (int i = 0; i < s.length(); ++i) {
            char c = s.charAt(i);
            int val = getVal(c);
            if (i % 2 == 0)
            	b = new Byte((byte) 0);
            b = (byte)(b | val);
            if (i % 2 == 0) {
                b = (byte)(b << 2);
                result.add(b);
            }
        }
        return result;
    }
    
    private List<Byte> addChar(List<Byte> b, char c) {
    	List<Byte> result = new ArrayList<Byte>();
        for (int i = 0; i < b.size(); ++i) {
            result.add((byte)((b.get(i) & 3) << 2));
            if (i != b.size() - 1)
                result.set(i, (byte)(result.get(i) | (b.get(i + 1) >> 2)));
            else {
                result.set(i, (byte)(result.get(i) | getVal(c)));
            }
        }
        return result;
    }
    
    private String getStringRep(List<Byte> b) {
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < b.size(); ++i) {
            builder.append(getChar((byte)(b.get(i) >> 2)));
            builder.append(getChar((byte)(b.get(i) & 3)));
        }
        return builder.toString();
    }
    
    private int getVal(char c) {
        if (c == 'A')
            return 0;
        else if (c == 'C')
            return 1;
        else if (c == 'G')
            return 2;
        else
            return 3;
    }
    
    private char getChar(byte b) {
        if (b == 0)
            return 'A';
        else if (b == 1)
            return 'C';
        else if (b == 2)
            return 'G';
        else
            return 'T';
    }
    
    @Test
    public void test() {
    	String s = "GAGAGAGAGAGA";
    	List<String> result = new RepeatedDNASequences().findRepeatedDnaSequences(s);
    }
}
