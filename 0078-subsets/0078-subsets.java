class Solution {
public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> path = new ArrayList<>();
//        int[] isVisited = new int[nums.length+1];
        Set<Integer> isVisited = new HashSet<>();
        recurSubset(nums,res,path,isVisited);
        return res;
    }

    public void recurSubset(int[] nums, List<List<Integer>> res , List<Integer> path, Set<Integer> isVisited){
        res.add(new ArrayList<>(path));
        for(int num : nums){
            if(path.isEmpty() || !isVisited.contains(num) &&  num > path.get(path.size() - 1) ){
                path.add(num);
                isVisited.add(num);
                recurSubset(nums,res,path,isVisited);
                isVisited.remove(path.get(path.size()-1));
                path.remove(path.size()-1);
            }
        }
    }
}