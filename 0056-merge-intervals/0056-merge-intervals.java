class Solution {
public static int[][] merge(int[][] intervals) {
        List<int[]> resList = new ArrayList<>();
        int i = 0;

        Arrays.sort(intervals, (a,b) -> {
            if(a!=b){
                return Integer.compare(a[0],b[0]);
            }else{
               return Integer.compare(a[1],b[1]);
            }
        });

        int start = intervals[0][0];
        int end = intervals[0][1];

        while(i< intervals.length){
            if(i != intervals.length -1 && end >= intervals[i+1][0]){
                if(end < intervals[i+1][1]){
                    end = intervals[i+1][1];
                }
            }else{
                if(i == intervals.length-1){
                    if(end >= intervals[i][0]){
                        if(end < intervals[i][1]){
                            resList.add(new int[]{start,intervals[i][1]});
                        }else{
                            resList.add(new int[]{start,end});
                        }
                    }else{
                        resList.add(new int[]{intervals[i][0],intervals[i][1]});
                    }
                }else{
                    resList.add(new int[]{start,end});
                    start = intervals[i+1][0];
                    end = intervals[i+1][1];
                }
            }
            i++;
        }


        int[][] resArray = new int[resList.size()][2];
        for(i = 0 ; i < resList.size(); i++){
            resArray[i] = resList.get(i);
        }

        return resArray;

    }
}