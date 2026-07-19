package medium._0189_Rotate_Array;

import annotations.Explore;
import annotations.Medium;

@Medium
@Explore("Array and String")
public class Solution3 {

    public void rotate(int[] nums, int k) {
        if (nums == null || nums.length == 0) return;
        k %= nums.length;

        if (k == 0) return;

        int len = nums.length;
        int[] answer = new int[len];

        for (int i = 0; i < nums.length; i++) {
            answer[(k + i) % len] = nums[i];
        }

        for (int i = 0; i < len; i++) {
            nums[i] = answer[i];
        }
    }
}