class Solution {
public int splitArray(int[] nums, int k) {
    int low = Integer.MIN_VALUE;
        int high = 0;
        for (int num : nums) {
            high = high + num;
            low = Math.max(low, num);
        }
        int ans = 0;
        int result = Integer.MAX_VALUE;

        if(nums.length == k) return low;
        while(low <= high){
            ans = (high + low) / 2;
            if(splitKCheck(nums, k,  ans)){
                result = Math.min(result, ans);
                high = ans - 1;
            }else{
                low = ans + 1;
            }
        }
        return result;
    }

    public boolean splitKCheck(int[] nums, int k, int ans) {
        int currentSum = 0;
        int splits = 1;

        for (int num : nums) {

            if (num > ans) return false;

            if (currentSum + num <= ans) {
                currentSum += num;
            } else {

                splits++;
                currentSum = num;
                if (splits > k) return false;
            }
        }
        return true;
    }
}