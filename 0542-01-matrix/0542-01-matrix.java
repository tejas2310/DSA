class Solution {
public int[][] updateMatrix(int[][] mat) {
        if(mat == null || mat.length == 0 || mat[0].length == 0) return new int[][]{{}};

        int[][] neighbours = new int[][]{
                {0,1},{0,-1},{1,0},{-1,0}
        };

        int[][] result = new int[mat.length][mat[0].length];

        int[][] isVisited = new int[mat.length][mat[0].length];

        Deque<int[]> queue = new ArrayDeque<>();

        for(int i = 0; i < mat.length; i++){
            for(int j = 0; j<mat[0].length;j++){
                if(mat[i][j] == 0){
                    queue.offer(new int[]{i,j,0});
                    isVisited[i][j] = 1;
                }
            }
        }

        while(!queue.isEmpty()){
            int[] vector = queue.poll();

            for(int[] neighbour : neighbours){
                int neighbourX = vector[0] + neighbour[0];
                int neighbourY = vector[1] + neighbour[1];

                if(neighbourX >= 0 && neighbourX < mat.length && neighbourY >= 0 && neighbourY < mat[0].length
                        && isVisited[neighbourX][neighbourY] == 0){
                    result[neighbourX][neighbourY] = vector[2] + 1;
                    isVisited[neighbourX][neighbourY] = 1;
                    queue.offer(new int[]{
                            neighbourX, neighbourY, vector[2] + 1
                    });
                    }
                }
            }
        return result;
    }
}