package Accepted;

import java.util.LinkedList;

public class SimplifyPath {
	public String simplifyPath(String path) {
        
        if (path == null)
            return null;
        if (path.length() == 0)
            return "";
            
        LinkedList<String> levels = new LinkedList<String>();
        
        String[] s = path.split("/");
        for (int i = 0; i < s.length; i ++) {
            if (s[i].equals("") || s[i].equals("."))
                continue;
            else if (s[i].equals("..")) {
                if (levels.size() > 0)
                    levels.removeLast();
                else
                    continue;
            } else
                levels.add(s[i]);
        }
        
        String result = "";
        if (levels.size() == 0)
            return "/";
        else 
            while (levels.size() > 0)
                result = result + "/" + levels.removeFirst();
                
        return result;
    }
	
	public static void main(String[] args) {
		String path = "/.";
		
		System.out.println(new SimplifyPath().simplifyPath(path));
	}
}
