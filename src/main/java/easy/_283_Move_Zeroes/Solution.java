package easy._283_Move_Zeroes;

import annotations.Easy;
import annotations.LeetCode75;

@Easy
@LeetCode75("Two Pointers")
public class Solution {

    public void moveZeroes(int[] nums) {
        int left = 0;
        int right = 0;
        int len = nums.length;

        while (right < len) {
            if (nums[right] != 0) {
                int temp = nums[left];
                nums[left] = nums[right];
                nums[right] = temp;
                left++;
            }
            right++;
        }
    }
}