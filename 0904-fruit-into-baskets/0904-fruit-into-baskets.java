class Solution {
    public int totalFruit(int[] fruits) {
        HashMap<Integer,Integer> freqMap = new HashMap<>();
        int start = 0;
        int end = 0;
        
        int result = Integer.MIN_VALUE;

        while(end<fruits.length){
            freqMap.merge(fruits[end],1,Integer::sum);

            if(freqMap.size() > 2){
                result = Math.max(end-start, result);
                while(freqMap.size() > 2){
                    freqMap.merge(fruits[start],-1,Integer::sum);
                    if(freqMap.get(fruits[start]) == 0) freqMap.remove(fruits[start]);
                    start++;
                }
            }
            end++;
        }
        return Math.max(end-start, result);
    }
}