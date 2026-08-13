package medium._0424_Longest_Repeating_Character_Replacement;

import annotations.Medium;

@Medium
public class Solution2 {

    public int characterReplacement(String s, int k) {
        if (s == null || s.length() == 0) return 0;

        int maxLength = 0;
        int currentLength = 0;

        for (int i = 0; i < 26; i++) {
            currentLength = characterReplacement(s, k, (char) ('A' + i));
            if (currentLength > maxLength) {
                maxLength = currentLength;
            }
        }
        return maxLength;
    }

    public int characterReplacement(String s, int k, char current) {
        int left = 0;
        int right = 0;

        int nonCurrent = 0;
        int maxLength = 0;

        while (right < s.length()) {
            if (s.charAt(right) != current) {
                nonCurrent++;
            }

            while (nonCurrent > k) {
                if (s.charAt(left) != current) {
                    nonCurrent--;
                }
                left++;
            }

            if (right - left + 1 > maxLength) {
                maxLength = right - left + 1;
            }

            right++;
        }

        return maxLength;
    }
}