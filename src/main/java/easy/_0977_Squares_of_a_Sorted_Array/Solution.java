package easy._0977_Squares_of_a_Sorted_Array;

import annotations.Easy;
import annotations.Explore;

@Easy
@Explore("Arrays 101")
public class Solution {

    public int[] sortedSquares(int[] nums) {
        int index = 0;

        while (index < nums.length && nums[index] < 0) {
            index++;
        }

        int leftIndex = index - 1;
        int rightIndex = index;
        int resultIndex = 0;
        int[] result = new int[nums.length];

        while (resultIndex < nums.length) {
            int left = (leftIndex >= 0) ? -1 * nums[leftIndex] : Integer.MAX_VALUE;
            int right = (rightIndex < nums.length) ? nums[rightIndex] : Integer.MAX_VALUE;

            if (left < right) {
                result[resultIndex] = left * left;
                leftIndex--;
            } else {
                result[resultIndex] = right * right;
                rightIndex++;
            }

            resultIndex++;
        }

        return result;
    }
}