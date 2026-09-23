package medium._1658_Minimum_Operations_to_Reduce_X_to_Zero;

import annotations.Medium;

@Medium
public class Solution {

    public int minOperations(int[] nums, int x) {
        int n = nums.length;

        // Calculate total sum
        int totalSum = 0;
        for (int num : nums) {
            totalSum += num;
        }

        // We inverse our task: find sliding window sum with max number of elements
        int slidingWindowTargetSum = totalSum - x;

        // If slidingWindowTargetSum is negative, impossible
        if (slidingWindowTargetSum < 0) {
            return -1;
        }

        // If slidingWindowTargetSum is 0, we need to remove all elements
        if (slidingWindowTargetSum == 0) {
            return n;
        }

        int left = 0;
        int sum = 0;
        int maxLength = -1;

        // Sliding window
        for (int right = 0; right < n; right++) {
            sum += nums[right];

            // Shrink window if sum becomes too large
            while (sum > slidingWindowTargetSum) {
                sum -= nums[left];
                left++;
            }

            // Found a subarray with slidingWindowTargetSum sum
            if (sum == slidingWindowTargetSum) {
                maxLength = Math.max(maxLength, right - left + 1);
            }
        }

        // If no valid subarray exists
        if (maxLength == -1) {
            return -1;
        }

        return n - maxLength;
    }
}