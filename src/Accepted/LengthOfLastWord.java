package Accepted;

public class LengthOfLastWord {

	public int lengthOfLastWord(String s) {
        if (s == null)
            return 0;
            
        int length = 0;
        boolean needRestart = false;
        
        char[] chars = s.toCharArray();
        for (int i = 0; i < chars.length; i ++) {
            if (chars[i] == ' ')
                needRestart = true;
            else {
                if (needRestart == true) {
                    length = 0;
                    needRestart = false;
                }
                length ++;
            }
        }
        
        return length;
    }
}
