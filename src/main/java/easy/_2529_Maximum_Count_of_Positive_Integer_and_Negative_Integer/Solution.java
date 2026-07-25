package easy._2529_Maximum_Count_of_Positive_Integer_and_Negative_Integer;

import annotations.Easy;

@Easy
public class Solution {

    public int maximumCount(int[] nums) {
        int zeroIndex = binarySearch(nums, 0);

        System.out.println("zeroIndex: " + zeroIndex);

        if (zeroIndex >= nums.length) return nums.length;

        int left = zeroIndex;
        while (left >= 0 && nums[left] >= 0) left--;

        int right = zeroIndex;
        while (right < nums.length && nums[right] <= 0) right++;
        right = nums.length - right;

        System.out.println("left: " + left);
        System.out.println("right: " + right);

        return Math.max(left + 1, right);
    }

    public int binarySearch(int[] nums, int target) {
        if (nums == null || nums.length == 0) return 0;
        if (nums.length == 1) return 0;

        int left = 0;
        int right = nums.length - 1;

        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] == target) {
                return mid;
            }
            if (nums[mid] < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        return left;
    }
}