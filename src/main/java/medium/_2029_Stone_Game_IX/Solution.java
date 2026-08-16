package medium._2029_Stone_Game_IX;

import annotations.Medium;

@Medium
public class Solution {

    public boolean stoneGameIX(int[] stones) {
        int count0 = 0;
        int count1 = 0;
        int count2 = 0;

        for (int stone : stones) {
            if (stone % 3 == 0) {
                count0++;
            } else if (stone % 3 == 1) {
                count1++;
            } else {
                count2++;
            }
        }
        if (count0 % 2 == 0) {
            return count1 >= 1 && count2 >= 1;
        }

        return count1 - count2 > 2 || count2 - count1 > 2;
    }
}