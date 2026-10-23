class Solution {
    public int[] gardenNoAdj(int n, int[][] paths) {
        List<Integer>[] graph = new ArrayList[n];

        for(int i =0 ;i<n ; i++){
            graph[i] = new ArrayList<>();
        }

        for(int[]path : paths){
            int u = path[0]-1;
            int v = path[1]-1;

            graph[u].add(v);
            graph[v].add(u);
        }

        int [] flower = new int[n];

        solve(0 , n , graph , flower);
        return flower ;
        
    }public boolean solve (int garden ,int n ,
                List<Integer>[] graph, int[] flowers){
        
        if(garden==n){
            return true;
        }

        for(int color =1 ;color<=4 ; color++){
            boolean safe = true;

            for(int nei:graph[garden]){
                if(flowers[nei]== color){
                    safe = false;
                    break;
                }
            }

            if(safe){
                flowers[garden]= color ;
                if(solve(garden+1 , n ,graph , flowers)){
                    return true;
                }

                flowers[garden] =0;
            }

        }

        return false;

    }
}