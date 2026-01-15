class Solution {
public static void rotate(int[][] matrix) {
        int iterX;
        int iterY;
        int iterZ;
        int curr;
        int next;
        for(int i = 0; i<matrix.length;i++){
            for(int j = i; j<matrix[0].length-1-i;j++){
                curr = matrix[i][j];
                iterX = i;
                iterY = j;
                do{
                    iterZ = iterX;
                    iterX = iterY;
                    iterY = matrix[0].length-1-iterZ;
                    next = matrix[iterX][iterY];
                    matrix[iterX][iterY] = curr;
                    curr = next;
                }while(!(iterX == i && iterY == j));
            }
        }
        System.out.println(Arrays.deepToString(matrix));
    }
}