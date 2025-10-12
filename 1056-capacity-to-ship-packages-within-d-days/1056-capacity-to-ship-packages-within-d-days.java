class Solution {
    public int shipWithinDays(int[] weights, int days) {
        int lowest = Integer.MIN_VALUE;
        int highest = 0;
        for(int weight : weights){
            lowest = Math.max(weight,lowest);
            highest = highest + weight;
        }
        int mid;
        if(weights.length == days) return lowest;
        int result = Integer.MAX_VALUE;

        while(lowest <= highest){
            mid = (lowest + highest) / 2;
            if(shipCheck(weights,days,mid)){
                result = Math.min(mid,result);
                highest = mid - 1;
            }else{
                lowest = mid + 1;
            }
        }
        return result;
    }

    public boolean shipCheck(int[] weights, int days, int mid){
        int sum = 0;
        int dayCount = 1;
        for(int weight : weights){
            if(sum+weight <= mid){
                sum = sum + weight;
            }else{
                dayCount++;
                sum = weight;
            }
            if(dayCount > days) return false;
        }
        return true;
    }
}