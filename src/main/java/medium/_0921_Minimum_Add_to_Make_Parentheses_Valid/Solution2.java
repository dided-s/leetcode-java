package medium._0921_Minimum_Add_to_Make_Parentheses_Valid;

import annotations.Medium;

import java.util.ArrayDeque;
import java.util.Deque;

@Medium
class Solution2 {
    public int minAddToMakeValid(String s) {
        Deque<Character> stack = new ArrayDeque<>();

        for (char c : s.toCharArray()) {
            if (stack.isEmpty()) {
                stack.push(c);
            } else {
                char peek = stack.peek();
                if (peek == '(' && c == ')') {
                    stack.pop();
                } else {
                    stack.push(c);
                }
            }
        }

        return stack.size();
    }
}