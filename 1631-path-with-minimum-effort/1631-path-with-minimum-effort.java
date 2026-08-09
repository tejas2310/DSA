class Solution {
public int minimumEffortPath(int[][] heights) {
        if(heights == null || heights.length == 0 || heights[0].length == 0) return 0;

        int[][] minimumEffortPerPeak = new int[heights.length][heights[0].length];

        for(int[] row : minimumEffortPerPeak){
            Arrays.fill(row, Integer.MAX_VALUE);
        }

        int[][] neighbours = new int[][]{
                {1,0},
                {-1,0},
                {0,1},
                {0,-1}
        };

        minimumEffortPerPeak[0][0] = 0;

        PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(e -> e[0]));

        pq.offer(new int[]{0,0,0});

        while(!pq.isEmpty()){
            int [] peak = pq.poll();

            for(int[] neighbour : neighbours){
                int neighbourX = neighbour[0] + peak[1];
                int neighbourY = neighbour[1] + peak[2];
                if(neighbourX >= 0 &&
                    neighbourY >= 0 &&
                    neighbourX <= heights.length -1 &&
                    neighbourY <= heights[0].length -1){
                    int neighbourEffort = Math.max(Math.abs(heights[neighbourX][neighbourY] - heights[peak[1]][peak[2]]) , peak[0]);
                    if(neighbourEffort < minimumEffortPerPeak[neighbourX][neighbourY]){
                        minimumEffortPerPeak[neighbourX][neighbourY] = neighbourEffort;
                        pq.offer(new int [] {neighbourEffort,neighbourX,neighbourY});
                    }
                }
            }
        }

        return minimumEffortPerPeak[heights.length -1][heights[0].length -1];
    }
}