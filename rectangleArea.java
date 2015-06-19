public class Solution {
    public int computeArea(int A, int B, int C, int D, int E, int F, int G, int H) {
        int cover = 0;
        if(A >= G || B >= H || C <= E || D <= F)
            cover = 0;
        else {
            int len = 0, width = 0;
            if(B > F)
                len = Math.min(H - B, D - B);
            else
                len = Math.min(H - F, D - F);
            if(C < G)
                width = Math.min(C - A, C - E);
            else
                width = Math.min(G - A, G - E);
                cover = len*width;
        }
        int area1 = (C - A)*(D - B);
        int area2 = (G - E)*(H - F);
        return area1 + area2 - cover;
            
    }
}