package medium._1493_Longest_Subarray_of_1s_After_Deleting_One_Element;

import annotations.LeetCode75;
import annotations.Medium;

@Medium
@LeetCode75("Sliding Window")
public class Solution {

    public int longestSubarray(int[] nums) {
        int rightIndex = 0;
        int leftIndex = 0;
        int zeroCount = 0;
        int maxLength = 0;

        while (rightIndex < nums.length) {
            if (nums[rightIndex] == 0) {
                zeroCount++;
            }

            while (zeroCount > 1) {
                if (nums[leftIndex] == 0) {
                    zeroCount--;
                }
                leftIndex++;
            }

            maxLength = Math.max(maxLength, rightIndex - leftIndex);
            rightIndex++;
        }

        return maxLength;
    }
}