package medium._3727_Maximum_Alternating_Sum_of_Squares;

import annotations.Medium;

@Medium
public class Solution {

    private final int SIZE = 40_001;

    public long maxAlternatingSum(int[] nums) {
        int[] freq = new int[SIZE];

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] < 0) {
                freq[-1 * nums[i]]++;
            } else {
                freq[nums[i]]++;
            }
        }

        int left = 0;
        int right = SIZE - 1;
        long answer = 0;

        while (left < right) {
            while (left < right && freq[left] == 0) {
                left++;
            }
            while (left < right && freq[right] == 0) {
                right--;
            }

            if (left == right) break;

            int count = Math.min(freq[left], freq[right]);
            freq[left] -= count;
            freq[right] -= count;

            long diff = right * right - left * left;
            answer += diff * count;
        }

        if (freq[left] % 2 == 1) {
            answer += left * left;
        } else if (freq[right] % 2 == 1) {
            answer += right * right;
        }

        return answer;
    }
}