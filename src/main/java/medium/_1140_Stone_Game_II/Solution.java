package medium._1140_Stone_Game_II;

import annotations.Medium;

@Medium
class Solution {

    private int[][] memo;
    private int[] suffix;
    private int n;

    public int stoneGameII(int[] piles) {
        this.n = piles.length;
        this.memo = new int[n][n + 1];
        this.suffix = new int[n + 1];

        for (int i = n - 1; i >= 0; i--) {
            suffix[i] = piles[i] + suffix[i + 1];
        }

        return maxStones(0, 1);
    }

    private int maxStones(int start, int m) {
        if (start >= n) {
            return 0;
        }

        if (start + 2 * m >= n) {
            return suffix[start];
        }

        if (memo[start][m] != 0) {
            return memo[start][m];
        }

        int result = 0;

        for (int x = 1; x <= 2 * m; x++) {
            int opponent = maxStones(
                    start + x,
                    Math.max(m, x)
            );

            int current = suffix[start] - opponent;
            result = Math.max(result, current);
        }

        memo[start][m] = result;
        return result;
    }
}