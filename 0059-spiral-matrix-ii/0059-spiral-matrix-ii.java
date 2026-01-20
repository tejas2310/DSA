class Solution {
    public int[][] generateMatrix(int n) {
        int number = 1;
        
        int xstart = 0;
        int xend = n-1;

        int ystart = 0;
        int yend = n-1;

        int i;

        int[][] result = new int[n][n];
        while(xstart<=xend && ystart<=yend){
            for(i = ystart;i<=yend;i++){
                result[xstart][i] = number++;
            }
            xstart++;
            for(i = xstart;i<=xend;i++){
                result[i][yend] = number++;
            }
            yend--;

            if(xstart<=xend){
                for(i = yend;i>=ystart;i--){
                    result[xend][i] = number++;
                }
                xend--;
            }

            if(ystart<=yend){
                for(i = xend;i>=xstart;i--){
                    result[i][ystart] = number++;
                }
                ystart++;
            }
        }
        return result; 
    }
}