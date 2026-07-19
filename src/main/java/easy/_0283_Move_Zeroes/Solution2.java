package easy._0283_Move_Zeroes;

import annotations.Easy;
import annotations.Explore;
import annotations.LeetCode75;

@Easy
@LeetCode75("Two Pointers")
@Explore("Arrays 101 | Array and String")
public class Solution2 {

    public void moveZeroes(int[] nums) {
        int lag = 0;
        int index = 0;

        while (index < nums.length) {
            if (nums[index] == 0) {
                lag++;
                index++;
                break;
            }
            index++;
        }

        while (index < nums.length) {
            if (nums[index] == 0) {
                lag++;
            } else {
                nums[index - lag] = nums[index];
            }
            index++;
        }

        for (int i = nums.length - lag; i < nums.length; i++) {
            nums[i] = 0;
        }
    }
}