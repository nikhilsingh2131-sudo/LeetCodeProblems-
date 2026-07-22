class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {

       List<List<Integer>> graph = new ArrayList<>();

        for (int i = 0; i < numCourses; i++) {
            graph.add(new ArrayList<>());
        }

        int [] indegree = new int[numCourses];

         for (int[] edge : prerequisites) {

            int course = edge[0];   // Jo course karna hai
            int prereq = edge[1];   // Uska prerequisite

            graph.get(prereq).add(course); // prereq → course

            indegree[course]++; // Incoming edge increase
        }

        Queue<Integer>q = new LinkedList<>();

        for(int i =0 ; i < numCourses ; i++){
            if(indegree[i] == 0){
                q.offer(i);
            }
        }
        int count =0;

        while(!q.isEmpty()){
            int node = q.poll();
            count++;

             for (int nei : graph.get(node)) {

                indegree[nei]--; // Dependency remove

                if (indegree[nei] == 0) {

                    q.offer(nei);
                }
            }
        }
    
        return count == numCourses;
    }
}