package medium._0486_Predict_the_Winner;

import annotations.Medium;

@Medium
public class Solution {

    public boolean predictTheWinner(int[] nums) {
        return nextStep(nums, 0, nums.length - 1, 0, true);
    }

    public boolean nextStep(int[] nums, int left, int right, int scoreDifference, boolean isFirst) {
        if (left > right) {
            return scoreDifference >= 0;
        }

        if (isFirst) {
            return nextStep(nums, left + 1, right, scoreDifference + nums[left], !isFirst) ||
                    nextStep(nums, left, right - 1, scoreDifference + nums[right], !isFirst);
        } else {
            return nextStep(nums, left + 1, right, scoreDifference - nums[left], !isFirst) &&
                    nextStep(nums, left, right - 1, scoreDifference - nums[right], !isFirst);
        }
    }
}