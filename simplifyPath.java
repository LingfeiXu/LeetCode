import java.util.Stack;

public class Solution {
    public static String simplifyPath(String path) {
        StringBuilder res = new StringBuilder();
        if(path==null||path.length()==0)
            return res.toString();
        String[] split = path.split("/");
        Stack<String> stack = new Stack<String>();
        for(String s:split) {
            if(s.length()==0||s.equals(".")) {
            	
            } else if(s.equals("..")) {
                if(!stack.isEmpty())
                    stack.pop();
            } else {
                stack.push(s);
            }
        }
        if(stack.isEmpty()){
            res.append("/");
        } else {
            while(!stack.isEmpty()) {
                res.insert(0,stack.pop());
                res.insert(0,"/");
            }
        }
        return res.toString();
    }
}