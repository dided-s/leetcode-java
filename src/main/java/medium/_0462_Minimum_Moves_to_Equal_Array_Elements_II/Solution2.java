package medium._0462_Minimum_Moves_to_Equal_Array_Elements_II;

import annotations.Medium;

import java.util.Arrays;

@Medium
public class Solution2 {
    public int minMoves2(int[] nums) {
        Arrays.sort(nums);

        int answer = 0;

        int leftIndex = 0;
        int rightIndex = nums.length - 1;

        int min = nums[leftIndex];
        int minCount = 0;
        int max = nums[rightIndex];
        int maxCount = 0;

        while (min < max) {
            while (leftIndex <= rightIndex && nums[leftIndex] == min) {
                leftIndex++;
                minCount++;
            }

            while (leftIndex <= rightIndex && nums[rightIndex] == max) {
                rightIndex--;
                maxCount++;
            }

            if (minCount <= maxCount) {
                int nextMin = nums[leftIndex];

                int diff = nextMin - min;
                answer += diff * minCount;
                min = nextMin;
            } else {
                int nextMax = nums[rightIndex];

                int diff = max - nextMax;
                answer += diff * maxCount;
                max = nextMax;
            }
        }

        return answer;
    }
}