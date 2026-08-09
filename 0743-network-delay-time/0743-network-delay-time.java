class Solution {
public static int networkDelayTime(int[][] times, int n, int k){
        if(times == null || times.length == 0) return -1;

        int[] minimumDistTracker = new int[n+1];
        Arrays.fill(minimumDistTracker, Integer.MAX_VALUE);
        HashMap<Integer, List<int[]>> adjGraph = new HashMap<>();
        minimumDistTracker[k] = 0;

        for(int[] edge : times){
            adjGraph.computeIfAbsent(edge[0], _ -> new ArrayList<>()).add(new int[] {edge[1],edge[2]});
        }


        PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt((int[] e) -> e[0]));

        pq.offer(new int[] {0, k});

        while(!pq.isEmpty()){
            int[] edge = pq.poll();

            if(adjGraph.containsKey(edge[1])){
                for(int[] edgeWeight : adjGraph.get(edge[1])){
                    int newWeight = edgeWeight[1] + edge[0];
                    if(newWeight < minimumDistTracker[edgeWeight[0]]){
                        minimumDistTracker[edgeWeight[0]] = newWeight;
                        pq.offer(new int[] {newWeight, edgeWeight[0]});
                    }
                }
            }
        }
        int result = Integer.MIN_VALUE;
        for (int i = 1; i <= n; i++) {
            if (minimumDistTracker[i] == Integer.MAX_VALUE) {
                return -1;
            }

            result = Math.max(result, minimumDistTracker[i]);
        }
        return result;
    }
}