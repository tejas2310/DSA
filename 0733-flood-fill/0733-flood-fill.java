class Solution {
        public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        int[][] isVisited = new int[image.length][image[0].length];
        int[] Pixel = new int[]{sr,sc};
        int originalColor = image[sr][sc];
        image[sr][sc] = color;
        Queue<int[]> queue = new ArrayDeque<>();
        queue.offer(Pixel);
        while(!queue.isEmpty()){
            Pixel = queue.poll();
            int[][] fourAdjPixel = getFourAdjElements(Pixel);
            for(int[] AdjPixel : fourAdjPixel){
                int row = AdjPixel[0];
                int col = AdjPixel[1];
                if( 0 <= row && row < image.length && 0<= col && col< image[0].length && isVisited[row][col] == 0){
                    if(image[row][col] == originalColor){
                        queue.offer(AdjPixel);
                        isVisited[row][col] = 1;
                        image[row][col] = color;
                    }
                }
            }
        }
        return image;
    }

    public static int[][] getFourAdjElements(int[] dimension){
    return new int[][]{
            {dimension[0]-1, dimension[1]},
            {dimension[0],dimension[1]-1}, {dimension[0], dimension[1]+1},
            {dimension[0]+1, dimension[1]}
    };
    }
}