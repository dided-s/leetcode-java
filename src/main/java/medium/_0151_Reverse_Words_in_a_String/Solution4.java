package medium._0151_Reverse_Words_in_a_String;

import annotations.Explore;
import annotations.LeetCode75;
import annotations.Medium;

@Medium
@LeetCode75("Array / String")
@Explore("Array and String")
public class Solution4 {

    public String reverseWords(String s) {
        if (s == null) throw new IllegalArgumentException();
        if (s.length() < 2) return s;
        s = " " + s + " ";

        StringBuilder result = new StringBuilder();

        int startIndex = s.length() - 1;
        int endIndex = s.length() - 1;

        while (startIndex >= 0 && endIndex >= 0) {
            if (s.charAt(startIndex) != ' ') {
                startIndex--;
            } else if (startIndex == endIndex) {
                startIndex--;
                endIndex--;
            } else {
                result.append(s, startIndex, endIndex + 1);
                startIndex--;
                endIndex = startIndex;
            }
        }

        return result.deleteCharAt(0).toString();
    }
}