package medium._0007_Reverse_Integer;

import annotations.Medium;

@Medium
public class Solution {

    //7463847421
    //2147483647
    //1534236469
    //9646324351
    public int reverse(int x) {
        int result = 0;
        int sign = 1;
        if (x < 0) {
            sign = -1;
            x *= sign;
        }

        int count = 0;

        while (x > 0) {
            if (count == 9) {
                if (result == 214748364 && x <= 7) {
                } else if (result >= 214748364) {
                    return 0;
                }
            }
            result = result * 10 + (x % 10);
            x /= 10;
            count++;
        }

        return sign * result;
    }
}