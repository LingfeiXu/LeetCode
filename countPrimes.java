public class Solution {
    public int countPrimes(int n) {
        if(n<=2)
            return 0;
        boolean[] prime = new boolean[n];
        for(int i = 2; i < n; ++i)
            prime[i] = true;
        int sqr = (int)Math.sqrt(n-1);
        for(int i = 2; i <= sqr; i++) {
            if(prime[i]) {
                for(int j = i + i; j < n; j = j + i)
                    prime[j] = false;
            }
        }
        int sum = 0;
        for(int i = 2; i < n; i++) {
            sum = sum + (prime[i]?1:0);
        }
        return sum;
    }
}