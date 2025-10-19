class Solution {
public static boolean canFinish(int numCourses, int[][] prerequisites) {
        if(prerequisites.length == 0) return true;
        List<Integer>[] outDegreeGraph = new ArrayList[numCourses];
        int[] inDegressGraph = new int[numCourses];
        Queue<Integer> q = new ArrayDeque<>();
        List<Integer> result = new ArrayList<>();

        for(int[] node : prerequisites){
            inDegressGraph[node[0]]++;
            if(outDegreeGraph[node[1]] == null) outDegreeGraph[node[1]] = new ArrayList<>(List.of(node[0]));
            else outDegreeGraph[node[1]].add(node[0]);
        }

        for(int i = 0; i< inDegressGraph.length ; i++){
            if (inDegressGraph[i] == 0) q.offer(i);
        }

        while(!q.isEmpty()){
            int course = q.poll();
            result.add(course);
            if(outDegreeGraph[course] == null) continue;
            for(int childCourse : outDegreeGraph[course]){
                inDegressGraph[childCourse]--;
                if (inDegressGraph[childCourse] == 0) q.offer(childCourse);
            }
        }
        return result.size() == numCourses;
    }
}