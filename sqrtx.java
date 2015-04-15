public class Solution {
    public int mySqrt(int x) {
        if (x == 0) return 0;
        int lastY = 0;
        int y = 1;
        while (y != lastY)
        {
            lastY = y;
            y = (y + x / y) / 2;
        }
        return (int)(y);
    }
}