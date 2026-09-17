package medium._0560_Subarray_Sum_Equals_K;

import annotations.Medium;

import java.util.Arrays;

@Medium
public class Solution2 {

    public int minSumOfLengths(int[] arr, int target) {
        if (arr == null || arr.length == 0) return -1;
        int n = arr.length;
        int[] prefixMinLength = new int[n];
        int[] suffixMinLength = new int[n];

        Arrays.fill(prefixMinLength, Integer.MAX_VALUE);
        Arrays.fill(suffixMinLength, Integer.MAX_VALUE);

        for (int left = 0; left < n; left++) {
            int sum = 0;
            for (int right = left; right < n; right++) {
                sum += arr[right];
                if (sum == target) {
                    int length = right - left + 1;
                    if (prefixMinLength[right] > length) {
                        prefixMinLength[right] = length;
                    }
                    if (suffixMinLength[left] > length) {
                        suffixMinLength[left] = length;
                    }
                }
            }
        }

        for (int i = 1; i < n; ++i) {
            if (prefixMinLength[i] > prefixMinLength[i - 1]) {
                prefixMinLength[i] = prefixMinLength[i - 1];
            }

            if (suffixMinLength[n - i - 1] > suffixMinLength[n - i]) {
                suffixMinLength[n - i - 1] = suffixMinLength[n - i];
            }
        }

        boolean flag = true;
        int minLength = Integer.MAX_VALUE;
        for (int i = 1; i < n; ++i) {
            if (prefixMinLength[i - 1] == Integer.MAX_VALUE) continue;
            if (suffixMinLength[i] == Integer.MAX_VALUE) continue;
            flag = false;

            int sum = prefixMinLength[i - 1] + suffixMinLength[i];
            if (minLength > sum) {
                minLength = sum;
            }
        }

        if (flag) return -1;

        return minLength;
    }
}