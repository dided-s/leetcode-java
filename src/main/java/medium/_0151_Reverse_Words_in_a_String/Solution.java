package medium._0151_Reverse_Words_in_a_String;

import annotations.LeetCode75;
import annotations.Medium;

@Medium
@LeetCode75("Array / String")
public class Solution {

    public String reverseWords(String s) {
        if (s == null) throw new IllegalArgumentException();
        if (s.length() < 2) return s;
        s = " " + s + " ";

        StringBuilder result = new StringBuilder();

        int i = s.length() - 1;
        int j = s.length() - 1;

        while (i >= 0 && j >= 0) {
            if (s.charAt(i) != ' ') {
                i--;
            } else if (i == j) {
                i--;
                j--;
            } else {
                result.append(s, i, j + 1);
                i--;
                j = i;
            }
        }

        return result.deleteCharAt(0).toString();
    }
}