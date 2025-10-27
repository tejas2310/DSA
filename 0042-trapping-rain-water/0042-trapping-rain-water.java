class Solution {
    public int trap(int[] height) {
        int[][] maxLeftRightArray = new int[height.length][2];
        int i;
        for(i = 0; i < height.length ; i++){
            if(i == 0){
                maxLeftRightArray[i][0] = height[i];
                maxLeftRightArray[height.length - 1 - i][1] = height[height.length - 1 - i];
            }else{
                maxLeftRightArray[i][0] = Math.max(height[i],maxLeftRightArray[i-1][0]);
                maxLeftRightArray[height.length - 1 - i][1] = Math.max(height[height.length - 1 - i],maxLeftRightArray[height.length - i][1]);
            }
        }

        int result = 0;
        int stageResult;
        for(i = 0; i < height.length ; i++){
            stageResult = Math.min(maxLeftRightArray[i][0], maxLeftRightArray[i][1]) - height[i];
            if(stageResult > 0) result = result + stageResult;
        }
        
        return result;
    }
}