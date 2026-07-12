package medium._0238_Product_of_Array_Except_Self;

import annotations.LeetCode75;
import annotations.Medium;

@Medium
@LeetCode75("Array / String")
public class Solution {

    public int[] productExceptSelf(int[] nums) {
        int[] leftNums = new int[nums.length];
        int[] rightNums = new int[nums.length];

        leftNums[0] = 1;
        rightNums[nums.length - 1] = 1;

        for (int i = 1; i < nums.length; i++) {
            leftNums[i] = leftNums[i - 1] * nums[i - 1];
        }

        for (int i = nums.length - 2; i >= 0; i--) {
            rightNums[i] = rightNums[i + 1] * nums[i + 1];
        }

        for (int i = 0; i < nums.length; i++) {
            leftNums[i] = leftNums[i] * rightNums[i];
        }

        return leftNums;
    }
}