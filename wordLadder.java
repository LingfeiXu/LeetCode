public class Solution {
    public int ladderLength(String start, String end, Set<String> dict) {
        int flag2 = 0;
        for(int l = 0; l < start.length(); l++) {
        	if(start.charAt(l) != end.charAt(l))
        		flag2++;
        }
        if(flag2 == 1)
        	return 2;
        if(dict.size()==0)
            return 0;
        dict.add(end);
        LinkedList<String> wordQueue = new LinkedList<String>();
        LinkedList<Integer> distanceQueue = new LinkedList<Integer>();
        
        wordQueue.add(start);
        distanceQueue.add(1);
        
        int result = Integer.MAX_VALUE;
        while(!wordQueue.isEmpty()) {
            String currentWord = wordQueue.pop();
            int currentDistance = distanceQueue.pop();
            
            if(currentWord.equals(end)) {
                result = Math.min(result, currentDistance);
            }
            
            for(int i = 0; i < currentWord.length(); i++) {
                char[] currentCharArr = currentWord.toCharArray();
                for(char c = 'a'; c <= 'z'; c++) {
                    currentCharArr[i] = c;
                    
                    String newWord = new String(currentCharArr);
                    if(dict.contains(newWord)) {
                        wordQueue.add(newWord);
                        distanceQueue.add(currentDistance+1);
                        dict.remove(newWord);
                    }
                }
            }
        }
        if(result < Integer.MAX_VALUE)
            return result;
        else
            return 0;
        
    }
}