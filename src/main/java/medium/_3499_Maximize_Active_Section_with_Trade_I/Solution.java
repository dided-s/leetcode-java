package medium._3499_Maximize_Active_Section_with_Trade_I;

import annotations.Medium;

import java.util.ArrayList;
import java.util.List;

@Medium
public class Solution {

    public int maxActiveSectionsAfterTrade(String s) {
        if (s == null || s.length() == 0) return 0;

        s = '1' + s + '1';

        // Create list, where we count continuous 0s and 1s. 1 as positive number and 0 as negative.
        // 10001111001 -> [1, -3, 4, -2, 1]
        List<Integer> onesAndZeroes = new ArrayList<>();
        int current = 1;

        for (int i = 1; i < s.length(); i++) {
            if (s.charAt(i) == s.charAt(i - 1)) {
                current++;
            } else {
                if (s.charAt(i - 1) == '0') current *= -1;
                onesAndZeroes.add(current);
                current = 1;
            }
        }
        onesAndZeroes.add(current);

        // We need to find how many maxZeroes we can "modify to 1" in a trade.
        // Choose left and right maxZeroes and calculate sum.
        // [1, -3, 4, -2, 1, -1, 4, -5]:
        // 1. abs(-3) + abs(-2) = 5
        // 2. abs(-2) + abs(-1) = 3
        // 3. abs(-1) + abs(-5) = 6
        // Max sum is 6. We need to trade -1 and -5
        int indexTradeMax = -1;
        int maxZeroes = 0;

        for (int i = 0; i < onesAndZeroes.size() - 2; ++i) {
            if (onesAndZeroes.get(i) < 0 && onesAndZeroes.get(i + 1) > 0 && onesAndZeroes.get(i + 2) < 0) {
                int currentZeroes = (-1) * onesAndZeroes.get(i) + (-1) * onesAndZeroes.get(i + 2);

                if (currentZeroes > maxZeroes) {
                    maxZeroes = currentZeroes;
                    indexTradeMax = i;
                }
            }
        }
        if (indexTradeMax != -1) {
            onesAndZeroes.set(indexTradeMax, onesAndZeroes.get(indexTradeMax) * (-1));
            onesAndZeroes.set(indexTradeMax + 2, onesAndZeroes.get(indexTradeMax + 2) * (-1));
        }

        int answer = 0;

        for (int i = 0; i < onesAndZeroes.size(); ++i) {
            if (onesAndZeroes.get(i) > 0) {
                answer += onesAndZeroes.get(i);
            }
        }

        // Remove first and last 1
        return answer - 2;
    }
}