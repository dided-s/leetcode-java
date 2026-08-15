package easy._3090_Maximum_Length_Substring_With_TwoOccurrences;

import annotations.Easy;

@Easy
public class Solution {

    public int maximumLengthSubstring(String s) {
        int[] englishLowerCase = new int[26];

        int k = 2;
        int left = 0;
        int right = 0;
        int max = 0;
        char ch;

        while (right < s.length()) {
            ch = s.charAt(right);
            englishLowerCase[ch - 'a']++;

            while (englishLowerCase[ch - 'a'] > k) {
                englishLowerCase[s.charAt(left) - 'a']--;
                left++;
            }

            if (right - left + 1 > max) {
                max = right - left + 1;
            }

            right++;
        }

        return max;
    }
}