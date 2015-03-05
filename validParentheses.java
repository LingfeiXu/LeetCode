import java.util.HashMap;
import java.util.Map;
import java.util.Stack;



public class Solution {
	public static void main(String[] args) {
		System.out.println(isValid("}"));
	}
    public static boolean isValid(String s) {
        Stack<Character> stack = new Stack<Character>();
        Map<Character,Character> map = new HashMap<Character,Character>();
        map.put(')','(');
        map.put(']','[');
        map.put('}','{');
        for(int i = 0; i < s.length(); i++) {
            char temp = s.charAt(i);
            if(map.containsKey(temp) && (stack.contains(map.get(temp))) ) {
            		stack.pop();
            }
            else
                stack.push(temp);
        }
        if(stack.empty())
            return true;
        else
            return false;
    }
}