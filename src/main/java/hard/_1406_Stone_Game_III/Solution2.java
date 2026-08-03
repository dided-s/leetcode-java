package hard._1406_Stone_Game_III;

import annotations.Medium;

@Medium
public class Solution2 {

    public String stoneGameIII(int[] stoneValue) {
        int scoreDifference = nextStep(stoneValue, 0, 0, true);

        if (scoreDifference == 0) {
            return "Tie";
        } else if (scoreDifference > 0) {
            return "Alice";
        } else {
            return "Bob";
        }
    }

    public int nextStep(int[] stoneValue, int left, int scoreDifference, boolean isFirst) {
        if (left >= stoneValue.length) return scoreDifference;

        int one = stoneValue[left];
        int two = one + (left + 1 < stoneValue.length ? stoneValue[left + 1] : 0);
        int three = two + (left + 2 < stoneValue.length ? stoneValue[left + 2] : 0);

        if (isFirst) {
            return Math.max(
                    Math.max(
                            nextStep(stoneValue, left + 1, scoreDifference + (isFirst ? one : -one), !isFirst),
                            nextStep(stoneValue, left + 2, scoreDifference + (isFirst ? two : -two), !isFirst)
                    ),
                    nextStep(stoneValue, left + 3, scoreDifference + (isFirst ? three : -three), !isFirst)
            );
        } else {
            return Math.min(
                    Math.min(
                            nextStep(stoneValue, left + 1, scoreDifference + (isFirst ? one : -one), !isFirst),
                            nextStep(stoneValue, left + 2, scoreDifference + (isFirst ? two : -two), !isFirst)
                    ),
                    nextStep(stoneValue, left + 3, scoreDifference + (isFirst ? three : -three), !isFirst)
            );
        }
    }
}