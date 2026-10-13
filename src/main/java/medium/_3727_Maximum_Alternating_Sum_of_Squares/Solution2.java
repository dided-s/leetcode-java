package medium._3727_Maximum_Alternating_Sum_of_Squares;

import annotations.Medium;

import java.util.Arrays;

@Medium
public class Solution2 {

    public long maxAlternatingSum(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] < 0) {
                nums[i] *= -1;
            }
        }

        Arrays.sort(nums);

        long answer = 0;
        int left = 0;
        int right = nums.length - 1;

        while (left < right) {
            answer = answer + (long) nums[right] * nums[right] - (long) nums[left] * nums[left];
            left++;
            right--;
        }

        if (left == right) {
            answer = answer + (long) nums[right] * nums[right];
        }

        return answer;
    }
}