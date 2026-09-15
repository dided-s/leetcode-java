package hard._2472_Maximum_Number_of_Non_overlapping_Palindrome_Substrings;

import annotations.Hard;

import java.util.ArrayList;
import java.util.List;

@Hard
public class Solution2 {

    public int maxPalindromes(String s, int k) {
        List<int[]> intervals = fillIntervalList(s, k);

        // Сортируем по правому концу интервала
        intervals.sort((a, b) -> Integer.compare(a[1], b[1]));

        int count = 0;
        int lastEnd = Integer.MIN_VALUE;

        for (int[] interval : intervals) {
            // Если начало текущего > конца последнего выбранного — берём его
            if (interval[0] > lastEnd) {
                count++;
                lastEnd = interval[1];
            }
        }

        return count;

    }

    public List<int[]> fillIntervalList(String s, int k) {
        List<int[]> intervals = new ArrayList<>();

        for (int i = 0; i < s.length(); i++) {
            if (k % 2 == 1) {
                if (isPalindomeCenter(s, i, i, k)) {
                    intervals.add(new int[]{i - (k / 2), i + (k / 2)});
                } else if (isPalindomeCenter(s, i, i + 1, k)) {
                    intervals.add(new int[]{i - (k / 2), i + (k / 2) + 1});
                }
            } else {
                if (isPalindomeCenter(s, i, i + 1, k)) {
                    intervals.add(new int[]{i - ((k - 1) / 2), i + ((k - 1) / 2) + 1});
                } else if (isPalindomeCenter(s, i, i, k)) {
                    intervals.add(new int[]{i - (k / 2), i + (k / 2)});
                }
            }
        }

        return intervals;
    }

    public boolean isPalindomeCenter(String s, int left, int right, int k) {
        while (left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
            if (right - left + 1 >= k) {
                return true;
            }

            left--;
            right++;
        }

        return false;
    }
}