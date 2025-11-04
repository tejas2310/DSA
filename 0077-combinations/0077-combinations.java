class Solution {
public  List<List<Integer>> combine(int n, int k){
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> path = new ArrayList<>();
        if(n == k){
            for(int i =1 ; i <=n;i++){
                path.add(i);
            }
            res.add(path);
            return res;
        }

        if(k == 1){
            for(int i = 1 ; i <=n;i++){
                res.add(new ArrayList<>(List.of(i)));
            }
            return res;
        }
        recurCombination(n, k, res, path);
        return res;
    }

    public void recurCombination(int n, int k, List<List<Integer>> res,List<Integer> path){
        if(path.size() == k){
            res.add(new ArrayList<>(path));
        }
        for(int i = 1 ; i<=n ; i++){
            if(path.isEmpty() || i > path.get(path.size() - 1)){
                path.add(i);
                recurCombination(n,k,res,path);
                path.remove(path.size() - 1);
            }
        }
    }
}