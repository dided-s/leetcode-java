package easy._0645_Set_Mismatch;

import annotations.Easy;

@Easy
public class Solution {

    public int[] findErrorNums(int[] nums) {
        int n = nums.length;

        int duplicate = 0;

        for (int i = 0; i < n; ++i) {
            int index = Math.abs(nums[i]) - 1;
            if (nums[index] > 0) {
                nums[index] *= -1;
            } else {
                duplicate = Math.abs(nums[i]);
            }
        }

        int missing = 0;
        for (int i = 0; i < n; ++i) {
            if (nums[i] > 0) {
                missing = i + 1;
            }
        }

        return new int[]{duplicate, missing};
    }
}