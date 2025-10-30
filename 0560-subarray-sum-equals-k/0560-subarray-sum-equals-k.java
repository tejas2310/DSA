class Solution {
public int subarraySum(int[] nums, int k) {
        if(nums.length == 0){
            return 0;
        }
        if(nums.length == 1) {
            if(nums[0] == k){
                return 1;
            }
            return 0;
        }
        int[] prefix = new int[nums.length];
        prefix[0] = nums[0];
        int i;
        int result = 0;
        if(prefix[0] == k) result++;
        for(i = 1; i<nums.length;i++){
            prefix[i] = prefix[i-1] + nums[i];
            if(prefix[i]==k) result++;
        }

        for(i = 1;i<nums.length;i++){
            for(int j = nums.length-1 ; j>=i ; j--){
                if(prefix[j] - prefix[i-1] == k) result++;
            }
        }

        return result;
    }
}