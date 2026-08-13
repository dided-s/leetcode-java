package medium._0424_Longest_Repeating_Character_Replacement;

import annotations.Medium;

@Medium
public class Solution {

    public int characterReplacement(String s, int k) {
        if (s == null || s.length() == 0) return 0;

        int[] freq = new int[26];

        int left = 0;
        int right = 0;
        int maxFreq = 0;
        int maxLen = 0;

        while (right < s.length()) {
            char current = s.charAt(right);
            freq[current - 'A']++;

            maxFreq = Math.max(maxFreq, freq[current - 'A']);

            int windowLen = right - left + 1;
            int neededReplacements = windowLen - maxFreq;

            if (neededReplacements > k) {
                char leftChar = s.charAt(left);
                freq[leftChar - 'A']--;
                left++;
            }

            maxLen = Math.max(maxLen, right - left + 1);
            right++;
        }

        return maxLen;
    }
}