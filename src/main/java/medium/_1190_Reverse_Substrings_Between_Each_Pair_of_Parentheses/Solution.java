package medium._1190_Reverse_Substrings_Between_Each_Pair_of_Parentheses;

import annotations.Medium;

import java.util.ArrayDeque;
import java.util.Deque;

@Medium
class Solution {

    public String reverseParentheses(String s) {
        Deque<Integer> openIndexes = new ArrayDeque<>();
        int[] pairIndexes = new int[s.length()];

        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') {
                openIndexes.push(i);
            } else if (s.charAt(i) == ')') {
                int openIndex = openIndexes.pop();
                pairIndexes[i] = openIndex;
                pairIndexes[openIndex] = i;
            }
        }

        StringBuilder result = new StringBuilder();
        int index = 0;
        int direction = 1;

        while (index < s.length()) {
            if (s.charAt(index) == '(' || s.charAt(index) == ')') {
                index = pairIndexes[index];
                direction *= -1;
            } else {
                result.append(s.charAt(index));
            }
            index += direction;
        }

        return result.toString();
    }
}