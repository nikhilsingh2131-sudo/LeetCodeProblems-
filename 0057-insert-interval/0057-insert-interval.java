class Solution {
    public int[][] insert(int[][] intervals, int[] newInterval) {

        List<int[]> ans = new ArrayList<>();

        int i =0;
        int j = intervals.length ;

        while(i<j  && intervals[i][1] < newInterval[0]){
            ans.add(new int[]{intervals[i][0] , intervals[i][1]});
            i++;
        }

        while(i<j && intervals[i][0]<= newInterval[1]){
            newInterval[0] = Math.min(intervals[i][0] , newInterval[0]);
            newInterval[1] =Math.max(intervals[i][1] , newInterval[1]);
            i++;
        }

        ans.add(newInterval);

        while(i<j){
            ans.add(new int[]{intervals[i][0] , intervals[i][1]});
            i++;
        }
        

        return ans.toArray(new int[ans.size()][]);
    }
}