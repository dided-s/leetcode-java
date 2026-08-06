package medium._0050_Pow_x_n;

import annotations.Explore;
import annotations.Medium;

@Medium
@Explore("Recursion")
public class Solution2 {

    public double myPow(double x, int n) {
        if (n < 0)
            return 1 / recursion(x, -n);

        return recursion(x, n);
    }

    private double recursion(double x, int n) {
        if (n == 0) {
            return 1.0;
        }

        double divide2 = recursion(x, n / 2);

        return n % 2 == 0 ? divide2 * divide2 : divide2 * divide2 * x;
    }
}