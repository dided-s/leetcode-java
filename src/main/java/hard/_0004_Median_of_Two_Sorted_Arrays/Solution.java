package hard._0004_Median_of_Two_Sorted_Arrays;

import annotations.Hard;

@Hard
public class Solution {

    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        // Prepare
        int n1 = (nums1 != null) ? nums1.length : 0;
        int n2 = (nums2 != null) ? nums2.length : 0;

        if (n1 > n2) return findMedianSortedArrays(nums2, nums1);

        if (n1 == 0 && n2 == 0) return 0;
        if (n1 == 0) return nums2[(n2 - 1) / 2] * 0.5 + nums2[n2 / 2] * 0.5;

        //
        int left = 0;
        int right = n1;

        while (left < right) {
            int i = (left + right) / 2;
            int j = (n1 + n2) / 2 - i;

            if (nums1[i] < nums2[j - 1]) {
                left = i + 1;
            } else {
                right = i;
            }
        }

        int first = left;
        int second = (n1 + n2) / 2 - left;

        int shorterLeft = first == 0 ? Integer.MIN_VALUE : nums1[first - 1];
        int shorterRight = first == n1 ? Integer.MAX_VALUE : nums1[first];

        int longerLeft = second == 0 ? Integer.MIN_VALUE : nums2[second - 1];
        int longerRight = second == n2 ? Integer.MAX_VALUE : nums2[second];

        if ((n1 + n2) % 2 == 1) {
            return Math.min(shorterRight, longerRight);
        } else {
            return Math.max(shorterLeft, longerLeft) * 0.5 + Math.min(shorterRight, longerRight) * 0.5;
        }
    }
}