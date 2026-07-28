package medium._3517_Smallest_Palindromic_Rearrangement_I;

import annotations.Medium;

@Medium
public class Solution {

    public String smallestPalindrome(String s) {
        int[] array = new int[26];

        for (int i = 0; i < s.length() / 2; i++) {
            array[s.charAt(i) - 'a']++;
        }
        String middle = (s.length() % 2 == 0) ? "" : String.valueOf(s.charAt(s.length() / 2));

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < array.length; i++) {
            sb.append(String.valueOf((char) (i + 'a')).repeat(array[i]));
        }

        return sb + middle + sb.reverse();
    }
}