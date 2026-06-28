package medium._334_Increasing_Triplet_Subsequence;

import annotations.LeetCode75;
import annotations.Medium;

@Medium
@LeetCode75("Array / String")
public class Solution {

    public boolean increasingTriplet(int[] nums) {
        int first = Integer.MAX_VALUE;
        int second = Integer.MAX_VALUE;
        for (int num : nums) {
            if (num <= first) {
                first = num;
            } else if (num <= second) {
                second = num;
            } else {
                return true;
            }
        }

        return false;
    }
}