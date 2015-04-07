public class Solution {
    public int minimumTotal(List<List<Integer>> triangle) {
        int row = triangle.size();
        if(row==0)
            return 0;
        if(row==1)
            return triangle.get(0).get(0);
        int[] min = new int[row];
        for(int i =0; i < row; i++) {
            min[i] = triangle.get(row-1).get(i);
        }
        for(int j = row - 2; j >= 0; j--) {
            for(int k = 0; k <= j ; k++) {
                min[k] = Math.min(min[k],min[k+1]) + triangle.get(j).get(k);
            }
        }
        return min[0];
    }
}