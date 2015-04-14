public class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        if(matrix==null||matrix.length==0||matrix[0].length==0)
            return false;
        int end = matrix.length-1;
        int end2 = matrix[0].length-1;
        return search(matrix, 0, end, target, 0, end2);
    }
    
    public boolean quali(int start, int end, int start2, int end2, int[][] matrix) {
        if(start < 0 || end < 0 || start2 < 0 || end2 < 0)
            return false;
        if(start > matrix.length-1 || end > matrix.length-1)
            return false;
        if(start2 > matrix[0].length-1 || end2 > matrix[0].length-1)
            return false;
        return true;
    }
    
    public boolean search(int[][] matrix, int start, int end, int target, int start2, int end2) {
        if(!quali(start, end, start2, end2, matrix))
            return false;
        if(matrix[start][start2] > target||matrix[end][end2] < target)
            return false;
        if(matrix[start][start2] == target||matrix[end][end2] == target)
            return true;
        while(start < end) {
            int mid = (start + end)/2;
            int mid2 = 0;
            int mid3 = matrix[0].length-1;
            if(matrix[mid][0]==target)
            	return true;
            if(matrix[mid][0]>target) {
            	if(start2==matrix[0].length-1) {
            		start2 = -1;
            		start = start + 1;
            	}
                return search(matrix, start, mid-1, target, start2+1, matrix[0].length-1);
            }
            else if(matrix[mid][0]<target) {
            	if(matrix[mid][mid3]==target)
            		return true;
            	if(matrix[mid][mid3] < target) {
                	if(end2==0) {
                		end = end - 1;
                		end2 = matrix[0].length;
                	}
            		return search(matrix, mid+1, end, target, 0, end2 - 1);
            	} else if(matrix[mid][mid3]>target) {
            		return search(matrix, mid, mid, target, 1, mid3-1);
            	}
            }
        }
        if(start==end) {
            if(start2 > end2)
                return false;
            while(start2 <= end2){
                if(start2 == end2)
                    return matrix[start][start2]==target? true:false;
                int mid3 = (start2 + end2)/2;
                if(matrix[start][mid3]==target)
                    return true;
                else if(matrix[start][mid3]>target) {
                    end2 = mid3-1;
                    start2++;
                }
                else if(matrix[start][mid3]<target) {
                    start2 = mid3+1;
                    end2--;
                }
            }
        }
        return false;
    }
}