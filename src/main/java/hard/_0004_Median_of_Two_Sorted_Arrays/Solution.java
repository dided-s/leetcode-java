package hard._0004_Median_of_Two_Sorted_Arrays;

import annotations.Hard;

@Hard
public class Solution {

    public double findMedianSortedArrays(int[] shorterNums, int[] longerNums) {
        // Prepare
        int shorterLength = (shorterNums != null) ? shorterNums.length : 0;
        int longerLength = (longerNums != null) ? longerNums.length : 0;

        // swap nums if first is longer
        if (shorterLength > longerLength) return findMedianSortedArrays(longerNums, shorterNums);

        if (shorterLength == 0 && longerLength == 0) return 0;
        if (shorterLength == 0) return longerNums[(longerLength - 1) / 2] * 0.5 + longerNums[longerLength / 2] * 0.5;

        int left = 0;
        int right = shorterLength;

        while (left < right) {
            int i = (left + right) / 2;
            int j = (shorterLength + longerLength) / 2 - i;

            if (shorterNums[i] < longerNums[j - 1]) {
                left = i + 1;
            } else {
                right = i;
            }
        }

        int first = left;
        int second = (shorterLength + longerLength) / 2 - left;

        int shorterLeft = first == 0 ? Integer.MIN_VALUE : shorterNums[first - 1];
        int shorterRight = first == shorterLength ? Integer.MAX_VALUE : shorterNums[first];

        int longerLeft = second == 0 ? Integer.MIN_VALUE : longerNums[second - 1];
        int longerRight = second == longerLength ? Integer.MAX_VALUE : longerNums[second];

        if ((shorterLength + longerLength) % 2 == 1) {
            return Math.min(shorterRight, longerRight);
        } else {
            return Math.max(shorterLeft, longerLeft) * 0.5 + Math.min(shorterRight, longerRight) * 0.5;
        }
    }
}