package medium._0167_Two_Sum_II_Input_array_is_sorted;

import annotations.Explore;
import annotations.Medium;

@Medium
@Explore("Array and String")
public class Solution {

    public int[] twoSum(int[] numbers, int target) {
        int left = 0;
        int right = numbers.length - 1;

        while (left < right) {
            if (numbers[left] + numbers[right] == target) {
                return new int[]{left + 1, right + 1};
            }

            if (numbers[left] + numbers[right] < target) {
                left++;
            } else {
                right--;
            }
        }

        return new int[] {-1, -1};
    }
}