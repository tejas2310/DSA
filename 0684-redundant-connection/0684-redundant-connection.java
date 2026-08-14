class Solution {

    public class DSU {

    private final int[] parent;
    private final int[] rank;

    public DSU(int size) {
        parent = new int[size + 1];
        rank = new int[size + 1];

        for (int i = 1; i <= size; i++) {
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

public int[] findRedundantConnection(int[][] edges) {
        DSU dsu = new DSU(edges.length);
        int[] result = new int[2];

        for(int[] edge :edges){
            if(dsu.find(edge[0]) == dsu.find(edge[1])){
                result[0] = edge[0];
                result[1] = edge[1];
            }else{
                dsu.union(edge[0], edge[1]);
            }
        }

        return result;
    }
}