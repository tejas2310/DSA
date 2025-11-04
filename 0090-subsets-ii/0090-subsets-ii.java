class Solution {
public static List<List<Integer>> subsetsWithDup(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> path = new ArrayList<>();
        Arrays.sort(nums);
        recurSubset(0,nums,res,path);
        return res;
    }

    public static void recurSubset(int index, int[] nums, List<List<Integer>> res, List<Integer> path){
        res.add(new ArrayList<>(path));
        for(int i = index; i < nums.length ; i++){
            if(i > index && nums[i] == nums[i-1]) continue;
            path.add(nums[i]);
            recurSubset(i+1,nums,res,path);
            path.remove(path.size() - 1);
        }
    }
}