package Accepted;

import java.util.List;

import Utils.Interval;

public class InsertInterval {

	public List<Interval> insert(List<Interval> intervals, Interval newInterval) {
        if (intervals == null)
        	return null;
        
        if (newInterval == null)
        	return intervals;
        
        if (intervals.size() == 0) {
        	intervals.add(newInterval);
        	return intervals;
        }
        
        int start = -1;
        int end = -1;
        int mid = -1;
        
        int i = 0;
        for (Interval interval : intervals) {
        	if ((interval.start <= newInterval.start && newInterval.start <= interval.end) ||
        			(interval.start <= newInterval.end && newInterval.start <= interval.end) ||
        			(newInterval.start <= interval.start && newInterval.end >= interval.end)) {
        		if (start == -1)
        			start = i;
        		end = i;
        	}
        	else if (interval.end < newInterval.start)
        		mid = i;
        	else
        		break;
        	
        	i ++;
        }
        
        if (start != -1) {
	        int startValue = Math.min(intervals.get(start).start, newInterval.start);
	        int endValue = Math.max(intervals.get(end).end, newInterval.end);
	
	        for (i = 0; i < end - start + 1; i ++)
	        	intervals.remove(start);
	        intervals.add(start, new Interval(startValue, endValue));
        } else
        	intervals.add(mid + 1, newInterval);
       
        
        return intervals;
    }

}
