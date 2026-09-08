package easy._1365_How_Many_Numbers_Are_Smaller_Than_the_Current_Number;

import annotations.Easy;

import java.util.Arrays;

@Easy
public class Solution3 {

    public int[] smallerNumbersThanCurrent(int[] nums) {
        int n = nums.length;
        int[] sortArray = Arrays.copyOf(nums, n);
        Arrays.sort(sortArray);

        for (int i = 0; i < n; ++i) {
            nums[i] = leftBinarySearch(sortArray, nums[i]);
        }

        return nums;
    }

    public int leftBinarySearch(int[] sortedArray, int target) {
        int left = 0;
        int right = sortedArray.length - 1;
        int middle;

        while (left <= right) {
            middle = (left + right) / 2;

            if (sortedArray[middle] < target) {
                left = middle + 1;
            } else {
                right = middle - 1;
            }
        }
        return left;
    }
}