public class Solution {
    public int minDistance(String word1, String word2) {
        if(word1.length() == 0) return word2.length();
        if(word2.length() == 0) return word1.length();

        int[][] ed = new int[word1.length()+1][word2.length()+1];
        for(int i = 0; i<word2.length(); i++){
            ed[word1.length()][i] = word2.length() - i; 
        }
        for(int j = 0; j<word1.length(); j++){
            ed[j][word2.length()] = word1.length()-j;
        }
        for(int i = word1.length()-1; i>=0; i--){
            for(int j = word2.length()-1; j>=0; j--){
                if(word1.charAt(i) == word2.charAt(j)){
                    ed[i][j] = ed[i+1][j+1];
                }else{
                    ed[i][j] =1+ Math.min(ed[i+1][j+1], Math.min(ed[i+1][j], ed[i][j+1]));
                }
            }
        }
        return ed[0][0];
    }
}