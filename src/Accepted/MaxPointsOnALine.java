package Accepted;

import java.util.Hashtable;
import java.util.Iterator;
import java.util.Map;

public class MaxPointsOnALine {
	public int maxPoints(Point[] points) {
		if (points.length <= 2)
            return points.length;
        
        int[] maxPoints = new int[points.length];
        for (int i = 0; i < points.length; i ++) {
            // maxPoints[i] = 0;
            int numSamePoints = 0;
            Hashtable<Double, Integer> gradientCount = new Hashtable<Double, Integer>();
            
            for (int j = 0; j < points.length; j ++) {
                
                if (points[i].x == points[j].x && points[i].y == points[j].y)
                    numSamePoints ++;
                else {
                    double gradient;
                    if (points[i].x == points[j].x)
                        gradient = Double.POSITIVE_INFINITY;
                    else {
                    	double p1x = points[i].x;
                    	double p1y = points[i].y;
                    	double p2x = points[j].x;
                    	double p2y = points[j].y;
                    	double dx = p2x-p1x;
                    	double dy = p2y - p1y;
                    	
                        gradient = ((double)(points[i].y - points[j].y)) / ((double)(points[i].x - points[j].x));
                    }
                    
                    if (gradientCount.containsKey(gradient))
                        gradientCount.put(gradient, gradientCount.get(gradient) + 1);
                    else
                        gradientCount.put(gradient, 1);
                }
            }
            
            Iterator it = gradientCount.entrySet().iterator();
            int tmpMaxPoints = numSamePoints;
            while (it.hasNext()) {
                Map.Entry pairs = (Map.Entry)it.next();
                if (tmpMaxPoints < (Integer)pairs.getValue() + numSamePoints)
                    tmpMaxPoints = (Integer)pairs.getValue() + numSamePoints;
            }
            
            maxPoints[i] = tmpMaxPoints;
        }
        
        int tmpMaxPoints = 0;
        for (int i = 0; i < maxPoints.length; i ++) {
            if (tmpMaxPoints < maxPoints[i])
                tmpMaxPoints = maxPoints[i];
        }
        
        return tmpMaxPoints;
    }
	
	class Point {
		int x;
	    int y;
	    Point() { x = 0; y = 0; }
		Point(int a, int b) { x = a; y = b; }
	}
	
	public static void main(String[] args) {
		MaxPointsOnALine mpoal = new MaxPointsOnALine();
				
		Point p1 = mpoal.new Point(84, 250);
		Point p2 = mpoal.new Point(0, 0);
		Point p3 = mpoal.new Point(1, 0);
		Point p4 = mpoal.new Point(0, -70);
		Point p5 = mpoal.new Point(0, -70);
		Point p6 = mpoal.new Point(1, -1);
		Point p7 = mpoal.new Point(21, 10);
		Point p8 = mpoal.new Point(42, 90);
		Point p9 = mpoal.new Point(-42, -230);
		
		Point[] points = {p1, p2, p3, p4, p5, p6, p7, p8, p9};
		
		System.out.println(mpoal.maxPoints(points));
	}
}
