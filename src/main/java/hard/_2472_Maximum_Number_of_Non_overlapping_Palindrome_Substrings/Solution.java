package hard._2472_Maximum_Number_of_Non_overlapping_Palindrome_Substrings;

import annotations.Hard;

import java.util.ArrayList;
import java.util.List;

@Hard
public class Solution {

    public int maxPalindromes(String s, int k) {
        List<int[]> intervals = fillIntervalList(s, k);

        intervals.sort((a, b) -> Integer.compare(a[1], b[1]));

        int count = 0;
        int lastEnd = Integer.MIN_VALUE;

        for (int[] interval : intervals) {
            if (interval[0] > lastEnd) {
                count++;
                lastEnd = interval[1];
            }
        }

        return count;

    }

    public List<int[]> fillIntervalList(String s, int needSize) {
        List<int[]> intervals = new ArrayList<>();

        int left;
        int right;

        for (int i = 0; i < s.length(); i++) {
            if ((left = leftIndexPalindomeFromCenter(s, i, needSize)) != -1) {
                right = left + needSize - 1;
                intervals.add(new int[]{left, right});
            } else if ((left = leftIndexPalindomeFromCenter(s, i, needSize + 1)) != -1) {
                right = left + needSize;
                intervals.add(new int[]{left, right});
            }
        }

        return intervals;
    }

    public int leftIndexPalindomeFromCenter(String s, int centerIndex, int needSize) {
        int left = centerIndex;
        int right = (needSize % 2 == 1) ? centerIndex : centerIndex + 1;

        while (left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
            if (right - left + 1 >= needSize) {
                return left;
            }

            left--;
            right++;
        }

        return -1;
    }
}