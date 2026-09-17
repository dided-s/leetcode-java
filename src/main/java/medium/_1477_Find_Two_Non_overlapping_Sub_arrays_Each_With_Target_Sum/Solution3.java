package medium._1477_Find_Two_Non_overlapping_Sub_arrays_Each_With_Target_Sum;

import annotations.Medium;

@Medium
public class Solution3 {

    public int subarraySum(int[] nums, int k) {
        int n = nums.length;
        int count = 0;

        for (int left = 0; left < n; left++) {
            int sum = 0;

            for (int right = left; right < n; right++) {
                sum += nums[right];
                if (sum == k)
                    count++;
            }
        }

        return count;
    }
}