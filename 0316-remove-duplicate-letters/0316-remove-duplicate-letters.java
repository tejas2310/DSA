class Solution {
public String removeDuplicateLetters(String s) {
        if(s.length() == 1 ) return s;
        HashMap<Character,int[]> freqMap = new HashMap<>();

        Deque<Character> dq = new ArrayDeque<>();

        for (char c : s.toCharArray()) {
            if (freqMap.containsKey(c)) {
                freqMap.get(c)[0]++;
            } else {
                freqMap.put(c, new int[]{1, 0});
            }
        }

        for(char c : s.toCharArray()){
            if(freqMap.get(c)[1]!=1){
                while(!dq.isEmpty() && c < dq.peekLast() && freqMap.get(dq.peekLast())[0]>0){
                    char ch = dq.removeLast();
                    freqMap.get(ch)[1] = 0;
                }
                dq.addLast(c);
                freqMap.get(c)[1] = 1;
            }
            freqMap.get(c)[0]--;
        }

        StringBuilder sb = new StringBuilder();
        while(!dq.isEmpty()){
            sb.append(dq.removeFirst());
        }
        return sb.toString();
    }
}