package medium._3723_Maximize_Sum_of_Squares_of_Digits;

import annotations.Medium;

@Medium
public class Solution {

    public String maxSumOfSquares(int num, int sum) {
        if (num * 9 < sum) {
            return "";
        }

        StringBuilder result = new StringBuilder();

        int nines = sum / 9;
        result.repeat('9', nines);

        sum %= 9;
        if (sum != 0) {
            result.append(sum);
        }

        int tail = num - result.length();
        result.repeat('0', tail);

        return result.toString();
    }
}