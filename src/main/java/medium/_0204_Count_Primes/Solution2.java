package medium._0204_Count_Primes;

import annotations.Medium;

@Medium
public class Solution2 {

    public int countPrimes(int n) {
        boolean[] sieveOfEratosthenes = new boolean[n];

        for (int i = 2; i < n; i++) {
            if (!sieveOfEratosthenes[i]) {
                for (int j = i + i; j < n; j += i) {
                    sieveOfEratosthenes[j] = true;
                }
            }
        }

        int count = 0;
        for (int i = 2; i < n; i++) {
            if (!sieveOfEratosthenes[i]) {
                count++;
            }
        }

        return count;
    }
}