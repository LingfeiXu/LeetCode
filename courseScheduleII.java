public class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        if(prerequisites == null)
            return new int[0];
        
        int len = prerequisites.length;
        int[] res = new int[numCourses];
        
        if(numCourses == 0 || len == 0) {
            for(int i = 0; i < numCourses; i++) {
                res[i] = i; 
            }            
            return res;
        }
        
        int[] pCounter = new int[numCourses];
        for(int i = 0; i < len; i++) {
            pCounter[prerequisites[i][0]]++;
        }
        
        LinkedList<Integer> queue = new LinkedList<Integer>();
        int seq = 0;
        for(int i = 0; i < numCourses; i++) {
            if(pCounter[i] == 0) {
                queue.add(i);
                res[seq] = i;
                seq++;
            }
        }
        
        int numNoPre = queue.size();
        
        while(!queue.isEmpty()){
            int top = queue.remove();
            for(int i = 0; i < len; i++) {
                if(prerequisites[i][1] == top) {
                    pCounter[prerequisites[i][0]]--;
                    if(pCounter[prerequisites[i][0]]==0){
                        numNoPre++;
                        res[seq] = prerequisites[i][0];
                        seq++;
                        queue.add(prerequisites[i][0]);
                    }
                }
            }
        }
        return numNoPre == numCourses?res:new int[0];
    }
}