class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int low = 1;
        int high = Integer.MIN_VALUE;
        for(int pile : piles){
            high = Math.max(high,pile);
        }

        int mid;
        int result = Integer.MAX_VALUE;

        if(piles.length == h) return high;

        while(low <= high){
            mid = (low + high)/2;
            if(kokoSpeed(piles, h, mid)){
                high = mid - 1;
                result = Math.min(result,mid);
            }else{
                low = mid + 1;
            }
        }
        return result;
    }

    public boolean kokoSpeed(int[] piles, int h, int mid){
        int bananaEatCount = 0;
        int divisor;
        for(int pile : piles){
            divisor = pile / mid;
            if(pile % mid == 0) bananaEatCount = bananaEatCount + divisor;
            else bananaEatCount = bananaEatCount + divisor + 1;

            if(bananaEatCount > h) return false;
        }
        return true;
    }
}