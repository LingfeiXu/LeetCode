public class Solution {
    public int evalRPN(String[] tokens) {
        if(tokens==null||tokens.length==0)
            return 0;
        int temp1 = 0, temp2 = 0;
        Stack<Integer> stack = new Stack<Integer>();
        for(String cur : tokens) {
            if(cur.equals("+")) {
                temp1 = stack.pop();
                temp2 = stack.pop();
                stack.push(temp1+temp2);
            } else if(cur.equals("-")) {
                temp1 = stack.pop();
                temp2 = stack.pop();
                stack.push(temp2-temp1);
            } else if(cur.equals("*")) {
                temp1 = stack.pop();
                temp2 = stack.pop();
                stack.push(temp1*temp2);
            } else if(cur.equals("/")) {
                temp1 = stack.pop();
                temp2 = stack.pop();
                stack.push(temp2/temp1);
            } else {
                stack.push(Integer.parseInt(cur));
            }
        }
        return stack.pop();
    }
}