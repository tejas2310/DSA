import static java.lang.Math.*;
class Solution {
    public int lengthOfLongestSubstring(String s) {
        if(s.isEmpty()) return 0; 
        if (s.length()  == 1  ) return 1;
        int i = 0;
        int j = 1;
        int lenght = 1;
        Set<Character> isVisited = new HashSet<>();
        isVisited.add(s.charAt(i));

        while(j < s.length()){
            if(!isVisited.contains(s.charAt(j))){
                lenght = Math.max(lenght,j-i+1);
                isVisited.add(s.charAt(j));
                j++;
            }else{
                while(s.charAt(i) != s.charAt(j)){
                    isVisited.remove(s.charAt(i));
                    i++;
                }
                i++;
                j++;
                // isVisited.add(s.charAt(i));
            }
        }

        return lenght;
    }
}