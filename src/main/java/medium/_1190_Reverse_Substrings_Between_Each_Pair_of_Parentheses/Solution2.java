package medium._1190_Reverse_Substrings_Between_Each_Pair_of_Parentheses;

import annotations.Medium;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Queue;

@Medium
class Solution2 {

    public String reverseParentheses(String s) {
        Deque<Character> stack = new ArrayDeque<>();
        Queue<Character> queue = new ArrayDeque<>();

        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == ')') {
                while (!stack.isEmpty() && stack.peek() != '(') {
                    queue.offer(stack.pop());
                }
                stack.pop();
                while (!queue.isEmpty() && queue.peek() != '(') {
                    stack.push(queue.poll());
                }
                queue.poll();
            } else {
                stack.push(s.charAt(i));
            }
        }

        StringBuilder sb = new StringBuilder();
        while (!stack.isEmpty()) {
            sb.append(stack.pollLast());
        }

        return sb.toString();
    }
}