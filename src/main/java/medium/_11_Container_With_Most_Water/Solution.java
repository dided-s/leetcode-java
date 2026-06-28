package medium._11_Container_With_Most_Water;

import annotations.LeetCode75;
import annotations.Medium;

@Medium
@LeetCode75("Two Pointers")
public class Solution {

    public int maxArea(int[] height) {

        int left = 0, right = height.length - 1;
        int maxArea = 0;
        int area;

        while (left < right) {
            if (height[left] < height[right]) {
                area = height[left] * (right - left);
                left++;
            } else {
                area = height[right] * (right - left);
                right--;
            }

            maxArea = Math.max(maxArea, area);
        }

        return maxArea;
    }
}