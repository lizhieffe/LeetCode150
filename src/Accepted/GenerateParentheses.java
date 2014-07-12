package Accepted;

import java.util.ArrayList;
import java.util.List;

public class GenerateParentheses {
	
	List<String> result;
	
	public List<String> generateParenthesis(int n) {
        result = new ArrayList<String>();
        
        generate(n, n, new StringBuilder());
        return result;
    }
	
	private void generate(int first, int second, StringBuilder solution) {
		
		
		if (first == 0 && second == 0)
			result.add(solution.toString());
		else if (first == second) {
			StringBuilder tmpSolution = new StringBuilder(solution);
			tmpSolution.append('(');
			generate(first - 1, second, tmpSolution);
		}
		else {
			if (first != 0) {
				StringBuilder tmpSolution = new StringBuilder(solution);
				tmpSolution.append('(');
				generate(first - 1, second, tmpSolution);
			}
			
			StringBuilder tmpSolution = new StringBuilder(solution);
			tmpSolution.append(')');
			generate(first, second - 1, tmpSolution);
		}
		
			
	}
}
