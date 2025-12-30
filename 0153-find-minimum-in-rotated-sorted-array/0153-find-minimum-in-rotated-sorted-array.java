class Solution {
public int findMin(int[] nums) {
        if(nums.length == 1) return nums[0];
        if(nums[nums.length - 1] > nums[0]) return nums[0];

        int start = 0;
        int end = nums.length - 1;
        int mid;
        while(start <= end){
            mid = start +(end - start)/2;
            if (nums[mid] > nums[mid+1]) return nums[mid+1];
            if (nums[mid] < nums[mid-1]) return nums[mid];
            if (nums[mid] > nums[end]) start = mid + 1;
            else end = mid - 1;
        }
        return 0;
    }
}