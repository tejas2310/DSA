class Solution {
public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> path = new ArrayList<>();
        Arrays.sort(candidates);
        recurCombinationSum(0, candidates,target,0,res,path);
        return res;
    }
    
    public void recurCombinationSum(int index, int[] candidates, int target, int currSum, List<List<Integer>> res, List<Integer> path){
        if(currSum == target){
            res.add(new ArrayList<>(path));
            return;
        }
        if(currSum > target){
            return;
        }
        
        for(int i = index; i < candidates.length ; i++){
            path.add(candidates[i]);
            currSum += candidates[i];
            recurCombinationSum(i,candidates,target,currSum,res,path);
            if(currSum > target){
                currSum= currSum - path.get(path.size()-1);
                path.remove(path.size()-1);
                break;
            }
            currSum-=path.get(path.size()-1);
            path.remove(path.size()-1);
        }
        
    }
}