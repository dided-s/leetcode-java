package medium._1679_Max_Number_of_K_Sum_Pairs;

import annotations.LeetCode75;
import annotations.Medium;

@Medium
@LeetCode75("Two Pointers")
public class Solution2 {

    public int maxOperations(int[] nums, int k) {

        int[] diff = new int[k + 1];
        int result = 0;

        for (int num : nums) {
            if (num <= k) {
                if (diff[k - num] > 0) {
                    result++;
                    diff[k - num]--;
                } else {
                    diff[num]++;
                }
            }
        }

        return result;
    }
}