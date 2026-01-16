class Solution {
    public static int[] sortedSquares(int[] nums) {
        if(nums[0] >= 0){
            for(int i = 0; i < nums.length;i++){
                nums[i] = nums[i] * nums[i];
            }
            return nums;
        }
        int i = 0;
        int j = nums.length-1;
        int mid = 0;
        int count = 0;
        int[] result = new int[nums.length];

        while(i<=j){
            mid = (i+j)/2;
            if(nums[mid] >= 0){
                if(nums[mid-1]<0){
                    break;
                }
                j = mid-1;
            }else{
                i = mid+1;
            }
        }

        i = mid-1;
        j = mid;

        while(count!=result.length){
            if(i<0){
                result[count] = nums[j] * nums[j];
                j++;
            }else if(j>result.length-1){
                result[count] = nums[i] * nums[i];
                i--;
            }
            else if(Math.abs(nums[i]) > Math.abs(nums[j])){
                result[count] = nums[j] * nums[j];
                j++;
            }else if(Math.abs(nums[i]) < Math.abs(nums[j])){
                result[count] = nums[i] * nums[i];
                i--;
            }else{
                result[count] = nums[j] * nums[j];
                count++;
                result[count] = nums[i] * nums[i];
                i--;
                j++;
            }
            count++;
        }
        return result;
    }
}