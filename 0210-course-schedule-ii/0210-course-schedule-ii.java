class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {

        List<List<Integer>> graph = new ArrayList<>();

        for(int i=0 ; i< numCourses ; i++){
            graph.add(new ArrayList<>());
        }

        int[] indegree = new int[numCourses];

        for(int [] p: prerequisites){
            int course = p[0];
            int preq = p[1];

            graph.get(preq).add(course);

            indegree[course]++;
        }

        Queue<Integer> q= new LinkedList<>();

        for(int i=0 ; i< numCourses ;i++){
            if(indegree[i]==0){
                q.offer(i);
            }
        }

        int [] ans = new int[numCourses];
        int index =0;

        while(!q.isEmpty()){
            int node = q.poll();

            ans[index++] = node;

            for(int nei:graph.get(node)){
                indegree[nei]--;

                if(indegree[nei]==0){
                    q.offer(nei);
                }
            }
        }

        if(index!=numCourses){
            return new int[0];
        }

        return ans;
        
    }
}