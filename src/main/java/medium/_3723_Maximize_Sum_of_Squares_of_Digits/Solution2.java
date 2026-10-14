package medium._3723_Maximize_Sum_of_Squares_of_Digits;

import annotations.Medium;

@Medium
public class Solution2 {

    public String maxSumOfSquares(int num, int sum) {
        StringBuilder result = new StringBuilder();

        while (sum > 0) {
            if (sum >= 9) {
                result.append(9);
                sum -= 9;
            } else {
                result.append(sum);
                sum = 0;
            }

            if (result.length() > num) return "";
        }

        int tail = num - result.length();
        result.repeat('0', tail);

        return result.toString();
    }
}