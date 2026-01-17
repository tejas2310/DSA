class Solution {
public static int romanToInt(String s) {

        if(s.isEmpty()) return 0;

        HashMap<Character,Integer> map = new HashMap<>();
        map.put('I',1);
        map.put('V',5);
        map.put('X',10);
        map.put('L',50);
        map.put('C',100);
        map.put('D',500);
        map.put('M',1000);

//        MCMXCIV

        int result = map.get(s.charAt(s.length()-1));
        int prev = map.get(s.charAt(s.length()-1));

        for(int i = s.length()-2;i>=0;i--){
            int curr = map.get(s.charAt(i));
            if(curr < prev) result = result - curr;
            else result = result + curr;
            prev = curr;
        }

        return result;

    }
}