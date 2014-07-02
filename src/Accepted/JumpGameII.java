package Accepted;

public class JumpGameII {
	
	int result = 0;
    int length;
    int[] A;
    
    public int jump(int[] A) {
        length = A.length;
        
        if (length <= 1)
            return 0;
        
        this.A = A;
        jump(0, 1);
        
        return result;
    }
    
    private void jump(int start, int end) {
        int max = 0;
        for (int i = start; i < end; i ++) {
            max = Math.max(i + A[i], max);
        }
        
        if (max >= length - 1) {
            result ++;
            return;
        } else if (max == end - 1)
            return;
        else {
            result ++;
            jump(end, max + 1);
        }
            
    }
    
}
