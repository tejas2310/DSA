class Solution {
public static int[] productExceptSelf(int[] nums) {
        int len = nums.length - 1;
        int[][] numSums = new int[nums.length][2];

        for(int i = 0; i<nums.length; i++){
            if(i == 0){
                numSums[i][0] = nums[i];
                numSums[len][1] = nums[len];
                continue;
            }
            numSums[i][0] = nums[i] * numSums[i-1][0];
            numSums[len - i][1] = nums[len - i] * numSums[len - i + 1][1];
        }
        int[] result = new int[nums.length];

        for(int i = 0; i < nums.length ; i++){
            if(i == 0){
                result[i] = numSums[i+1][1];
                continue;
            }
            if(i == nums.length -1){
                result[i] = numSums[i-1][0];
                continue;
            }

            result[i] = numSums[i-1][0] * numSums[i+1][1];
        }
        return  result;
    }
}