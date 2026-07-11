package easy._1732_Find_the_Highest_Altitude;

import annotations.Easy;
import annotations.LeetCode75;

@Easy
@LeetCode75("Prefix Sum")
public class Solution {

    public int largestAltitude(int[] gain) {
        int maxAltitude = 0;
        int altitude = 0;

        for (int g: gain) {
            altitude += g;
            if (altitude > maxAltitude) {
                maxAltitude = altitude;
            }
        }

        return maxAltitude;
    }
}