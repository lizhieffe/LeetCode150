package Accepted;

import java.util.ArrayList;
import java.util.List;

public class NQueens {

	List<List<Position>> result;
    int n;
    
    public List<String[]> solveNQueens(int n) {
        
        result = new ArrayList<List<Position>>();
        this.n = n;
        
        if (n > 0)
            solve(n, new Position(0, 0), new ArrayList<Position>());
            
        return generateOutput();
    }
    
    private void solve(int tmpN, Position start, List<Position> solution) {
        if (tmpN <= 0)
            return;
        
        if (start.x < 0 || start.x >= n || start.y < 0 || start.y >= n)
            return;
        
        List<Position> newSolution;
        
        int i = start.x;
        for (int j = 0; j < n; j ++) {
        	newSolution = new ArrayList<Position>(solution);
            if (checkPosition(new Position(i, j), newSolution) == true) {
                newSolution.add(new Position(i, j));
                if (tmpN == 1)
                    result.add(newSolution);
                else {
                	solve(tmpN - 1, new Position(i + 1, 0), newSolution);
                }
            }
        }
    }
    
    private boolean checkPosition(Position position, List<Position> solution) {
        for (Position existing : solution) {
            if (position.x == existing.x || position.y == existing.y 
                    || Math.abs(position.x - existing.x) == Math.abs(position.y - existing.y))
                return false;
        }
        
        return true;
    }
    
    private List<String[]> generateOutput() {
        List<String[]> stringOutput = new ArrayList<String[]>();
        
        if (result == null || result.size() == 0)
            return stringOutput;
            
        for (List<Position> solution : result) {
            String[] stringSolution = new String[n];
            String tmpString = "";
            for (int i = 0; i < n; i ++)
                tmpString = tmpString + ".";
                
            for (int i = 0; i < n; i ++)
                stringSolution[i] = tmpString;
            
            for (Position position : solution) {
            	StringBuilder builder = new StringBuilder(stringSolution[position.x]);
            	builder.setCharAt(position.y, 'Q');
            	
            	stringSolution[position.x] = builder.toString();

            }
            
            stringOutput.add(stringSolution);
        }
        
        return stringOutput;
    }
    
    private class Position {
        int x;
        int y;
        Position(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
    
    public static void main(String[] args) {
    	NQueens service = new NQueens();
    	List<String[]> r = service.solveNQueens(5);
    	System.out.println(r);
    }
}
