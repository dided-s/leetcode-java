package medium._0560_Subarray_Sum_Equals_K;

import annotations.Medium;

import java.util.Arrays;

@Medium
public class Solution {

    public int minSumOfLengths(int[] arr, int target) {
        if (arr == null || arr.length == 0) return -1;

        int n = arr.length;
        int[] prefixMinLength = new int[n];
        int[] suffixMinLength = new int[n];

        Arrays.fill(prefixMinLength, Integer.MAX_VALUE);
        Arrays.fill(suffixMinLength, Integer.MAX_VALUE);

        // 1. Скользящее окно слева направо → prefixMinLength
        int left = 0, sum = 0;
        int minLen = Integer.MAX_VALUE;

        for (int right = 0; right < n; right++) {
            sum += arr[right];

            while (sum > target && left <= right) {
                sum -= arr[left];
                left++;
            }

            if (sum == target) {
                int len = right - left + 1;
                minLen = Math.min(minLen, len);
            }

            prefixMinLength[right] = minLen;
        }

        // 2. Скользящее окно справа налево → suffixMinLength
        int right = n - 1;
        sum = 0;
        minLen = Integer.MAX_VALUE;

        for (int left2 = n - 1; left2 >= 0; left2--) {
            sum += arr[left2];

            while (sum > target && left2 <= right) {
                sum -= arr[right];
                right--;
            }

            if (sum == target) {
                int len = right - left2 + 1;
                minLen = Math.min(minLen, len);
            }

            suffixMinLength[left2] = minLen;
        }

        // 3. Найти минимальную сумму двух непересекающихся подмассивов
        int result = Integer.MAX_VALUE;

        for (int i = 0; i < n - 1; i++) {
            if (prefixMinLength[i] != Integer.MAX_VALUE && suffixMinLength[i + 1] != Integer.MAX_VALUE) {
                result = Math.min(result, prefixMinLength[i] + suffixMinLength[i + 1]);
            }
        }

        return result == Integer.MAX_VALUE ? -1 : result;
    }
}