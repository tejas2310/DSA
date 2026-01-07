class Solution {
public int lengthOfLIS(int[] nums) {
        List<Integer> result = new ArrayList<>();
        int k;
        int l;
        int mid;

        for(int i = 0; i < nums.length ; i++){
            if(i == 0) result.add(nums[i]);
            else{
                if(nums[i] > result.get(result.size() -1)) result.add(nums[i]);
                else{
                    if(result.get(0) > nums[i]) result.set(0,nums[i]);
                    else {
                        k = 0;
                        l = result.size()-1;
                        while (k < l) {
                            mid = k + (l - k) / 2;
                            if (result.get(mid) >= nums[i]) l = mid;
                            else k = mid + 1;
                        }
                        result.set(k, nums[i]);
                    }
                }
            }
        }

        return result.size();
    }
}