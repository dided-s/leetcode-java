package medium._0204_Count_Primes;

import annotations.Medium;

@Medium
public class Solution {

    public int countPrimes(int n) {
        if (n <= 2) return 0;
        boolean[] sieveOfEratosthenes = new boolean[n];

        int count = n / 2;
        for (int i = 3; i * i < n; i += 2) {
            if (sieveOfEratosthenes[i]) continue;

            for (int j = i * i; j < n; j += 2 * i) {
                if (!sieveOfEratosthenes[j]) {
                    count--;
                    sieveOfEratosthenes[j] = true;
                }
            }
        }

        return count;
    }
}