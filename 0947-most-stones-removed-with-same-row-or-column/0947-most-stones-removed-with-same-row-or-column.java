class Solution {

    public class DSU {

    private final int[] parent;
    private final int[] rank;

    public DSU(int size) {
        parent = new int[size + 1];
        rank = new int[size + 1];

        for (int i = 0; i <= size; i++) {
            parent[i] = i;
        }
    }

    public int find(int value) {
        if (parent[value] != value) {
            parent[value] = find(parent[value]);
        }

        return parent[value];
    }

    public void union(int value1, int value2) {

        int root1 = find(value1);
        int root2 = find(value2);

        // Already in the same set
        if (root1 == root2) {
            return;
        }

        if (rank[root1] < rank[root2]) {
            parent[root1] = root2;
        }
        else if (rank[root1] > rank[root2]) {
            parent[root2] = root1;
        }
        else {
            parent[root2] = root1;
            rank[root1]++;
        }
    }

    }


    public int removeStones(int[][] stones) {
        int maxRow = 0;
        int maxCol = 0;

        for(int[] idx : stones){
            maxRow = Math.max(maxRow,idx[0]);
            maxCol = Math.max(maxCol,idx[1]);
        }

        DSU dsu = new DSU(maxCol + maxRow + 2);

        for(int[] idx : stones){
            dsu.union(idx[0], maxRow + 1 + idx[1]);
        }

        Set<Integer> ultimateParent = new HashSet<>();

        for(int i = 0; i <= maxCol + maxRow + 2;i++){
            if(dsu.find(i) != i) ultimateParent.add(dsu.find(i));
        }

        return stones.length - ultimateParent.size();
    }
}
