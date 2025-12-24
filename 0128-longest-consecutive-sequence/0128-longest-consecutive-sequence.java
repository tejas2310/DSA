class Solution {
public static int longestConsecutive(int[] nums) {
        int finalCount = 0;
        int tempCount = 0;

        HashMap<Integer,Integer> numMap = new HashMap<>();

        for(int num : nums){
            numMap.put(num,0);
        }

        for(int num : nums){
            if(numMap.get(num) == 0){
                tempCount++;
                numMap.put(num,1);
                int temp = num;
                while(true){
                    if(numMap.containsKey(num+1) && numMap.get(num+1) == 0){
                        numMap.put(num+1,1);
                        tempCount++;
                        num++;
                    }else{
                        break;
                    }
                }
                num = temp;
                while(true){
                    if(numMap.containsKey(num-1) && numMap.get(num-1) == 0){
                        numMap.put(num-1,1);
                        tempCount++;
                        num--;
                    }else{
                        break;
                    }
                }
                finalCount = Math.max(finalCount,tempCount);
                tempCount = 0;
            }
        }

        return finalCount;
    }
}