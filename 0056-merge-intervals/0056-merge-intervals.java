class Solution {
    public int[][] merge(int[][] intervals) {
     Arrays.sort(intervals, (a, b) -> Integer.compare(a[0], b[0]));
     List<int[]> ans  = new  ArrayList<>();

     int[] prev = intervals[0];

     for(int i =1 ; i<intervals.length ; i++){
        int currStart = intervals[i][0];
        int currEnd = intervals[i][1];

        int prevStart  = prev[0];
        int prevEnd = prev[1];

        if(prevEnd < currStart){
              ans.add(prev);
             prev = intervals[i];
        }else{
                prev[0] = Math.min(prevStart, currStart);
                prev[1] = Math.max(prevEnd, currEnd);
        }
     }

        ans.add(prev);
        return ans.toArray(new int[ans.size()][]);

    }
}