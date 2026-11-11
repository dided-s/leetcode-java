package medium._3693_Climbing_Stairs_II;

import annotations.Medium;

/**
 * From step i, you can jump only to step i + 1, i + 2, or i + 3.
 * The cost of jumping from step i to step j is defined as: costs[j] + (j - i)2
 */
@Medium
class Solution {
    public int climbStairs(int n, int[] costs) {
        if(n == 1) return costs[0] + 1;
        int thirdBack = 0;
        int secondBack = costs[0] + 1;
        int firstBack = costs[1] + Math.min(secondBack + 1, 4);
        int result = firstBack;

        for(int i = 3; i <= n; i++){
            int oneStep = firstBack + 1;
            int twoStep = secondBack + 4;
            int threeStep = thirdBack + 9;

            result = costs[i - 1] + Math.min(oneStep, Math.min(twoStep, threeStep));
            thirdBack = secondBack;
            secondBack = firstBack;
            firstBack = result;
        }
        return result;
    }
}