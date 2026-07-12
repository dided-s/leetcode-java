package easy._0643_Maximum_Average_Subarray_I;

import annotations.Easy;
import annotations.LeetCode75;

@Easy
@LeetCode75("Sliding Window")
public class Solution {
    public double findMaxAverage(int[] nums, int k) {
        int slidingWindowSum = 0;
        for (int i = 0; i < k; ++i) {
            slidingWindowSum += nums[i];
        }

        int maxSlidingWindowSum = slidingWindowSum;

        for (int i = k; i < nums.length; ++i) {
            slidingWindowSum += nums[i] - nums[i - k];

            if (slidingWindowSum > maxSlidingWindowSum) {
                maxSlidingWindowSum = slidingWindowSum;
            }
        }

        return (double) maxSlidingWindowSum / k;
    }
}