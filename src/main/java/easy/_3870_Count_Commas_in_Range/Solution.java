package easy._3870_Count_Commas_in_Range;

import annotations.Easy;

@Easy
public class Solution {

    public int countCommas(int n) {
        int commasCount = 0;

        int minBorderWithComma = 1;
        int comma = 0;

        while (minBorderWithComma * 1000 <= n) {
            minBorderWithComma *= 1000;
            comma++;
        }

        while (minBorderWithComma != 1) {
            commasCount += (n - minBorderWithComma + 1) * comma;
            comma -= 1;
            minBorderWithComma /= 1000;
        }

        return commasCount;
    }
}