package easy._1365_How_Many_Numbers_Are_Smaller_Than_the_Current_Number;

import annotations.Easy;

import java.util.Arrays;

@Easy
public class Solution2 {

    public int[] smallerNumbersThanCurrent(int[] nums) {
        int n = nums.length;
        int[] sortArray = Arrays.copyOf(nums, n);
        Arrays.sort(sortArray);

        for (int i = 0; i < n; ++i) {
            for (int j = 0; j < n; ++j) {
                if (nums[i] == sortArray[j]) {
                    nums[i] = j;
                    break;
                }
            }
        }

        return nums;
    }
}