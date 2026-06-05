class Solution {
public int findLongestChain(int[][] pairs) {
        int[] memo = new int[pairs.length];

        Arrays.sort(pairs, Comparator.comparingInt(e -> e[0]));

        Arrays.fill(memo,1);

        int result = Integer.MIN_VALUE;

        for(int i = 0; i<pairs.length; i++){
            for(int j = 0; j < i ; j++){
                if(pairs[i][0] > pairs[j][1]){
                    memo[i] = Math.max(memo[i],memo[j] + 1);
                }
            }
            result = Math.max(result,memo[i]);
        }

        return result;
    }   
}