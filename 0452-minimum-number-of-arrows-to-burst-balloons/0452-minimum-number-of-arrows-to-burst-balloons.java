class Solution {
    public int findMinArrowShots(int[][] points) {

        Arrays.sort(points, (a, b) -> Integer.compare(a[0], b[0]));

       int[] prev = points[0];

       int count =1;

       for(int i =1 ; i< points.length ;i++){
         int currstart = points[i][0];
         int currend = points[i][1];
         int prevstart = prev[0];
         int prevend = prev[1]; 

         if(currstart > prevend){
            count++;
            prev = points[i];
         }else{
            prev[0] = Math.max(currstart , prevstart);
            prev[1]=Math.min(currend , prevend);
         }
       }
        return count ;
    }
}