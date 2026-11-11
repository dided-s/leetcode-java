package medium._3693_Climbing_Stairs_II;

import annotations.Medium;

/**
 * From step i, you can jump only to step i + 1, i + 2, or i + 3.
 * The cost of jumping from step i to step j is defined as: costs[j] + (j - i)2
 */
@Medium
class Solution3 {
    public int climbStairs(int n, int[] costs) {
        int[] dp = new int[n + 1];

        dp[0] = 0;
        dp[1] = costs[0] + 1;
        if (n == 1) return dp[1];

        dp[2] = Math.min(dp[1] + jump(0, 1, costs),  costs[1] + 4);
        if (n == 2) return dp[2];

        dp[3] = Math.min(dp[2] + jump(1, 2, costs),  costs[2] + 9);
        dp[3] = Math.min(dp[1] + jump(0, 2, costs), dp[3]);

        for (int i = 3; i < n; i++) {

            dp[i + 1] = dp[(i + 1) - 1] + jump(i - 1, i, costs);
            dp[i + 1] = Math.min(dp[(i + 1) - 2] + jump(i - 2, i, costs), dp[i + 1]);
            dp[i + 1] = Math.min(dp[(i + 1) - 3] + jump(i - 3, i, costs), dp[i + 1]);
        }

        return dp[n];
    }

    private int jump(int i, int j, int[] costs) {
        return costs[j] + (j - i) * (j - i);
    }
}