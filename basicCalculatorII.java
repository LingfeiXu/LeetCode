public class Solution {
    public int calculate(String s) {
        Stack<Integer> stack = new Stack<Integer>();
        int res = 0, number = 0, sign = 1, flag = 0;
        for(int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if(Character.isDigit(c)) {
                number = number*10 + (int)(c - '0');
            } else if (c == '+') {
                 if(flag!=0) {
                    res = flag==1? res*number:res/number;
                    flag = 0;
                    res = res * stack.pop();
                    res = res + stack.pop();                    
                } else {   
                    res = res + sign * number;
                }
                number = 0;
                sign = 1;                
            } else if (c == '-') {
                if(flag!=0) {
                    res = flag==1? res*number:res/number;
                    flag = 0;
                    res = res * stack.pop();
                    res = res + stack.pop(); 
                } else {                
                    res = res + sign * number;
                }
                number = 0;
                sign = -1;                
            } else if (c == '*'||c == '/') {
                if(flag!=0) {
                    res = flag==1? res*number:res/number;
                } else {
                    stack.push(res);
                    stack.push(sign);
                    sign = 1;
                    res = number;
                }
                flag = c=='*'?1:-1;
                number = 0;
            }
        }
        if(number != 0) {
            if(flag==0)
                res = res + sign * number;
            else {
                res = flag==1? res*number:res/number;
                res = res * stack.pop();
                res = res + stack.pop();                 
            }
        }
        return res;
    }
}