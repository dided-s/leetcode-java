package medium._0151_Reverse_Words_in_a_String;

import annotations.LeetCode75;
import annotations.Medium;

@Medium
@LeetCode75("Array / String")
public class Solution2 {

    public String reverseWords(String s) {
        String[] words = s.trim().split("\s+");
        if (words.length == 0) {
            throw new IllegalArgumentException("Empty string");
        }
        StringBuilder result = new StringBuilder();
        result.append(words[words.length - 1]);

        for (int i = words.length - 2; i >= 0; i--) {
            result.append(' ');
            result.append(words[i]);
        }

        return result.toString();
    }
}