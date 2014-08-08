package Accepted;

import java.util.ArrayList;
import java.util.HashMap;

public class LRUCache {

	public LRUCache(int capacity) {
        this.capacity = capacity;
        
        if (capacity > 0) {
            cache = new HashMap<Integer, Integer>();
            timeLine = new ArrayList<Integer>();
        }
    }
    
    int capacity;
    HashMap<Integer, Integer> cache;
    ArrayList<Integer> timeLine;

    public int get(int key) {
        if (capacity <= 0)
            return -1;
            
        if (cache.containsKey(key)) {
            timeLine.remove(new Integer(key));
            timeLine.add(new Integer(key));
            return cache.get(key);
        }
        else
            return -1;
    }
    
    public void set(int key, int value) {
        if (cache.containsKey(key)) {
            timeLine.remove(new Integer(key));
        }
        else if (timeLine.size() == capacity) {
            int oldKey = timeLine.remove(0);
            cache.remove(new Integer(oldKey));
        }
        
        timeLine.add(key);
        cache.put(key, value); 
    }
    
    public static void main(String[] args) {
    	int capacity = 2;
    	LRUCache service = new LRUCache(capacity);
    	service.get(2);
    	service.set(2, 6);
    	service.get(1);
    	service.set(1,5);
    	service.set(1,2);
    	service.get(1);
    	service.get(2);
    	
    	
    	
    }
}
