package medium._1201_Ugly_Number_III;

import annotations.Medium;

/**
 * An ugly number is a positive integer that is divisible by a, b, or c.
 * Given four integers n, a, b, and c, return the nth ugly number.
 */
@Medium
class Solution {

    public int nthUglyNumber(int n, int a, int b, int c) {
        int[] nums = new int[]{a, b, c};

        long number = -1;
        long left = 1;
        long right = Long.MAX_VALUE;
        long middle = 1;

        while (left <= right) {
            middle = left + (right - left) / 2;

            if (countDivisible(middle, nums) >= n) {
                number = middle;
                right = middle - 1;
            } else {
                left = middle + 1;
            }
        }

        return (int) number;
    }

    public static long countDivisible(long n, int... divisors) {
        int k = divisors.length;
        long result = 0;

        for (int mask = 1; mask < (1 << k); mask++) {
            long currentLcm = 1;
            int selectedCount = 0;
            boolean valid = true;

            for (int i = 0; i < k; i++) {
                if ((mask & (1 << i)) != 0) {
                    selectedCount++;

                    currentLcm = lcm(currentLcm, divisors[i]);

                    if (currentLcm > n) {
                        valid = false;
                        break;
                    }
                }
            }

            if (!valid) {
                continue;
            }

            long multiples = n / currentLcm;

            if (selectedCount % 2 == 1) {
                result += multiples;
            } else {
                result -= multiples;
            }
        }

        return result;
    }

    private static long lcm(int... nums) {
        if (nums.length == 0) return 0;
        if (nums.length == 1) return nums[0];

        long lcm = lcm(nums[0], nums[1]);

        for (int i = 2; i < nums.length; i++) {
            lcm = lcm(lcm, nums[i]);
        }

        return lcm;
    }

    private static long lcm(long a, long b) {
        return a * b / gcd(a, b);
    }

    private static long gcd(long a, long b) {
        while (a != 0 && b != 0) {
            if (a > b) {
                a = a % b;
            } else {
                b = b % a;
            }
        }

        return a + b;
    }
}