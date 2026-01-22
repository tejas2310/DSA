class Solution {
    public boolean isToeplitzMatrix(int[][] matrix) {
        int x; 
        int y;
        int start;

        for(int i = 0; i<matrix.length;i++){
            start = matrix[i][0];
            x = i+1;
            y = 1;
            while(x<=matrix.length-1 && x >= 0 && y <= matrix[0].length-1 && y >= 0){
                if(start != matrix[x++][y++]) return false;
            }
        }

        for(int j = 1; j<matrix[0].length;j++){
            start = matrix[0][j];
            x = 1;
            y = j+1;
            while(x<=matrix.length-1 && x >= 0 && y <= matrix[0].length-1 && y >= 0){
                if(start != matrix[x++][y++]) return false;
            }
        }
        return true;
    }
}