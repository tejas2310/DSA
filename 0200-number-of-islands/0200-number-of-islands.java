class Solution {
public static int numIslands(char[][] grid) {
        if(grid.length == 0 || grid[0].length == 0 ) return 0;
        int[][] sides = new int[][] {
                {1,0},{-1,0},{0,1},{0,-1}
        };
        int islandCount = 0;
        int x;
        int y;
        Queue<int[]> q = new ArrayDeque<>();
        int[][] isVisited = new int[grid.length][grid[0].length];
        for(int i = 0 ; i < grid.length ; i++){
            for(int j = 0; j < grid[0].length ; j++){
                if(grid[i][j] == '1' && isVisited[i][j] != 1){
                    isVisited[i][j] = 1;
                    q.offer(new int[]{i,j});
                    while(!q.isEmpty()){
                        int[] curr = q.poll();
                        for(int[] side : sides){
                            x = curr[0] + side[0];
                            y = curr[1] + side[1];
                            if(x >= 0 && x <= grid.length-1 && y >= 0 && y <= grid[0].length-1 && grid[x][y] == '1' && isVisited[x][y] != 1){
                                isVisited[x][y] = 1;
                                q.offer(new int[]{x,y});
                            }
                        }
                    }
                    islandCount++;
                }
            }
        }
        return islandCount;
    }
}