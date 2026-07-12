package medium._2390_Removing_Stars_From_a_String;

import annotations.LeetCode75;
import annotations.Medium;

@Medium
@LeetCode75("Stack")
public class Solution {

    public String removeStars(String s) {
        StringBuilder sb = new StringBuilder();

        for (char c : s.toCharArray()) {
            if (c == '*') {
                sb.setLength(sb.length() - 1);
            } else {
                sb.append(c);
            }
        }

        return sb.toString();
    }
}