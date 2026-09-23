package medium._1658_Minimum_Operations_to_Reduce_X_to_Zero;

import annotations.Medium;

import java.util.Arrays;

@Medium
public class Solution2 {

    public int minOperations(int[] nums, int x) {
        int n = nums.length;
        if (nums[0] == x || nums[n - 1] == x) {
            return 1;
        }

        int minCounts = Integer.MAX_VALUE;

        int[] prefixSum = new int[n];
        int[] suffixSum = new int[n];

        prefixSum[0] = nums[0];
        suffixSum[n - 1] = nums[n - 1];
        for (int i = 1; i < n; i++) {
            prefixSum[i] = prefixSum[i - 1] + nums[i];
            suffixSum[n - 1 - i] = suffixSum[n - i] + nums[n - 1 - i];

            if (prefixSum[i] == x) {
                minCounts = Math.min(minCounts, i + 1);
            }
            if (suffixSum[n - 1 - i] == x) {
                minCounts = Math.min(minCounts, i + 1);
            }
        }

        System.out.println(Arrays.toString(prefixSum));
        System.out.println(Arrays.toString(suffixSum));

        int right = n - 1;

        for (int left = 0; left < n; left++) {
            if (prefixSum[left] > x) break;
            if (prefixSum[left] == x) {
                minCounts = Math.min(minCounts, left + 1);
                continue;
            }

            if (prefixSum[left] + suffixSum[right] < x) {
                while (left < right && prefixSum[left] + suffixSum[right] < x) {
                    right--;
                }
            } else {
                while (right < n - 1 && prefixSum[left] + suffixSum[right] > x) {
                    right++;
                }
            }

            if (left != right && prefixSum[left] + suffixSum[right] == x) {
                minCounts = Math.min(minCounts, left + 1 + (n - right));
            }
        }

        if (minCounts == Integer.MAX_VALUE) return -1;

        return minCounts;
    }
}