class Solution {
public static void rotate(int[][] matrix) {
    int n = matrix.length;
    int temp;
    for(int i =0;i<n;i++){
        for(int j = i; j<n-i-1;j++){
            temp = matrix[i][j]; 
            matrix[i][j] = matrix[n-1-j][i]; 
            matrix[n-1-j][i] = matrix[n-1-i][n-1-j];
            matrix[n-1-i][n-1-j] = matrix[j][n-1-i];
            matrix[j][n-1-i] = temp;
        }
    }

}
}