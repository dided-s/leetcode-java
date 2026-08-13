package easy._1446_Consecutive_Characters;

import annotations.Easy;

@Easy
public class Solution {

    public int maxPower(String s) {
        if (s == null || s.length() == 0) return 0;

        int maxPower = 1;
        int currentPower = 1;

        for (int i = 1; i < s.length(); i++) {
            if (s.charAt(i) == s.charAt(i - 1)) {
                currentPower += 1;
            } else {
                if (maxPower < currentPower) maxPower = currentPower;
                currentPower = 1;
            }
        }

        if (maxPower < currentPower) maxPower = currentPower;
        return maxPower;
    }
}