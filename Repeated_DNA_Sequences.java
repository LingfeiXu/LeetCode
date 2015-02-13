public class Solution {
    public List<String> findRepeatedDnaSequences(String s) {
        Set<String> result = new HashSet<String>();
        if(s == null||s.length()<10)
            return new ArrayList<String>();
        int targetHash = 0, base = 7, multiple = 1;         //base can also be 5, b mod h; b and h  must be coprime
        for(int i=0; i<10; i++) {
            targetHash = targetHash*base + s.charAt(i);
            multiple *= base;
        }
        multiple /= base;
        Set<Integer> set = new HashSet<Integer>();
        set.add(targetHash);
        
        for(int i=1;i<=s.length()-10;i++) {
            targetHash = (targetHash-multiple*s.charAt(i-1))*base+s.charAt(i+9);
            if(set.contains(targetHash))
                result.add(s.substring(i,i+10));
            else
                set.add(targetHash);
        }
        return new ArrayList<String>(result);
    }
}

//public class Solution {
//     public List<String> findRepeatedDnaSequences(String s) {
//         List<String> result = new ArrayList<String>();
//         Map<Character,Integer> map = new HashMap<Character,Integer>();
//         map.put('A',0);
//         map.put('C',1);
//         map.put('G',2);
//         map.put('T',3);
//         if(s==null||s.length()<10)
//             return new ArrayList<String>();
//         HashSet<Integer> set = new HashSet<Integer>();
//         HashSet<Integer> solution = new HashSet<Integer>();
//         for(int i=0; i<=s.length()-10;i++) {
//             int value = 0;
//             for(int j=i; j<i+10; j++) {
//                 value = (value << 2) | map.get(s.charAt(j));
//             }
//             if(set.contains(value)&&(!solution.contains(value))) {
//                 result.add(s.substring(i,i+10));
//                 solution.add(value);                
//             }
//             else
//                 set.add(value);
//         }
//         return result;
//     }
// }