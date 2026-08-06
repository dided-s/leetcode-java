package medium._0050_Pow_x_n;

import annotations.Explore;
import annotations.Medium;

@Medium
@Explore("Recursion")
public class Solution {

    public double myPow(double x, int n) {
        if (n < 0)
            return 1 / myPow(1, x, -n);

        return myPow(1, x, n);
    }

    // Tail Recursion
    private double myPow(double answer, double x, int n) {
        if (n == 0) return answer;

        if (n % 2 == 0)
            return myPow(answer, x * x, n / 2);
        else
            return myPow(answer * x, x * x, n / 2);
    }
}