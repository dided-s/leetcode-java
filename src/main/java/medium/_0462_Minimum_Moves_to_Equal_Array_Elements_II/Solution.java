package medium._0462_Minimum_Moves_to_Equal_Array_Elements_II;

import annotations.Medium;

import java.util.Arrays;

@Medium
class Solution {
    public int minMoves2(int[] nums) {
        Arrays.sort(nums);
        int median = nums[nums.length / 2];
        long moves = 0;
        for (int num : nums) {
            moves += Math.abs(num - median);
        }
        return (int) moves;
    }
}