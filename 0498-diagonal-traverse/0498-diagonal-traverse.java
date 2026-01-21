class Solution {
    public static int[] findDiagonalOrder(int[][] mat) {
        int[] result = new int[mat.length*mat[0].length];
        int it = 0;
        int x = 0;
        int y = 0;

        while(x <= mat.length-1 && y <= mat[0].length-1){
            while(x <= mat.length-1 && x >=0  && y>=0 && y <= mat[0].length-1){
                result[it++] = mat[x--][y++];
            }
            if(x+1==0 && y-1 < mat[0].length-1){
                x = 0;
            }else{
                x = x + 2;
                y = y - 1;
            }
            while(x <= mat.length-1 && x >=0  && y>=0 && y <= mat[0].length-1){
                result[it++] = mat[x++][y--];
            }
            if(y+1==0 && x-1 < mat.length-1){
                y = 0;
            }else{
                x = x - 1;
                y = y + 2;
            }
        }
        return result;
    }
}