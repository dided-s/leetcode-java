package easy._1920_Build_Array_from_Permutation;

import annotations.Easy;

@Easy
public class Solution {

    public int[] buildArray(int[] nums) {
        int n = nums.length;

        int startValue;

        int previousIndex;
        int nextIndex;

        for (int i = 0; i < n; ++i) {
            if (nums[i] < 0) continue;

            startValue = nums[i];

            previousIndex = i;
            nextIndex = nums[previousIndex];

            while (nextIndex != i) {
                nums[previousIndex] = nums[nextIndex] - n;
                previousIndex = nextIndex;
                nextIndex = nums[nextIndex];
            }

            nums[previousIndex] = startValue - n;
        }

        for (int i = 0; i < n; ++i) {
            nums[i] += n;
        }

        return nums;
    }
}