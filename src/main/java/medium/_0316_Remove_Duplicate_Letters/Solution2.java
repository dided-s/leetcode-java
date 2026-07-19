package medium._0316_Remove_Duplicate_Letters;

import annotations.Medium;

import java.util.*;

@Medium
public class Solution2 {

    public String removeDuplicateLetters(String s) {
        Map<Character, Integer> freq = new HashMap<>();

        for (char c : s.toCharArray()) {
            freq.put(c, freq.getOrDefault(c, 0) + 1);
        }

        Deque<Character> stack = new ArrayDeque<>();
        Set<Character> inStack = new HashSet<>();

        for (char c : s.toCharArray()) {
            while (!inStack.contains(c) && !stack.isEmpty() && stack.peek() > c && freq.get(stack.peek()) > 0) {
                inStack.remove(stack.peek());
                stack.pop();
            }

            freq.put(c, freq.get(c) - 1);

            if (!inStack.contains(c)) {
                stack.push(c);
                inStack.add(c);
            }
        }

        StringBuilder sb = new StringBuilder();
        while (!stack.isEmpty()) {
            sb.append(stack.pop());
        }

        return sb.reverse().toString();
    }
}