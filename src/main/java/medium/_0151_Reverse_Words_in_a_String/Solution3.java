package medium._0151_Reverse_Words_in_a_String;

import annotations.Explore;
import annotations.LeetCode75;
import annotations.Medium;

@Medium
@LeetCode75("Array / String")
@Explore("Array and String")
public class Solution3 {

    public String reverseWords(String s) {
        if (s == null) throw new IllegalArgumentException();

        s = s.trim() + " ";
        if (s.length() < 2) return s;

        StringBuilder result = new StringBuilder();

        int startWordIndex = 0;
        int index = 1;


        while (index < s.length()) {
            if (s.charAt(index) == ' ') {
                if (!(s.charAt(index - 1) == ' ')) {
                    for (int i = index - 1; i >= startWordIndex; i--) {
                        result.append(s.charAt(i));
                    }
                }
            } else {
                if (s.charAt(index - 1) == ' ') {
                    startWordIndex = index;
                    result.append(" ");
                }
            }
            index++;
        }

        return result.reverse().toString();
    }
}