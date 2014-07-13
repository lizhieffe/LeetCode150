package Accepted;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

import Utils.Interval;

public class MergeIntervals {
	public List<Interval> merge(List<Interval> intervals) {
        List<Interval> result = new ArrayList<Interval>();
        if (intervals == null || intervals.size() == 0)
            return result;
        
        HashMap<Integer, Integer> processedIntervals = new HashMap<Integer, Integer>();
        ArrayList<Integer> starts = new ArrayList<Integer>();
        
        for (Interval interval : intervals) {
        	if (processedIntervals.containsKey(interval.start) == false)
                starts.add(interval.start);
        	
            if (processedIntervals.containsKey(interval.start) 
                    && processedIntervals.get(interval.start) >= interval.end);
            else
                processedIntervals.put(interval.start, interval.end);
                
            
        }
        
        Integer[] startsArray = starts.toArray(new Integer[starts.size()]);
        Arrays.sort(startsArray);
        
        if (startsArray.length == 1) {
            result.add(new Interval(startsArray[0], processedIntervals.get(startsArray[0])));
            return result;
        }
            
        Interval tmp = new Interval(startsArray[0], processedIntervals.get(startsArray[0]));
        for (int i = 1; i < startsArray.length; i ++) {
            if (tmp.end >= startsArray[i])
                tmp.end = Math.max(tmp.end, processedIntervals.get(startsArray[i]));
            else {
                result.add(tmp);
                tmp = new Interval(startsArray[i], processedIntervals.get(startsArray[i]));
            }
        }
        result.add(tmp);
        
        return result;
    }
	
	public static void main(String[] args) {
		Interval a1 = new Interval(1, 3);
		
		List<Interval> intervals = new ArrayList<Interval>();
		intervals.add(a1);
		
		MergeIntervals service = new MergeIntervals();
		List<Interval> result = service.merge(intervals);
		
		System.out.println(result);
	}
}
