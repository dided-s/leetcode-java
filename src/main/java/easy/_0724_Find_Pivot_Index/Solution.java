package easy._0724_Find_Pivot_Index;

import annotations.Easy;
import annotations.Explore;
import annotations.LeetCode75;

@Easy
@LeetCode75("Prefix Sum")
@Explore("Arrays 101")
public class Solution {

    public int pivotIndex(int[] nums) {
        if (nums == null || nums.length == 0) return -1;
        int rightPrefixSum = 0;

        for (int num : nums) {
            rightPrefixSum += num;
        }

        int leftPrefixSum = 0;

        for (int i = 0; i < nums.length; i++) {
            rightPrefixSum -= nums[i];
            if (leftPrefixSum == rightPrefixSum) {
                return i;
            }
            leftPrefixSum += nums[i];
        }

        return -1;
    }
}