package medium._2958_Length_of_Longest_Subarray_With_at_Most_K_Frequency;

import annotations.Medium;

import java.util.HashMap;

@Medium
public class Solution2 {

    public int maxSubarrayLength(int[] nums, int k) {
        if (nums == null || nums.length == 0) return 0;

        HashMap<Integer, Integer> freq = new HashMap<>();

        freq.put(nums[0], 1);
        int left = 0;
        int right = 1;
        int answer = 1;

        while (right < nums.length) {
            if (freq.containsKey(nums[right]) && freq.get(nums[right]) == k) {
                while (left < right && nums[left] != nums[right]) {
                    freq.put(nums[left], freq.get(nums[left]) - 1);
                    left++;
                }
                left++;
            } else {
                freq.put(nums[right], freq.getOrDefault(nums[right], 0) + 1);
            }

            if (right - left + 1 > answer) {
                answer = right - left + 1;
            }

            right++;
        }

        if (right - left > answer) {
            answer = right - left + 1;
        }

        return answer;
    }
}