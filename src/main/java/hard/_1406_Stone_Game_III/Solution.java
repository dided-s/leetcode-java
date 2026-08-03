package hard._1406_Stone_Game_III;

import annotations.Hard;

@Hard
public class Solution {

    public String stoneGameIII(int[] stoneValue) {
        int n = stoneValue.length;
        int[] diffScore = new int[n + 1];

        // start position when array length is 0
        diffScore[n] = 0;

        int currentScore;
        int k;
        int nextMaxScoreAdvantage;

        for (int i = n - 1; i >= 0; i--) {
            diffScore[i] = Integer.MIN_VALUE;
            currentScore = 0;

            k = 0;
            while (k < 3 && i + k < n) {
                currentScore += stoneValue[i + k];

                // diffScore[i + k + 1] is max next player advantage
                nextMaxScoreAdvantage = currentScore - diffScore[i + k + 1];

                diffScore[i] = Math.max(diffScore[i], nextMaxScoreAdvantage);
                k++;
            }
        }

        if (diffScore[0] > 0)
            return "Alice";
        else if (diffScore[0] < 0)
            return "Bob";
        else
            return "Tie";
    }
}