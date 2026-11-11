package medium._3789_Minimum_Cost_to_Acquire_Required_Items;

import annotations.Medium;

@Medium
class Solution {
    public long minimumCost(int cost1, int cost2, int costBoth, int need1, int need2) {
        if (cost1 + cost2 <= costBoth) {
            return (long) need1 * cost1 + (long) need2 * cost2;
        }

        int minNeed = Math.min(need1, need2);

        long totalCost = (long) minNeed * costBoth;
        need1 -= minNeed;
        need2 -= minNeed;

        if (need1 > 0) {
            totalCost += (long) need1 * Math.min(cost1, costBoth);
        } else {
            totalCost += (long) need2 * Math.min(cost2, costBoth);
        }

        return totalCost;
    }
}