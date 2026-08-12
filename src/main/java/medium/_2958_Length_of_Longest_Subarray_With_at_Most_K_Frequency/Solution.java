package medium._2958_Length_of_Longest_Subarray_With_at_Most_K_Frequency;

import annotations.Medium;

import java.util.HashMap;

@Medium
public class Solution {

    static class Counter {
        int cnt = 1;
    }

    public int maxSubarrayLength(int[] nums, int k) {
        if (nums == null || nums.length == 0) return 0;

        HashMap<Integer, Counter> freq = new HashMap<>();

        freq.put(nums[0], new Counter());
        int left = 0;
        int right = 1;
        int answer = 1;

        while (right < nums.length) {
            if (freq.containsKey(nums[right]) && freq.get(nums[right]).cnt == k) {
                while (left < right && nums[left] != nums[right]) {
                    freq.get(nums[left]).cnt--;
                    left++;
                }
                left++;
            } else {
                if (freq.containsKey(nums[right])) {
                    freq.get(nums[right]).cnt++;
                } else {
                    freq.put(nums[right], new Counter());
                }
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