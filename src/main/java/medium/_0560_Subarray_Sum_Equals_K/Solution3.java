package medium._0560_Subarray_Sum_Equals_K;

import annotations.Medium;

@Medium
public class Solution3 {

    public int minSumOfLengths(int[] arr, int target) {
        if (arr == null || arr.length == 0) return -1;
        int n = arr.length;
        int[] prefixMinLength = new int[n];
        int[] suffixMinLength = new int[n];

        for (int left = 0; left < n; left++) {
            int sum = 0;
            for (int right = left; right < n; right++) {
                sum += arr[right];
                if (sum == target) {
                    int length = right - left + 1;
                    if (prefixMinLength[right] == 0 || prefixMinLength[right] > length) {
                        prefixMinLength[right] = length;
                    }

                    if (suffixMinLength[left] == 0 || suffixMinLength[left] > length) {
                        suffixMinLength[left] = length;
                    }
                }
            }
        }

        for (int i = 1; i < n; ++i) {
            if (prefixMinLength[i] == 0 || prefixMinLength[i] > prefixMinLength[i - 1]) {
                prefixMinLength[i] = prefixMinLength[i - 1];
            }

            if (suffixMinLength[n - i - 1] == 0 || suffixMinLength[n - i - 1] > suffixMinLength[n - i]) {
                suffixMinLength[n - i - 1] = suffixMinLength[n - i];
            }
        }

        boolean flag = true;
        int minLength = Integer.MAX_VALUE;
        for (int i = 1; i < n; ++i) {
            if (prefixMinLength[i - 1] == 0) continue;
            if (suffixMinLength[i] == 0) continue;
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