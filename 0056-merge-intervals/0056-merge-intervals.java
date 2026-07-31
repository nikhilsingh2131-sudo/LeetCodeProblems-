class Solution {
    public int[][] merge(int[][] intervals) {

        Arrays.sort(intervals, (a, b) -> Integer.compare(a[0], b[0]));

        int [] prev = intervals[0];

        List<int[]> ans = new ArrayList<>();

        for(int i=1;i< intervals.length ; i++){
            int currstart = intervals[i][0];
            int currend = intervals[i][1];

            int prevstart = prev[0];
            int prevend = prev[1];

            if(currstart>prevend){
                ans.add(new int []{prevstart , prevend});
                prev = intervals[i];
            }else{
                prev[0] = Math.min(currstart , prevstart);
                prev[1] = Math.max(currend , prevend);

            }
        }
         ans.add(prev);

        return ans.toArray(new int[ans.size()][]);
    }
}