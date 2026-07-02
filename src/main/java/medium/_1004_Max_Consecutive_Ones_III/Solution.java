package medium._1004_Max_Consecutive_Ones_III;

import annotations.LeetCode75;
import annotations.Medium;

@Medium
@LeetCode75("Sliding Window")
public class Solution {

    public static int longestOnes(int[] nums, int k) {
        int zerosCountInWindow = 0;
        int left = 0;
        int right = 0;
        int maxLength = 0;

        while (right < nums.length) {
            if (nums[right] == 0) {
                zerosCountInWindow++;
            }

            while (zerosCountInWindow > k) {
                if (nums[left] == 0) {
                    zerosCountInWindow--;
                }
                left++;
            }

            maxLength = Math.max(maxLength, right - left + 1);
            right++;
        }

        return maxLength;
    }
}