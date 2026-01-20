class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        int xstart = 0;
        int xend = matrix.length - 1 ;
        int ystart = 0;
        int yend = matrix[0].length - 1;
        int i;
        List<Integer> result = new ArrayList<>();

        while(xstart<=xend && ystart<=yend){
            for(i = ystart;i<=yend;i++) result.add(matrix[xstart][i]);
            xstart++;

            for(i = xstart;i<=xend;i++) result.add(matrix[i][yend]);
            yend--;
            
            if (xstart <= xend) {
                for (i = yend; i >= ystart; i--)
                    result.add(matrix[xend][i]);
                xend--;
            }

            if (ystart <= yend) {
                for (i = xend; i >= xstart; i--)
                    result.add(matrix[i][ystart]);
                ystart++;
            }
        }
        return result;
    }
}