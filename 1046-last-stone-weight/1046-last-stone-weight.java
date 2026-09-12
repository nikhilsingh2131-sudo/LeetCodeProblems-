class Solution {
    public int lastStoneWeight(int[] stones) {

        PriorityQueue<Integer> pq = new PriorityQueue<>((a,b)-> b-a);

        for(int stone : stones){
            pq.add(stone);
        }

    
        while(pq.size()>=2){
            int y = pq.poll();
            int x = pq.poll();

            if(y>x){
                int z = y-x;
                pq.add(z);
            }
        }

        return pq.size()==1?pq.peek() : 0;
        
    }
}