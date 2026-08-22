class SmallestInfiniteSet {

    PriorityQueue<Integer> pq;
    HashSet<Integer> set;
    int next;

    public SmallestInfiniteSet() {
        pq = new PriorityQueue<>();
        set = new HashSet<>();
        next = 1;
    }

    public int popSmallest() {

        if (!pq.isEmpty()) {
            int ans = pq.poll();
            set.remove(ans);
            return ans;
        }

        return next++;
    }

    public void addBack(int num) {

        // Agar number already present hai
        if (num >= next || set.contains(num)) {
            return;
        }

        pq.offer(num);
        set.add(num);
    }
}