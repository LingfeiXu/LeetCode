public class Solution{
    public static String longestPalindrome(String s){
        String longest = "";
        String mid = "";
        if(s.length() <= 1)
            return s;
        longest = s.substring(0,1);
        for(int i=0; i<s.length()-1; i++){
            mid = midString(s,i,i);
            if(mid.length() > longest.length())
                longest = mid;
            mid = midString(s,i,i+1);
            if(mid.length() > longest.length())
                longest = mid;    
        }
        return longest;

    }

    public static String midString(String s, int midfir, int midsec){
        int limit = 0;
        limit = Math.min(midfir, s.length()-midsec-1);;
        for(int i=0; i<=limit; i++){
            if(s.charAt(midfir-i)==s.charAt(midsec+i)){
                continue;
            } else {
                return s.substring(midfir-i+1,midsec+i);
            }
        }
        if(limit == 0)
            if(s.charAt(midfir)==s.charAt(midsec)){
            	return s.substring(midfir, midsec+1);
            } else {
                return s.substring(midfir,midfir+1);
            }
        return s.substring(midfir-limit,midsec+limit+1);
        // while(midfir>=0 && midsec<s.length() && s.charAt(midfir)==s.charAt(midsec)){
        //     midfir--;
        //     midsec++;
        // }
        // return s.substring(midfir+1,midsec);
    }

}