class Solution {
public int[] topKFrequent(int[] nums, int k) {
        HashMap<Integer, Integer> freqMap = new HashMap<>();
        PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt( e -> e[1]));

        for(int num : nums){
            freqMap.merge(num, 1, Integer::sum);
        }
        for(Map.Entry<Integer,Integer> entry : freqMap.entrySet()){
            pq.offer(new int[] {entry.getKey(),entry.getValue()});
            if(pq.size() > k){
                pq.poll();
            }
        }

        int[] result = new int[k];
        int idx = 0;
        for(int[] num : pq){
            result[idx] = num[0];
            idx++;
        }

        return result;
    }
}