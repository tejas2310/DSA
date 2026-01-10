class Solution {
    public static int[] rearrangeArray(int[] nums) {
        int[] result = new int[nums.length];
        int i = 0;
        int j = 0;
        while(nums[i] < 0) i++;
        while(nums[j] > 0) j++;
        int it = 1;
        result[0] = nums[i];
        i++; //5
        while(i <= nums.length-1 && nums[i] < 0) i++;

        while(i<nums.length || j<nums.length){
            if(result[it-1] < 0){
                result[it] = nums[i];
                i++; //5
                while(i <= nums.length-1 && nums[i] < 0) i++;
            }else{
                result[it] = nums[j];
                j++;
                while(j <= nums.length-1 && nums[j] > 0) j++;
            }
            it++;
        }

        return result;
    }
}