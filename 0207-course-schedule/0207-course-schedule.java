class Solution {
public static boolean canFinish(int numCourses, int[][] prerequisites) {
        int[] visited = new int[numCourses];
        int[] pathVisited = new int[numCourses];

        List<Integer>[] adjList = new ArrayList[numCourses];

        for(int[] edge : prerequisites){
            if(adjList[edge[1]] == null) adjList[edge[1]] = new ArrayList<>();
            adjList[edge[1]].add(edge[0]);
        }

        for(int i = 0; i<numCourses;i++){
            if(visited[i] == 0){
                visited[i] = 1;
                pathVisited[i] = 1;
                if(!dfs(adjList,visited,pathVisited,i)) return false;
            }
        }

        return true;
    }

    public static boolean dfs(List<Integer>[] adjList, int[] visited, int[] pathVisited, int node){

        boolean result = true;

        if(adjList[node] != null){
            for(int neighbour : adjList[node]){
                if(visited[neighbour] == 0){
                    visited[neighbour] = 1;
                    pathVisited[neighbour] = 1;
                    result &= dfs(adjList,visited,pathVisited,neighbour);
                }else{
                    if(pathVisited[neighbour] == 1) return false;
                }
            }
        }

        pathVisited[node] = 0;
        return result;
    }
}