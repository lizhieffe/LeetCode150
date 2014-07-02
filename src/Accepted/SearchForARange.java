package Accepted;

public class SearchForARange {
	
	public int[] searchRange(int[] A, int target) {
		if (A.length == 0) {
			int[] tmp = {-1, -1};
			return tmp;
		}
		
		int start = 0;
        int end = A.length;
        int mid;
        
		while (1 > 0) {
			mid = (end - start) / 2 + start;
			if (A[mid] == target)
				break;
			else if (A[mid] > target) {
				if (end == mid)
					end --;
				else
					end = mid;
			}
			else {
				if (start == mid)
					start ++;
				else
					start = mid;
			}
			
			if (start == end) {
				mid = start;
				if (mid < A.length && A[mid] == target)
					break;
				else {
					int[] tmp = {-1, -1};
					return tmp;
				}
			}
		}
		
        start = mid;
        end = mid;
        
        while (start >= 0) {
        	if (A[start] != target)
        		break;
        	start --;
        }
        start = start + 1;
        
        while (end < A.length) {
        	if (A[end] != target)
        		break;
        	end ++;
        }
        end = end - 1;
        
        int[] tmp = {start, end};
        return tmp;
    }
	
	public static void main(String[] args) {
		int[] a ={2, 2};
		int target = 3;
		
		System.out.println(new SearchForARange().searchRange(a, target));
	}
}
