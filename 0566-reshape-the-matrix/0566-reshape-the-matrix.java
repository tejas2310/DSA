class Solution {
    public int[][] matrixReshape(int[][] mat, int r, int c) {
        if(r*c != mat.length*mat[0].length) return mat;
        int k = 0;
        int l = 0;
        int[][] result = new int[r][c]; 
        for(int i = 0; i < mat.length;i++){
            for(int j = 0; j<mat[0].length;j++){
                if(l==c){
                    k++;
                    l = 0;
                }
                result[k][l++] = mat[i][j];
            }
        }
        return result;
    }
}