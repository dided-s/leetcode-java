package medium._2333_Minimum_Sum_of_Squared_Difference;

import annotations.Medium;

@Medium
public class Solution {

    public long minSumSquareDiff(int[] nums1, int[] nums2, int k1, int k2) {
        int[] freq = new int[200001];

        for (int i = 0; i < nums1.length; i++) {
            freq[Math.abs(nums1[i] - nums2[i])]++;
        }

        int maxIndex = 0;

        for (int i = freq.length - 1; i >= 0; i--) {
            if (freq[i] > 0) {
                maxIndex = i;
                break;
            }
        }

        int k = k1 + k2;

        while (k > 0) {
            if (maxIndex == 0) return 0;
            if (k >= freq[maxIndex]) {
                k -= freq[maxIndex];

                freq[maxIndex - 1] += freq[maxIndex];
                freq[maxIndex] = 0;

            } else {
                freq[maxIndex - 1] += k;
                freq[maxIndex] -= k;

                k = 0;
            }

            maxIndex--;
        }

        long answer = 0;
        for (int i = 0; i < freq.length; i++) {
            if (freq[i] == 0) {
                continue;
            }
            answer += freq[i] * ((long) i * i);
        }

        return answer;
    }
}