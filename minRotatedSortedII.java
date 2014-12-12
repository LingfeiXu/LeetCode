class Solution {
    public int findMin(int[] num) {
        return minimumSection(num, 0 ,num.length-1);
    }
    int minimumSection(int[] num, int start, int end){
        if(num[start]<num[end]||num.length == 1)
            return num[0];
        int mid = (end+start)/2;
        if(start==end+1 || start==end-1){
        	return num[start]>num[end]?num[end]:num[start];
        }
        if(num[mid]>num[0]){
            return minimumSection(num, mid, end);
        } else if(num[mid]<num[0]) {
            return minimumSection(num, start, mid);
        } else if(num[mid]==num[0]) {
            if(num[mid]>num[end])
                return minimumSection(num, mid, end);
            else if(num[mid]==num[end])
                return Math.min(minimumSection(num, mid, end),minimumSection(num, start, mid));
        }
        return 0;
    }    
}
