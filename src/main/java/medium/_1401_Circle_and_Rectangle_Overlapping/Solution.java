package medium._1401_Circle_and_Rectangle_Overlapping;

import annotations.Medium;

@Medium
public class Solution {

    public boolean checkOverlap(int radius, int xCenter, int yCenter, int x1, int y1, int x2, int y2) {
        int circleXRight = xCenter + radius;
        int circleXLeft = xCenter - radius;
        int circleYTop = yCenter + radius;
        int circleYBottom = yCenter - radius;

        if (circleXRight < x1 || circleXLeft > x2 || circleYTop < y1 || circleYBottom > y2) {
            return false;
        }

        double squareXCenter = ((double) x2 + x1) / 2;
        double squareYCenter = ((double) y2 + y1) / 2;

        double minPossibleDistance = distance(squareXCenter, squareYCenter, x1, y1) + radius;

        return distance(squareXCenter, squareYCenter, xCenter, yCenter) <= minPossibleDistance;
    }

    public double distance(double x1, double y1, double x2, double y2) {
        return Math.sqrt(Math.pow(x2 - x1, 2) + Math.pow(y2 - y1, 2));
    }
}