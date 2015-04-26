public class Solution {
    public boolean isHappy(int n) {
        Stack<Integer> stack = new Stack<Integer>();
        if(n<=0)
            return false;
        while(!stack.contains(n)) {
            if(n==1)
                return true;
            stack.push(n);
            int res = 0;
            while(n!=0) {
                res = res + (n%10)*(n%10);
                n = n/10;
            }
            n = res;
        }
        return false;
    }
}