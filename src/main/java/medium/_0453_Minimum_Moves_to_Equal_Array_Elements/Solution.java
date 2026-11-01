package medium._0453_Minimum_Moves_to_Equal_Array_Elements;

import annotations.Medium;

@Medium
public class Solution {
    public int minMoves(int[] nums) {
        // m * (n - 1) = S_end - S_start
        // S_start + m * (n - 1) = n * (min + m)
        // S_start + mn - m = n * min + mn
        // m = S_start - n * min;

        int sum = 0;
        int n = nums.length;
        int min = Integer.MAX_VALUE;

        for (int num : nums) {
            sum += num;
            if (min > num) {
                min = num;
            }
        }

        return sum - n * min;
    }
}