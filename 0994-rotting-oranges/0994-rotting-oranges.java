class Solution {
public int orangesRotting(int[][] grid) {
        if(grid == null || grid.length == 0 || grid[0].length == 0) return 0;

        int[][] isVisited = new int[grid.length][grid[0].length];

        int[][] neighbours = new int[][]{
                {0,1},{0,-1},{1,0},{-1,0}
        };

        int result = 0;

        Deque<int[]> queue = new ArrayDeque<>();

        for(int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if(grid[i][j] == 2){
                    isVisited[i][j] = 1;
                    queue.offer(new int[]{i,j,0});
                }
            }
        }
        while(!queue.isEmpty()){
            int[] node = queue.poll();

            for(int[] neighbour : neighbours){
                int neighbourX = node[0] + neighbour[0];
                int neighbourY = node[1] + neighbour[1];

                if(neighbourX >= 0 && neighbourX < grid.length && neighbourY >= 0 && neighbourY < grid[0].length
                        && isVisited[neighbourX][neighbourY] == 0
                        && grid[neighbourX][neighbourY] == 1){
                    isVisited[neighbourX][neighbourY] = 1;
                    grid[neighbourX][neighbourY] = 2;
                    queue.offer(new int[] {
                            neighbourX, neighbourY, node[2]+1
                    });
                }
            }
            result = Math.max(result, node[2]);
        }

        for (int[] ints : grid) {
            for (int j = 0; j < grid[0].length; j++) {
                if (ints[j] == 1) return -1;
            }
        }

        return result;
    }
}