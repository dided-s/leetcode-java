package medium._1477_Find_Two_Non_overlapping_Sub_arrays_Each_With_Target_Sum;

import annotations.Medium;

@Medium
public class Solution2 {
    public int subarraySum(int[] nums, int k) {
        int count = 0;
        int[] prefixSum = new int[nums.length + 1];
        prefixSum[0] = 0;
        for (int i = 1; i <= nums.length; i++) {
            prefixSum[i] = prefixSum[i - 1] + nums[i - 1];
        }

        for (int left = 0; left < nums.length; left++) {
            for (int right = left + 1; right <= nums.length; right++) {
                if (prefixSum[right] - prefixSum[left] == k)
                    count++;
            }
        }
        return count;
    }
}