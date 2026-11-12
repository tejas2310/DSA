class Solution {
    public int subarraySum(int[] nums, int k) {
        int result = 0;
        if(nums[0] == k) result++;
        for(int i = 1;i<nums.length;i++){
            //if(nums[i] == k) result++;
            nums[i] = nums[i-1] + nums[i];
            if(nums[i] == k) result++;
        }

        for(int i = 1; i < nums.length ; i++){
            for(int j = i ; j < nums.length ; j++){
                if( nums[j] - nums[i-1] == k) result++;
            }
        }
        return result;
    }
}