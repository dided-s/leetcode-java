package medium._1657_Determine_if_Two_Strings_Are_Close;

import annotations.LeetCode75;
import annotations.Medium;

import java.util.Arrays;

@Medium
@LeetCode75("Hash Map / Set")
public class Solution {

    public boolean closeStrings(String word1, String word2) {
        if (word1.length() != word2.length()) {
            return false;
        }

        int[] letterMap1 = new int[26];
        int[] letterMap2 = new int[26];

        for (char c : word1.toCharArray()) {
            letterMap1[c - 'a']++;
        }
        for (char c : word2.toCharArray()) {
            letterMap2[c - 'a']++;
        }
        for (int i = 0; i < 26; i++) {
            if ((letterMap1[i] == 0 && letterMap2[i] != 0) || (letterMap1[i] != 0 && letterMap2[i] == 0)) {
                return false;
            }
        }
        Arrays.sort(letterMap1);
        Arrays.sort(letterMap2);

        return Arrays.equals(letterMap1, letterMap2);
    }

}