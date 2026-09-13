class Solution {
    public int leastInterval(char[] tasks, int n) {

        Map<Integer , Integer> map = new HashMap<>();

        for(int t:tasks){
            map.put(t,map.getOrDefault(t,0)+1);
        }

        PriorityQueue<Integer> pq = new PriorityQueue<>( (a, b) -> b - a);

        for(int v : map.values()){
            pq.add(v);
        }

        int time =0;

        while(!pq.isEmpty()){
            ArrayList<Integer> temp = new ArrayList<>();

            int cycle = n+1;

            while(cycle>0 && !pq.isEmpty()){
                int freq = pq.poll();
                freq--;

               if(freq>0){
                temp.add(freq);
               }
                time ++;
                cycle --;
            }
            for(int freq : temp){
                pq.add(freq);
            }

            if(!pq.isEmpty()){
                time += cycle;
            }
        }
        return time;
    }
}