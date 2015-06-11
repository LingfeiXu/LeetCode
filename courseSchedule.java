/*
public class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        if(prerequisites == null)
            throw new IllegalArgumentException("Illegal prerequisites array");
        
        int len = prerequisites.length;
        
        if(numCourses == 0 || len == 0)
            return true;
        
        int[] pCounter = new int[numCourses];
        for(int i = 0; i < len; i++) {
            pCounter[prerequisites[i][0]]++;
        }
        
        LinkedList<Integer> queue = new LinkedList<Integer>();
        
        for(int i = 0; i < numCourses; i++) {
            if(pCounter[i] == 0) {
                queue.add(i);
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
                        queue.add(prerequisites[i][0]);
                    }
                }
            }
        }
        
        return numNoPre == numCourses;
        
    }
}
*/

public class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        if(prerequisites == null)
            throw new IllegalArgumentException("Illegal prerequisites array");
        
        int len = prerequisites.length;
        
        if(numCourses == 0 || len == 0)
            return true;
        
        int[] visit = new int[numCourses];
        
        HashMap<Integer, ArrayList<Integer>> map = new HashMap<Integer, ArrayList<Integer>>();
        for(int[] a: prerequisites) {
            if(map.containsKey(a[1])) {
                map.get(a[1]).add(a[0]);
            } else {
                ArrayList<Integer> l = new ArrayList<Integer>();
                l.add(a[0]);
                map.put(a[1],l);
            }
        }
        
        for(int i = 0; i < numCourses; i++) {
            if(!canFinishDFS(map,visit,i))
                return false;
        }
        
        return true;
    }
    
    private boolean canFinishDFS(HashMap<Integer, ArrayList<Integer>> map, int[] visit, int i) {
        if(visit[i]==-1)
            return false;
        if(visit[i]==1)
            return true;
        
        visit[i] = -1;
        if(map.containsKey(i)){
            for(int j: map.get(i)) {
                if(!canFinishDFS(map, visit, j))
                    return false;
            }
        }
        visit[i] = 1;
        return true;
    }
}