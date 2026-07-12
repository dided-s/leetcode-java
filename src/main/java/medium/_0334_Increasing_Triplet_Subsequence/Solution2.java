package medium._0334_Increasing_Triplet_Subsequence;

import annotations.LeetCode75;
import annotations.Medium;

@Medium
@LeetCode75("Array / String")
public class Solution2 {

    public boolean increasingTriplet(int[] nums) {
        if (nums.length < 3) return false;

        int min = nums[0];
        int middle = Integer.MAX_VALUE;
        int index = 1;

        while (index < nums.length) {
            if (nums[index] < min) {
                min = nums[index];
            } else if (min < nums[index] && nums[index] < middle) {
                middle = nums[index];
                index++;
                break;
            }
            index++;
        }

        int probableMin = Integer.MAX_VALUE;
        int probableMiddle = Integer.MAX_VALUE;

        while (index < nums.length) {
            if (nums[index] > middle) {
                return true;
            }

            if (min < nums[index] && nums[index] < middle) {
                middle = nums[index];
            }

            if (probableMin < nums[index] && nums[index] < probableMiddle) {
                probableMiddle = nums[index];
            }

            if (probableMiddle < middle) {
                min = probableMin;
                middle = probableMiddle;
                probableMin = Integer.MAX_VALUE;
                probableMiddle = Integer.MAX_VALUE;
            }

            if (nums[index] < min) {
                probableMin = nums[index];
                probableMiddle = Integer.MAX_VALUE;
            }

            System.out.println("index: " + index);
            System.out.println("nums[index]: " + nums[index]);
            System.out.println("min = " + min);
            System.out.println("middle = " + middle);
            System.out.println("probableMin = " + probableMin);
            System.out.println("probableMiddle = " + probableMiddle);
            index++;
        }

        return false;
    }
}