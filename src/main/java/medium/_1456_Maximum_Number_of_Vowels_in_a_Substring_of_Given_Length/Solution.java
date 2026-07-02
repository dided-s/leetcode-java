package medium._1456_Maximum_Number_of_Vowels_in_a_Substring_of_Given_Length;

import annotations.LeetCode75;
import annotations.Medium;

@Medium
@LeetCode75("Sliding Window")
public class Solution {

    public int maxVowels(String s, int k) {
        int currentVowelCount = 0;

        for (int i = 0; i < s.length() && i < k; i++) {
            if (isVowel(s.charAt(i))) {
                currentVowelCount++;
            }
        }

        int maximumVowelsCount = currentVowelCount;

        for (int i = k; i < s.length(); i++) {
            if (isVowel(s.charAt(i - k))) {
                currentVowelCount--;
            }
            if (isVowel(s.charAt(i))) {
                currentVowelCount++;
                if (currentVowelCount > maximumVowelsCount) {
                    maximumVowelsCount = currentVowelCount;
                }
            }
        }

        return maximumVowelsCount;
    }

    public static boolean isVowel(char c) {
        return c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u' ||
                c == 'A' || c == 'E' || c == 'I' || c == 'O' || c == 'U';
    }
}