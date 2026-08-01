package medium._0486_Predict_the_Winner;

import annotations.Medium;

@Medium
public class Solution2 {

    public boolean predictTheWinner(int[] nums) {
        return nextStep(nums, 0, nums.length - 1, 0, 0, true);
    }

    public boolean nextStep(int[] nums, int left, int right, int score1, int score2, boolean isFirst) {
        if (left > right) {
            return score1 >= score2;
        }

        if (isFirst) {
            return nextStep(nums, left + 1, right, score1 + nums[left], score2, !isFirst) ||
                    nextStep(nums, left, right - 1, score1 + nums[right], score2, !isFirst);
        } else {
            return nextStep(nums, left + 1, right, score1, score2 + nums[left], !isFirst) &&
                    nextStep(nums, left, right - 1, score1, score2 + nums[right], !isFirst);
        }
    }
}