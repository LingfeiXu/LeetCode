public class Solution {
    public List<List<Integer>> permuteUnique(int[] num) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        unique(num, 0, result);
        return result;
    }
    
    public void unique(int[] num, int start, List<List<Integer>> result) {
        if (start >= num.length) {
            List<Integer> list = converter(num);
            result.add(list);
        }
        for (int i = start; i<num.length; i++) {
            if (notDup(start,i,num)) {
                swap(start,i,num);
                unique(num, start+1, result);
                swap(start,i,num);                
            }
        }
    }
    
    public boolean notDup(int i, int j, int[] num) {
        for(int k=i; k<j; k++) {
            if (num[k]==num[j])
                return false;
        }
        return true;
    }
    
    public void swap(int i, int j, int[] num) {
        int temp = num[i];
        num[i] = num[j];
        num[j] = temp;
    }
    
    public List<Integer> converter(int[] num) {
        List<Integer> result = new ArrayList<Integer>();
        for(int i=0; i<num.length; i++) {
            result.add(num[i]);
        }
        return result;
    }
}