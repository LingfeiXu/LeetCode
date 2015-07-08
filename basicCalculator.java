public class Solution {
    public int calculate(String s) {
        Stack<Integer> stack = new Stack<Integer>();
        int res = 0, number = 0, sign = 1;
        for(int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if(Character.isDigit(c)) {
                number = number*10 + (int)(c - '0');
            } else if (c == '+') {
                res = res + sign * number;
                number = 0;
                sign = 1;
            } else if (c == '-') {
                res = res + sign * number;
                number = 0;
                sign = -1;
            } else if (c == '(') {
                stack.push(res);
                stack.push(sign);
                sign = 1;
                res = 0;
            } else if (c == ')') {
                res = res + sign*number;
                number = 0;
                res = res * stack.pop();
                res = res + stack.pop();
            }
        }
        if(number != 0)
            res = res + sign * number;
        return res;
    }
}