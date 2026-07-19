package medium._0189_Rotate_Array;

import annotations.Explore;
import annotations.Medium;

/**
 * ExtraSpace(0)
 */
@Medium
@Explore("Array and String")
public class Solution2 {

    public void rotate(int[] nums, int k) {
        if (nums == null || nums.length == 0) return;
        k %= nums.length;

        if (k == 0) return;

        int leftIndex = 0;
        int pivot = nums.length - k;

        while (true) {
            int rightIndex = pivot;

            while (leftIndex < pivot && rightIndex < nums.length) {
                int temp = nums[leftIndex];
                nums[leftIndex] = nums[rightIndex];
                nums[rightIndex] = temp;

                leftIndex++;
                rightIndex++;
            }

            if (leftIndex == pivot && rightIndex == nums.length) {
                break;
            }

            if (leftIndex == pivot) {
                pivot = rightIndex;
            }
        }
    }
}