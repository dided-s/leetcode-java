package medium._1541_Minimum_Insertions_to_Balance_a_Parentheses_String;

import annotations.Medium;

import java.util.ArrayDeque;
import java.util.Deque;

@Medium
public class Solution {

    public int minInsertions(String s) {

        s = s.replace("))", "]");
        Deque<Character> stack = new ArrayDeque<>();
        int extras = 0;

        for (char c : s.toCharArray()) {
            if (c == '(') {
                stack.push(c);
            } else {
                if (c == ')') {
                    extras++;
                }
                if (stack.isEmpty()) {
                    extras++;
                } else {
                    stack.pop();
                }
            }
        }

        return extras + stack.size() * 2;
    }
}