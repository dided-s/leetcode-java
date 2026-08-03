package contests._0513_weekly_contest;

import annotations.Easy;

@Easy
public class Q1 {

    // Q1. Maximize Pair Strength Using GCD
    public long maxPairStrength(int[] nums) {
        long max = 0;
        long current;
        long gcd;
        for (int i = 0; i < nums.length - 1; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                gcd = gcd(nums[i], nums[j]);
                current = ((long) nums[i]) * nums[j] / (gcd * gcd);

                if (current > max) {
                    max = current;
                }
            }
        }

        return max;
    }

    private int gcd(int a, int b) {
        while (a != 0 && b != 0) {
            if (a > b) {
                return gcd(b, a % b);
            } else {
                return gcd(a, b % a);
            }
        }
        return a + b;
    }
}