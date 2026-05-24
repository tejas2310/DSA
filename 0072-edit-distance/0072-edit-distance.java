class Solution {
    public int minDistance(String word1, String word2) {
        int i = word1.length();
        int j = word2.length();
        int[][] memo = new int [i][j];
        for (int[] row : memo) {
            Arrays.fill(row, -1);
        }

        return minDistanceRecur(word1,word2,i-1,j-1,memo);
         
    }

    public int minDistanceRecur(String word1, String word2, int i, int j, int[][] memo){
        if(i < 0) return j + 1;
        if(j < 0) return i + 1;

        if(memo[i][j]!= -1) return memo[i][j];

        int minDistance = 0;

        if(word1.charAt(i) == word2.charAt(j)) minDistance = minDistanceRecur(word1,word2,i-1,j-1,memo);
        else minDistance = 1 + Math.min(
            minDistanceRecur(word1,word2,i-1,j-1,memo),
            Math.min(minDistanceRecur(word1,word2,i,j-1,memo),
            minDistanceRecur(word1,word2,i-1,j,memo))
        );

        return memo[i][j] = minDistance;

    }
}