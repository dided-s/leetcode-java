package medium._0209_Minimum_Size_Subarray_Sum;

import annotations.Explore;
import annotations.Medium;

@Medium
@Explore("Array and String")
public class Solution {

    public int minSubArrayLen(int target, int[] nums) {
        if (nums == null || nums.length == 0) return 0;

        int sum = 0;
        int leftIndex = 0;
        int minLength = Integer.MAX_VALUE;

        for (int rightIndex = 0; rightIndex < nums.length; rightIndex++) {
            sum += nums[rightIndex];

            while (sum >= target) {
                minLength = Math.min(minLength, rightIndex - leftIndex + 1);
                sum -= nums[leftIndex];
                leftIndex++;
            }
        }

        return (minLength == Integer.MAX_VALUE) ? 0 : minLength;
    }
}