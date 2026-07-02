package medium._1004_Max_Consecutive_Ones_III;

import annotations.LeetCode75;
import annotations.Medium;

@Medium
@LeetCode75("Sliding Window")
public class Solution2 {

    public int longestOnes(int[] nums, int k) {
        if (nums == null || nums.length == 0) return 0;
        if (k == 0) return longestOnes(nums);

        int headIndex = 0;
        int tailIndex = 0;
        int maxLengthWithK = 0;

        while (headIndex <= nums.length) {
            int currentLength = headIndex - tailIndex;
            if (currentLength > maxLengthWithK) {
                maxLengthWithK = currentLength;
            }
            if (headIndex == nums.length || nums[headIndex] == 0) {
                if (k > 0) {
                    k--;
                } else {
                    while (tailIndex < headIndex && nums[tailIndex] == 1) {
                        tailIndex++;
                    }

                    if (tailIndex < headIndex && nums[tailIndex] == 0) {
                        tailIndex++;
                    }
                }
            }
            headIndex++;
        }

        return maxLengthWithK;
    }

    public int longestOnes(int[] nums) {
        int index = 0;
        int maxLength = 0;
        int currentLength = 0;

        while (index <= nums.length) {
            if (index == nums.length || nums[index] == 0) {
                if (currentLength > maxLength) {
                    maxLength = currentLength;
                }
                currentLength = 0;
            } else {
                currentLength++;
            }
            index++;
        }

        return maxLength;
    }
}