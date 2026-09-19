class Solution {
    public boolean checkOverlap(int radius, int xCenter, int yCenter, int x1, int y1, int x2, int y2) {

        int closeX = Math.max(x1 , Math.min(x2,xCenter));
        int closeY = Math.max(y1 , Math.min(y2, yCenter));

        int dx = xCenter - closeX;
        int dy = yCenter - closeY;

        // (distance^2 = dx^2 + dy^2)

         return dx * dx + dy * dy <= radius * radius;
        
    }
}