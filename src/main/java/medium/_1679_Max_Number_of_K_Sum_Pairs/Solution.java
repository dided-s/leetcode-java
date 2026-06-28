package medium._1679_Max_Number_of_K_Sum_Pairs;

import annotations.LeetCode75;
import annotations.Medium;

import java.util.Arrays;

@Medium
@LeetCode75("Two Pointers")
public class Solution {

    public int maxOperations(int[] nums, int k) {
        Arrays.sort(nums);

        int left = 0;
        int right = nums.length - 1;
        int count = 0;

        while (left < right) {
            int sum = nums[left] + nums[right];

            if (sum == k) {
                count++;
                left++;
                right--;
            } else if (sum < k) {
                left++;
            } else {
                right--;
            }
        }

        return count;
    }
}