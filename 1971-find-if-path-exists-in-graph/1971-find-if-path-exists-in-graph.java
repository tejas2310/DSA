class Solution {
public boolean validPath(int n, int[][] edges, int source, int destination) {
    if(source == destination) return true;
    if(edges == null || edges.length == 0 || edges.length - 1 < source) return false;

    List<Integer>[] adjList = new ArrayList[n];

    for(int[] edge : edges){
        if(adjList[edge[0]] == null) adjList[edge[0]] = new ArrayList<>();
        if(adjList[edge[1]] == null) adjList[edge[1]] = new ArrayList<>();

        adjList[edge[0]].add(edge[1]);
        adjList[edge[1]].add(edge[0]);
    }

    if(adjList[source] == null) return false;

    Deque<Integer> queue = new ArrayDeque<>();

    int[] isVisited = new int[n];

    queue.offer(source);
    isVisited[source] = 1;

    while(!queue.isEmpty()){
        int nodeValue = queue.poll();

        if(adjList[source] != null){
            for(int childNodeValue : adjList[nodeValue]){
                if(destination == childNodeValue) return true;
                if(isVisited[childNodeValue] == 0){
                    queue.offer(childNodeValue);
                    isVisited[childNodeValue] = 1;
                }
            }
        }
    }

    return false;
}
}