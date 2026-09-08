package easy._1365_How_Many_Numbers_Are_Smaller_Than_the_Current_Number;

import annotations.Easy;

@Easy
public class Solution {

    public static int[] smallerNumbersThanCurrent(int[] nums) {
        if (nums == null) return new int[]{};

        int[] result = new int[nums.length];
        int[] freq = new int[101];

        for (int num : nums) {
            freq[num]++;
        }

        // Frequency turning to Prefix
        for (int i = 1; i < 101; i++) {
            freq[i] += freq[i - 1];
        }

        for (int i = 0; i < nums.length; i++) {
            result[i] = nums[i] == 0 ? 0 : freq[nums[i] - 1];
        }

        return result;
    }
}