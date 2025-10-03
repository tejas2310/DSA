class Solution {
    public boolean isBipartite(int[][] graph) {
        String[] colorizedGraph = new String[graph.length];

        for (int start = 0; start < graph.length; start++) {
            // Skip already colored nodes
            if (colorizedGraph[start] != null) continue;

            // Skip isolated nodes (no edges)
            if (graph[start].length == 0) continue;

            Queue<Integer> queue = new ArrayDeque<>();
            queue.offer(start);
            colorizedGraph[start] = "Y";

            while (!queue.isEmpty()) {
                int node = queue.poll();
                for (int neighbor : graph[node]) {
                    String nodeColor = colorizedGraph[node];
                    if (colorizedGraph[neighbor] != null) {
                        if (colorizedGraph[neighbor].equals(nodeColor)) {
                            return false; // conflict
                        }
                    } else {
                        colorizedGraph[neighbor] = nodeColor.equals("Y") ? "G" : "Y";
                        queue.offer(neighbor);
                    }
                }
            }
        }
        return true;
    }
}
