package hard._0032_Longest_Valid_Parentheses;

import annotations.Hard;

import java.util.ArrayDeque;
import java.util.Deque;

@Hard
public class Solution {

    public int longestValidParentheses(String s) {
        int maxLength = 0;

        Deque<Integer> indexes = new ArrayDeque<>();
        indexes.push(-1);

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == '(') {
                indexes.push(i);
            } else {
                if (!indexes.isEmpty()) {
                    indexes.pop();
                    if (!indexes.isEmpty()) {
                        maxLength = Math.max(maxLength, i - indexes.peek());
                    } else {
                        indexes.push(i);
                    }
                }
            }
        }

        return maxLength;
    }
}