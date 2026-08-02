package medium._0877_Stone_Game;

import annotations.Medium;

@Medium
public class Solution {

    public boolean stoneGame(int[] piles) {
        return nextStep(piles, 0, piles.length - 1, 0, true);
    }

    public boolean nextStep(int[] piles, int left, int right, int scoreDifference, boolean isFirst) {
        if (left < right) return scoreDifference >= 0;

        if (isFirst) {
            return nextStep(piles, left + 1, right, scoreDifference + piles[left], !isFirst) ||
                    nextStep(piles, left, right - 1, scoreDifference + piles[right], !isFirst);
        } else {
            return nextStep(piles, left + 1, right, scoreDifference - piles[left], !isFirst) &&
                    nextStep(piles, left, right - 1, scoreDifference - piles[right], !isFirst);
        }
    }
}